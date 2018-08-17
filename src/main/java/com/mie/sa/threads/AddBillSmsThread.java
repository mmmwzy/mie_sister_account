package com.mie.sa.threads;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.mie.sa.constant.Constant;
import com.mie.sa.entity.*;
import com.mie.sa.service.BillDispatchAuditService;
import com.mie.sa.service.SmsService;
import com.mie.sa.service.UserService;
import net.sf.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * 新增账单短信通知线程
 * Created by WangRicky on 2018/7/19.
 */
public class AddBillSmsThread implements Runnable {

    protected Logger logger = LoggerFactory.getLogger(AddBillSmsThread.class);

    private UserService userService;

    private SmsService smsService;

    private BillDispatchAuditService billDispatchAuditService;

    private String uid;

    private Bill bill;

    public AddBillSmsThread(UserService userService, String uid, Bill bill, SmsService smsService, BillDispatchAuditService billDispatchAuditService){
        this.userService = userService;
        this.uid = uid;
        this.bill = bill;
        this.smsService = smsService;
        this.billDispatchAuditService = billDispatchAuditService;
    }

    @Override
    public void run() {
        logger.info("【新增账单短信通知线程】开始执行新增账单短信通知线程,新增人ID[" + uid + "],账单ID为[" + bill.getId() + "]");
        UserExample userExample = new UserExample();
        List<User> users = userService.queryAllObjByExample(userExample);
        String billId = bill.getId();
        for (User user : users){
            try {
                if (user.getId().equalsIgnoreCase(uid)){
                    //{1}您好！您已成功申请账单编号为{2}，账单描述为{3},金额为{4}的报销申请，系统已向审核人下发通知，请耐心等待！
                    String billIdF = billId.substring(billId.length()-4);
                    String[] params = {user.getUserName(),  "*****" + billIdF, bill.getBillDescribe(), bill.getBillAmount().toString()};
                    SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
                    SmsSingleSenderResult result = ssender.sendWithParam("86", user.getUserPhone(),
                            Constant.QCLOUD_SMS_TEMPLATEID_APPLY_SUCCESS, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                }else{

                    BillDispatchAudit billDispatchAudit = new BillDispatchAudit();
                    billDispatchAudit.setAuditUserId(user.getId());
                    billDispatchAudit.setAuditUserName(user.getUserName());
                    billDispatchAudit.setBillId(billId);
                    billDispatchAudit.setAuditStatusName("待审核");
                    billDispatchAuditService.addObj(billDispatchAudit);

                    //{1}您好！{2}发起的一笔金额为{3}，账单描述为{4}的报销！请尽快前往小程序审核专栏进行审核！或回复{5}快速同意该笔报销
                    String code = getCode();
                    String[] params = {user.getUserName(),  bill.getBillUserName(), bill.getBillAmount().toString(), bill.getBillDescribe(), code };
                    SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
                    SmsSingleSenderResult result = ssender.sendWithParam("86", user.getUserPhone(),
                            Constant.QCLOUD_SMS_TEMPLATEID_EXAMINE_NOTICE, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信

                    Sms sms = new Sms();
                    sms.setBillId(billId);
                    sms.setSmsRandomCode(code);
                    sms.setUserId(user.getId());
                    sms.setUserPhone(user.getUserPhone());
                    sms.setSmsId(result.sid);
                    smsService.addObj(sms);
                }
            }catch (Exception e) {
                logger.error("【新增账单短信通知线程】请求腾讯云短信服务失败,新增人ID[" + uid + "],账单ID为[" + bill.getId() + "]");
            }

        }


    }

    public String getCode(){
        Random rad=new Random();
        String code = rad.nextInt(10000)+"";

        SmsExample smsExample = new SmsExample();
        smsExample.createCriteria().andSmsRandomCodeEqualTo(code).andSmsStatusEqualTo(new Byte("2"));
        List<Sms> smss = smsService.queryAllObjByExample(smsExample);
        if (smss.size() > 0){
            code = getCode();
        }else{
            return code;
        }
        return code;
    }
}
