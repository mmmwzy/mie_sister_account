package com.mie.sa.web.controller;

import com.mie.base.core.entity.PageView;
import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.exception.CommonException;
import com.mie.base.core.utils.CriteriaUtils;
import com.mie.base.core.utils.query.QueryParamWapper;
import com.mie.sa.entity.Bill;
import com.mie.sa.entity.BillExample;
import com.mie.sa.entity.Book;
import com.mie.sa.service.*;
import com.mie.sa.threads.AddBillSmsThread;
import com.mie.sa.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(value="?????")
@Controller
@RequestMapping("bill")
public class BillController {
    @Resource
    protected BillService billService;
    @Resource
    protected BookService bookService;
    @Resource
    protected UserService userService;
    @Resource
    protected SmsService smsService;
    @Resource
    protected BillDispatchAuditService billDispatchAuditService;

    @ApiOperation(httpMethod="POST", value="???????")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Bill bill, HttpServletRequest request) {
        if (bill.getBillAmount().compareTo(new BigDecimal("0.00")) == 0){
            throw new CommonException("记账金额不能为0.00");
        }
        if (StringUtils.isBlank(bill.getBillDescribe())){
            throw new CommonException("账单描述不能为空");
        }
        String userName = request.getAttribute("userName") + "";
        String uid = request.getAttribute("uid") + "";
        bill.setBillUserId(uid);
        bill.setBillUserName(userName);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = sdf.parse(bill.getBillDataView());
            bill.setBillDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.billService.addObj(bill);
        Book book = bookService.queryObjById("20180711040102-bd637a01960945d78");
        if (bill.getBillType() == 1){
            book.setBookBalance(book.getBookBalance().subtract(bill.getBillAmount()) );
        }else{
            bill.setBillContextType(new Byte("6"));
            book.setBookBalance(book.getBookBalance().add(bill.getBillAmount()) );
        }
        bookService.modifyObj(book);
        if(bill.getBillDispatchType() == 1){
            AddBillSmsThread addBillSmsThread = new AddBillSmsThread(userService, uid, bill, smsService, billDispatchAuditService);
            Thread thread = new Thread(addBillSmsThread);
            thread.start();
        }
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
        example.setOrderByClause("create_time desc");
        if (wapper != null) {
            BillExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<Bill> pageData = this.billService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }

    @ApiOperation(httpMethod="POST", value="???????")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "pageNo",required = false,value = "???", paramType = "query", dataType = "String", defaultValue = "0" ),
            @ApiImplicitParam( name = "pageSize", required = false, value = "????", paramType = "query", dataType = "String", defaultValue = "10" ),
            @ApiImplicitParam( name = "wapper", required = false, value = "????,?????? Bill", paramType = "body", dataType = "QueryParamWapper" )
    })
    @RequestMapping(method = RequestMethod.POST, value = "service/findUserBillByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Bill>> findUserBillByPage(
            @RequestParam(defaultValue="0") int pageNo,
            @RequestParam(defaultValue="10") int pageSize,
            @RequestBody(required=false) QueryParamWapper wapper,
            HttpServletRequest request) {
        String userId = request.getAttribute("uid") + "";
        BillExample example = new BillExample();
        example.setPageView(new PageView<Bill>(pageNo, pageSize));
        example.setOrderByClause("create_time desc");
        BillExample.Criteria criteria = example.createCriteria();
        criteria.andBillUserIdEqualTo(userId);
        if (wapper != null) {

            CriteriaUtils.addCriterion(criteria, wapper);
        }

        PageView<Bill> pageData = this.billService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/test")
    public void test(){
        String jwt = JWTUtil.createJWT("111","2222");
        System.out.println(jwt);
        try {
            Claims claims= JWTUtil.parseJWT(jwt);
            System.out.println(claims.getSubject());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}