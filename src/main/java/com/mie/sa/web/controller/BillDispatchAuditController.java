package com.mie.sa.web.controller;

import com.mie.base.core.entity.PageView;
import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.exception.CommonException;
import com.mie.base.core.utils.CriteriaUtils;
import com.mie.base.core.utils.ResponseCode;
import com.mie.base.core.utils.query.QueryParamWapper;
import com.mie.sa.entity.Bill;
import com.mie.sa.entity.BillDispatchAudit;
import com.mie.sa.entity.BillDispatchAuditExample;
import com.mie.sa.entity.BillExample;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="sa_bill_dispatch_audit")
@Controller
@RequestMapping("billDispatchAudit")
public class BillDispatchAuditController {
    @Resource
    protected BillDispatchAuditService billDispatchAuditService;

    @Resource
    protected BillService billService;

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