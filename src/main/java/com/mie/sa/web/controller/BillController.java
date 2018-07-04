package com.mie.sa.web.controller;

import com.mie.base.core.entity.PageView;
import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.exception.CommonException;
import com.mie.base.core.utils.CriteriaUtils;
import com.mie.base.core.utils.ResponseCode;
import com.mie.base.core.utils.query.QueryParamWapper;
import com.mie.sa.entity.Bill;
import com.mie.sa.entity.BillExample;
import com.mie.sa.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
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

@Api(value="?????")
@Controller
@RequestMapping("bill")
public class BillController {
    @Resource
    protected BillService billService;

    @ApiOperation(httpMethod="POST", value="???????")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Bill bill) {
        this.billService.addObj(bill);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Bill bill) {
        if (StringUtils.isBlank(bill.getId())) {
            throw new CommonException("id ???????");
        }
        this.billService.modifyObj(bill);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("????,id????");
        }
        this.billService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="???????")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "???", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "????", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "????,?????? Bill", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Bill>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BillExample example = new BillExample();
        example.setPageView(new PageView<Bill>(pageNo, pageSize));
        
        if (wapper != null) {
            BillExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<Bill> pageData = this.billService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}