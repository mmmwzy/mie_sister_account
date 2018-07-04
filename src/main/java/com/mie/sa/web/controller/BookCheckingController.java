package com.mie.sa.web.controller;

import com.mie.base.core.entity.PageView;
import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.exception.CommonException;
import com.mie.base.core.utils.CriteriaUtils;
import com.mie.base.core.utils.ResponseCode;
import com.mie.base.core.utils.query.QueryParamWapper;
import com.mie.sa.entity.BookChecking;
import com.mie.sa.entity.BookCheckingExample;
import com.mie.sa.service.BookCheckingService;
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

@Api(value="sa_book_checking")
@Controller
@RequestMapping("bookChecking")
public class BookCheckingController {
    @Resource
    protected BookCheckingService bookCheckingService;

    @ApiOperation(httpMethod="POST", value="??sa_book_checking")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BookChecking bookChecking) {
        this.bookCheckingService.addObj(bookChecking);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BookChecking bookChecking) {
        if (StringUtils.isBlank(bookChecking.getId())) {
            throw new CommonException("id ???????");
        }
        this.bookCheckingService.modifyObj(bookChecking);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("????,id????");
        }
        this.bookCheckingService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="??sa_book_checking")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "???", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "????", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "????,?????? BookChecking", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<BookChecking>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BookCheckingExample example = new BookCheckingExample();
        example.setPageView(new PageView<BookChecking>(pageNo, pageSize));
        
        if (wapper != null) {
            BookCheckingExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<BookChecking> pageData = this.bookCheckingService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}