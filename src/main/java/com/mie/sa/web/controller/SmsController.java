package com.mie.sa.web.controller;

import com.mie.base.core.entity.PageView;
import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.exception.CommonException;
import com.mie.base.core.utils.CriteriaUtils;
import com.mie.base.core.utils.query.QueryParamWapper;
import com.mie.sa.entity.BillDispatchAudit;
import com.mie.sa.entity.BillDispatchAuditExample;
import com.mie.sa.entity.Sms;
import com.mie.sa.entity.SmsExample;
import com.mie.sa.service.BillDispatchAuditService;
import com.mie.sa.service.BillService;
import com.mie.sa.service.SmsService;
import com.mie.sa.threads.ExamineInspectThread;
import com.mie.sa.vo.NoticePaySmsVO;
import com.mie.sa.vo.NoticePaySuccessVO;
import com.mie.sa.vo.SmsCallbackOutVO;
import com.mie.sa.vo.SmsCallbackVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mie.sa.service.UserService;

@Api(value="sa_sms")
@Controller
@RequestMapping("sms")
public class SmsController {
    private static Logger logger = LoggerFactory.getLogger(SmsController.class);

    @Resource
    protected SmsService smsService;
    @Resource
    protected UserService userService;
    @Resource
    protected BillService billService;
    @Resource
    protected BillDispatchAuditService billDispatchAuditService;

    @ApiOperation(httpMethod="POST", value="创建sa_sms")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Sms sms) {
        this.smsService.addObj(sms);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Sms sms) {
        if (StringUtils.isBlank(sms.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.smsService.modifyObj(sms);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.smsService.deleteObjById(id);
        return ResponseResult.success();
    }

    //发送缴费通知短信
    @RequestMapping(method = RequestMethod.POST, value = "public/noticePaySms")
    @ResponseBody
    public ResponseResult<String> noticePaySms(@RequestBody(required=true) NoticePaySmsVO NoticePaySmsVO) {
        if (NoticePaySmsVO == null) {
            throw new CommonException("参数不能为空");
        }
        if (StringUtils.isBlank(NoticePaySmsVO.getOriginatorId())){
            throw new CommonException("发起人ID不能为空");
        }
        smsService.noticeSms(NoticePaySmsVO);
        return ResponseResult.success();
    }

    //发送缴费通知短信
    @RequestMapping(method = RequestMethod.POST, value = "public/noticePaySuccess")
    @ResponseBody
    public ResponseResult<String> noticePaySuccess(@RequestBody(required=true) NoticePaySuccessVO noticePaySuccessVO) {
        if (noticePaySuccessVO == null) {
            throw new CommonException("参数不能为空");
        }
        if (StringUtils.isBlank(noticePaySuccessVO.getUserId())){
            throw new CommonException("缴纳人ID不能为空");
        }
        smsService.paySuccess(noticePaySuccessVO);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "public/callback")
    @ResponseBody
    public SmsCallbackOutVO callback(@RequestBody(required=false)SmsCallbackVO callbackVO) {
        SmsCallbackOutVO smsCallbackOutVO = new SmsCallbackOutVO("0", "ok");
        SmsExample smsExample = new SmsExample();
        smsExample.createCriteria().andSmsRandomCodeEqualTo(callbackVO.getText())
               .andUserPhoneEqualTo(callbackVO.getMobile())
               .andSmsStatusEqualTo(new Byte("2"));
        List<Sms> smss = smsService.queryAllObjByExample(smsExample);
        if (smss.size() < 1){
           logger.warn("【短信回复回调】SmsRandomCode为[" + callbackVO.getText() + "],UserPhone[" + callbackVO.getMobile() + "]的记录不存在,或已被处理");
           return smsCallbackOutVO;
        }
        Sms sms = smss.get(0);
        BillDispatchAuditExample billDispatchAuditExample = new BillDispatchAuditExample();
        billDispatchAuditExample.createCriteria().andBillIdEqualTo(sms.getBillId()).andAuditUserIdEqualTo(sms.getUserId());
        List<BillDispatchAudit> billDispatchAudits = billDispatchAuditService.queryAllObjByExample(billDispatchAuditExample);
        if (billDispatchAudits.size() < 1){
           logger.warn("【短信回复回调】billid为[" + sms.getBillId() + "],userId为[" + sms.getUserId() + "]的记录不存在");
           return smsCallbackOutVO;
        }
        BillDispatchAudit billDispatchAudit = billDispatchAudits.get(0);
        billDispatchAudit.setAuditStatus(new Byte("1"));
        billDispatchAudit.setAuditStatusName("已通过");
        billDispatchAuditService.modifyObj(billDispatchAudit);

        sms.setSmsStatus(new Byte("1"));
        smsService.modifyObj(sms);

        ExamineInspectThread examineInspectThread = new ExamineInspectThread(billDispatchAuditService, userService, billDispatchAudit, billService);
        Thread thread = new Thread(examineInspectThread);
        thread.start();

        return smsCallbackOutVO;
    }

    @ApiOperation(httpMethod="POST", value="查询sa_sms")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Sms", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Sms>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        SmsExample example = new SmsExample();
        example.setPageView(new PageView<Sms>(pageNo, pageSize));
        
        if (wapper != null) {
            SmsExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<Sms> pageData = this.smsService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}