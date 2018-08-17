package com.mie.sa.service.impl;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.mie.base.core.entity.PageView;
import com.mie.base.utils.date.DateUtils;
import com.mie.sa.constant.Constant;
import com.mie.sa.dao.BillMapper;
import com.mie.sa.dao.SmsMapper;
import com.mie.sa.dao.UserMapper;
import com.mie.sa.entity.Sms;
import com.mie.sa.entity.SmsExample;
import com.mie.sa.entity.*;
import com.mie.sa.service.BookService;
import com.mie.sa.service.SmsService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.mie.sa.vo.NoticePaySmsVO;
import com.mie.sa.vo.NoticePaySuccessVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultSmsService")
public class SmsServiceImpl implements SmsService {
    @Resource
    protected SmsMapper smsMapper;
    @Resource
    protected UserMapper userMapper;
    @Resource
    protected BillMapper billMapper;
    @Resource
    protected BookService bookService;

    @CacheEvict(value={"sms"}, allEntries=true)
    @Override
    public void addObj(Sms t) {
        this.smsMapper.insertSelective(t);
    }

    @CacheEvict(value={"sms"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.smsMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"sms"}, allEntries=true)
    @Override
    public void modifyObj(Sms t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.smsMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="sms", keyGenerator="redisKeyGenerator")
    @Override
    public Sms queryObjById(String id) {
        return this.smsMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="sms", key="'SmsService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Sms> queryAllObjByExample(SmsExample example) {
        return this.smsMapper.selectByExample(example);
    }

    @Cacheable(value="sms", key="'SmsService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Sms> queryObjByPage(SmsExample example) {
        PageView<Sms> pageView = example.getPageView();
        pageView.setQueryResult(this.smsMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Override
    public String noticeSms(NoticePaySmsVO noticePaySmsVO) {
        User user = userMapper.selectByPrimaryKey(noticePaySmsVO.getOriginatorId());
        //腾讯云短信模板ID---缴纳公共资金发起成功通知
        //{1}您好！您发起的缴纳金额{2}元/人，缴纳原因:{3}的公共资金申请已通过！系统已下发通知短信！请耐心等待！
        String[] params = {user.getUserName(), noticePaySmsVO.getPayAmount(), noticePaySmsVO.getPayDescribe()};
        SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
        try{
            ssender.sendWithParam("86", user.getUserPhone(),
                    Constant.QCLOUD_SMS_TEMPLATEID_NOTICE_PAY_APPLY, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        }catch (Exception e){
            e.printStackTrace();
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdNotEqualTo(user.getId());
        List<User> userList = userMapper.selectByExample(userExample);
        for (User temp : userList){
            //腾讯云短信模板ID---缴纳公共资金通知
            //{1}您好！{2}向您申请缴纳{3}元/人的公共资金通知,缴纳原因:{4}！如有疑问请联系管理员！
            String[] payParams = {temp.getUserName(), user.getUserName(), noticePaySmsVO.getPayAmount(), noticePaySmsVO.getPayDescribe()};
            SmsSingleSender paySsender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
            try{
                SmsSingleSenderResult result = paySsender.sendWithParam("86", temp.getUserPhone(),
                        Constant.QCLOUD_SMS_TEMPLATEID_NOTICE_PAY, payParams, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "SUCCESS";
    }

    @Override
    public void paySuccess(NoticePaySuccessVO noticePaySuccessVO) {
        User user = userMapper.selectByPrimaryKey(noticePaySuccessVO.getUserId());
        //腾讯云短信模板ID---缴纳公共资金发起成功通知
        //{1}您好！您发起的缴纳金额{2}元/人，缴纳原因:{3}的公共资金申请已通过！系统已下发通知短信！请耐心等待！
        String[] params = {user.getUserName(), noticePaySuccessVO.getPayAmount(), noticePaySuccessVO.getPayOrderId()};
        SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
        try{
            ssender.sendWithParam("86", user.getUserPhone(),
                    Constant.QCLOUD_SMS_TEMPLATEID_NOTICE_PAY_SUCCESS, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        }catch (Exception e){
            e.printStackTrace();
        }
        //记入账单
        Bill bill = new Bill();
        bill.setBillUserId(user.getId());
        bill.setBillUserName(user.getUserName());
        bill.setBillContextType(Constant.BILL_CONTEXT_TYPE_GGZJ);
        bill.setBillType(Constant.BILL_TYPE_IN);
        bill.setBillDescribe("公共资金");
        bill.setBillAmount(BigDecimal.valueOf(Double.parseDouble(noticePaySuccessVO.getPayAmount())));
        bill.setBillDate(new Date());
        bill.setBillDataView(DateUtils.getCurrentDateTimeNoS());
        bill.setCreateTime(new Date());
        bill.setUpdateTime(new Date());
        bill.setIsDelete(new Byte("0"));
        billMapper.insert(bill);

        Book book = bookService.queryObjById("20180711040102-bd637a01960945d78");
        book.setBookBalance(book.getBookBalance().add(bill.getBillAmount()) );
        bookService.modifyObj(book);
    }
}