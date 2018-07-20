package com.mie.sa.web.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.mie.base.core.entity.PageView;
import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.exception.CommonException;
import com.mie.base.core.utils.CriteriaUtils;
import com.mie.base.core.utils.ResponseCode;
import com.mie.base.core.utils.query.QueryParamWapper;
import com.mie.sa.constant.Constant;
import com.mie.sa.entity.CodePhone;
import com.mie.sa.entity.CodePhoneExample;
import com.mie.sa.service.CodePhoneService;
import com.mie.sa.utils.CheckUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="sa_code_phone")
@Controller
@RequestMapping("codePhone")
public class CodePhoneController {
    @Resource
    protected CodePhoneService codePhoneService;

    @ApiOperation(httpMethod="POST", value="创建sa_code_phone")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody CodePhone codePhone) {
        this.codePhoneService.addObj(codePhone);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody CodePhone codePhone) {
        if (StringUtils.isBlank(codePhone.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.codePhoneService.modifyObj(codePhone);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.codePhoneService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询sa_code_phone")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 CodePhone", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<CodePhone>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        CodePhoneExample example = new CodePhoneExample();
        example.setPageView(new PageView<CodePhone>(pageNo, pageSize));
        
        if (wapper != null) {
            CodePhoneExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<CodePhone> pageData = this.codePhoneService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/sendCode")
    @ResponseBody
    public ResponseResult<String> sendCode(@RequestParam(required=true) String userPhone) {
        if (StringUtils.isBlank(userPhone)) {
            throw new CommonException("userPhone手机号不能为空");
        }
        CheckUtil.isPhone(userPhone);
        Random rad=new Random();
        String code = rad.nextInt(1000000)+"";

        try{
            //您目前正在执行手机绑定操作，验证码为{1}，请于{2}分钟内使用，过期无效！请勿向任何人透露本条验证码信息！
            String[] params = {code, "30"};
            SmsSingleSender ssender = new SmsSingleSender(Constant.QCLOUD_SMS_APPID, Constant.QCLOUD_SMS_APPKEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", userPhone,
                    Constant.QCLOUD_SMS_TEMPLATEID_YANZHENGMA, params, Constant.QCLOUD_SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            if (result.result == 0){
                CodePhone codePhone = new CodePhone();
                codePhone.setPhonecode(code);
                codePhone.setUserphone(userPhone);
                codePhoneService.addObj(codePhone);
                return ResponseResult.success(codePhone.getId());
            }else{
                return ResponseResult.success(result.errMsg);
            }
        }catch (Exception e) {
            // HTTP响应码错误
            e.printStackTrace();
            throw new CommonException("验证码发送失败！");
        }
    }
}