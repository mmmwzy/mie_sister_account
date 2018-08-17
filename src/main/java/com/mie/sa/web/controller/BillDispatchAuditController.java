package com.mie.sa.web.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.mie.base.core.entity.PageView;
import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.exception.CommonException;
import com.mie.base.core.utils.CriteriaUtils;
import com.mie.base.core.utils.ResponseCode;
import com.mie.base.core.utils.query.QueryParamWapper;
import com.mie.sa.constant.Constant;
import com.mie.sa.entity.*;
import com.mie.sa.service.BillDispatchAuditService;
import com.mie.sa.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
import com.mie.sa.service.UserService;

@Api(value="sa_bill_dispatch_audit")
@Controller
@RequestMapping("billDispatchAudit")
public class BillDispatchAuditController {
    private static Logger logger = LoggerFactory.getLogger(BillDispatchAuditController.class);
    @Resource
    protected BillDispatchAuditService billDispatchAuditService;

    @Resource
    protected BillService billService;

    @Resource
    protected UserService userService;

    @ApiOperation(httpMethod="POST", value="??sa_bill_dispatch_audit")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BillDispatchAudit billDispatchAudit) {
        this.billDispatchAuditService.addObj(billDispatchAudit);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BillDispatchAudit billDispatchAudit) {
        if (StringUtils.isBlank(billDispatchAudit.getId())) {
            throw new CommonException("id ???????");
        }
        this.billDispatchAuditService.modifyObj(billDispatchAudit);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/query",consumes ="application/json")
    @ResponseBody
    public ResponseResult<List<BillDispatchAudit>> query(@RequestBody Bill bill, HttpServletRequest request) {

        if (StringUtils.isBlank(bill.getId())) {
            throw new CommonException("账单ID不能为空");
        }

        BillDispatchAuditExample billDispatchAuditExample = new BillDispatchAuditExample();
        billDispatchAuditExample.createCriteria().andBillIdEqualTo(bill.getId());
        List<BillDispatchAudit> billDispatchAuditList = billDispatchAuditService.queryAllObjByExample(billDispatchAuditExample);

        return ResponseResult.success(billDispatchAuditList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("????,id????");
        }
        this.billDispatchAuditService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "public/adminApply")
    @ResponseBody
    public ResponseResult<String> adminApply(@RequestParam(required=true) String billId, @RequestParam(required=true) String orderId) {
        if (StringUtils.isBlank(billId)) {
            throw new CommonException("billId不能为空");
        }
        if (StringUtils.isBlank(orderId)) {
            throw new CommonException("orderId不能为空");
        }
        Bill bill = billService.queryObjById(billId);
        if (bill == null){
            throw new CommonException("billId有误，未查到该条记录");
        }
        bill.setBillDispatchOrder(orderId);
        bill.setBillDispatchStatus(new Byte("2"));
        billService.modifyObj(bill);

        User user = userService.queryObjById(bill.getBillUserId());

        String orderIdHide = orderId.substring(0, 8) + "*****" + orderId.substring(orderId.length() - 4);
        try {
            //{1}您好！您发起的描述为{2}，金额为{3}的报销审核已经通过，请前往绑定的支付宝查收，报销单号为{4}
            String[] params = {bill.getBillUserName(), bill.getBillDescribe(), bill.getBillAmount().toString(), orderIdHide};
            SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", user.getUserPhone(),
                    Constant.QCLOUD_SMS_TEMPLATEID_EXAMINE_SUCCESS, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信

        }catch (Exception e) {
            logger.error("【审核通过报销通知】请求腾讯云短信服务失败,用户ID[" + user.getId() + "],账单ID为[" + bill.getId() + "]");
        }

        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询当前用户还未审核的需审核账单")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "???", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "????", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "????,?????? BillDispatchAudit", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Bill>> findByPage(
            @RequestParam(defaultValue="0") int pageNo,
            @RequestParam(defaultValue="10") int pageSize,
            @RequestBody(required=false) QueryParamWapper wapper,
            HttpServletRequest request) {
        String uid = request.getAttribute("uid") + "";
        BillDispatchAuditExample example = new BillDispatchAuditExample();
        example.setPageView(new PageView<BillDispatchAudit>(pageNo, pageSize));
        example.setOrderByClause("create_time desc");
        BillDispatchAuditExample.Criteria criteria = example.createCriteria();
        criteria.andAuditUserIdEqualTo(uid);
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        //先分页查询为审核记录的未审核订单
        PageView<BillDispatchAudit> pageData = this.billDispatchAuditService.queryObjByPage(example);
        List<BillDispatchAudit> billDispatchAudits = pageData.getQueryResult();
        List<String> billIds = new ArrayList<>();
        for (BillDispatchAudit billDispatchAudit: billDispatchAudits){
            billIds.add(billDispatchAudit.getId());
        }

        BillExample billExample = new BillExample();
        billExample.setOrderByClause("create_time desc");
        billExample.createCriteria().andIdIn(billIds);
        List<Bill> bills = billService.queryAllObjByExample(billExample);

        PageView<Bill> resultData = new PageView<>(pageData.getPageNo(), pageData.getPageSize());
        resultData.setRowCount(pageData.getRowCount());
        resultData.setQueryResult(bills);

        return ResponseResult.success(resultData);
    }
}