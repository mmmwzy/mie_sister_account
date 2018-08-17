package com.mie.sa.threads;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.mie.sa.constant.Constant;
import com.mie.sa.entity.*;
import com.mie.sa.service.BillDispatchAuditService;
import com.mie.sa.service.BillService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mie.sa.service.UserService;

import java.util.List;

/**
 * 审核检查线程
 * Created by WangRicky on 2018/7/19.
 */
public class ExamineInspectThread implements Runnable{
    protected Logger logger = LoggerFactory.getLogger(ExamineInspectThread.class);

    private BillDispatchAuditService billDispatchAuditService;

    private UserService userService;

    private BillService billService;

    private BillDispatchAudit billDispatchAudit;

    public ExamineInspectThread(BillDispatchAuditService billDispatchAuditService, UserService userService,
                                BillDispatchAudit billDispatchAudit, BillService billService){
        this.billDispatchAuditService = billDispatchAuditService;
        this.userService = userService;
        this.billDispatchAudit = billDispatchAudit;
        this.billService = billService;
    }

    @Override
    public void run() {
        logger.info("【审核检查线程】开始执行新增账单短信通知线程,账单ID为[" + billDispatchAudit.getBillId() + "]");
        String billId = billDispatchAudit.getBillId();
        //检查是否全部审核完毕
        BillDispatchAuditExample billDispatchAuditExample = new BillDispatchAuditExample();
        billDispatchAuditExample.createCriteria().andBillIdEqualTo(billId).andAuditStatusEqualTo(new Byte("0"));
        List<BillDispatchAudit> billDispatchAudits = billDispatchAuditService.queryAllObjByExample(billDispatchAuditExample);
        if (billDispatchAudits.size() > 0){
            return;
        }
        Bill bill = billService.queryObjById(billId);
        String uid = bill.getBillUserId();
        User user = userService.queryObjById(uid);
        //检查审核是否全部通过
        billDispatchAuditExample = new BillDispatchAuditExample();
        billDispatchAuditExample.createCriteria().andBillIdEqualTo(billId).andAuditStatusEqualTo(new Byte("2"));
        billDispatchAudits = billDispatchAuditService.queryAllObjByExample(billDispatchAuditExample);
        //审核状态为2（不通过）的条数大于0，执行不通过短信请求
        try {
            if (billDispatchAudits.size() > 0){
                //{1}您好！您申请的描述为{2}，金额为{3}的报销申请不通过，请前往小程序查看详情！
                String[] params = {user.getUserName(), bill.getBillDescribe(), bill.getBillAmount().toString()};
                SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
                SmsSingleSenderResult result = ssender.sendWithParam("86", user.getUserPhone(),
                        Constant.QCLOUD_SMS_TEMPLATEID_EXAMINE_FAILED, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            }else{
                //{1}您好！{2}发起的编号为{3}，金额为{4}的报销申请已通过审核，请尽快前往小程序向{5}账号报销！
                String[] params = {"管理员", user.getUserName(), bill.getId(), bill.getBillAmount().toString(), user.getUserAlipayAccount()};
                SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
                SmsSingleSenderResult result = ssender.sendWithParam("86", "13297087891",
                        Constant.QCLOUD_SMS_TEMPLATEID_REIM_NOTICE, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信

            }
        }catch (Exception e) {
            logger.error("【审核检查线程】请求腾讯云短信服务失败,新增人ID[" + uid + "],账单ID为[" + bill.getId() + "]");
        }

    }
}
