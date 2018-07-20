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
import com.mie.base.utils.UUID.UUIDGenerator;
import com.mie.base.utils.http.HttpGetClient;
import com.mie.base.utils.http.HttpRequestUtils;
import com.mie.sa.constant.Constant;
import com.mie.sa.constant.TipCode;
import com.mie.sa.entity.CodePhone;
import com.mie.sa.entity.CodePhoneExample;
import com.mie.sa.entity.User;
import com.mie.sa.entity.UserExample;
import com.mie.sa.service.CodePhoneService;
import com.mie.sa.service.UserService;
import com.mie.sa.utils.ClientUtils;
import com.mie.sa.utils.JWTUtil;
import com.mie.sa.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="sa_user")
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    protected UserService userService;

    @Resource
    protected CodePhoneService codePhoneService;

    @ApiOperation(httpMethod="POST", value="??sa_user")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody User user) {
        this.userService.addObj(user);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody User user) {
        if (StringUtils.isBlank(user.getId())) {
            throw new CommonException("id ???????");
        }
        this.userService.modifyObj(user);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("????,id????");
        }
        this.userService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/queryInfo")
    @ResponseBody
    public ResponseResult<User> queryInfo(HttpServletRequest request) {
        String uid = request.getAttribute("uid") + "";
        User user = userService.queryObjById(uid);
        user.setWxOpenid("********");
        return ResponseResult.success(user);
    }




    @ApiOperation(httpMethod="POST", value="??sa_user")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "???", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "????", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "????,?????? User", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<User>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        UserExample example = new UserExample();
        example.setPageView(new PageView<User>(pageNo, pageSize));
        
        if (wapper != null) {
            UserExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<User> pageData = this.userService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }

    @RequestMapping(method = RequestMethod.GET, value = "login")
    @ResponseBody
    public ResponseResult<String> login(@RequestParam(required=true) String code) {
        if (StringUtils.isBlank(code)) {
            throw new CommonException("微信登陆code不能为空,请重试");
        }
        String wxLoginUrl = Constant.WX_X_LOGIN_URL + "?appid=" + Constant.WX_X_APPID + "&secret=" + Constant.WX_X_SECRET +
                "&js_code=" + code + "&grant_type=authorization_code";
        String wxResponse = "";
        try {
            wxResponse = HttpGetClient.send(wxLoginUrl);
            JSONObject jsonObject = JSONObject.fromObject(wxResponse);
            String openId = jsonObject.get("openid") + "";
            String session_key = jsonObject.get("session_key") + "";
            UserExample userExample = new UserExample();
            userExample.createCriteria().andWxOpenidEqualTo(openId);
            List<User> users = userService.queryAllObjByExample(userExample);
            if (users.size() < 1){
                ResponseResult responseResult = ResponseResult.fail(ResponseCode.User_Not_Found);
                return responseResult;
            }
            String token = JWTUtil.createJWT(users.get(0).getUserName(), users.get(0).getId());
            return ResponseResult.success(token);
        } catch (IOException e) {
            throw new CommonException("微信登陆凭证校验失败！");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "reg")
    @ResponseBody
    public ResponseResult<String> reg(@RequestParam(required=true) String code,@RequestParam(required=true)  String userName,@RequestParam(required=true)  String alipay) {
        if (StringUtils.isBlank(code)) {
            throw new CommonException("微信登陆code不能为空,请重试");
        }
        String wxLoginUrl = Constant.WX_X_LOGIN_URL + "?appid=" + Constant.WX_X_APPID + "&secret=" + Constant.WX_X_SECRET +
                "&js_code=" + code + "&grant_type=authorization_code";
        String wxResponse = "";
        try {
            wxResponse = HttpGetClient.send(wxLoginUrl);
            JSONObject jsonObject = JSONObject.fromObject(wxResponse);
            String openId = jsonObject.get("openid") + "";
            String session_key = jsonObject.get("session_key") + "";
            UserExample userExample = new UserExample();
            userExample.createCriteria().andWxOpenidEqualTo(openId);
            List<User> users = userService.queryAllObjByExample(userExample);
            if (users.size() > 1){
                ResponseResult responseResult = ResponseUtil.fail(TipCode.ACCOUNT_WXOPENID_EXISTING);
                return responseResult;
            }
            userExample = new UserExample();
            userExample.createCriteria().andUserNameEqualTo(userName);
            users = userService.queryAllObjByExample(userExample);
            if (users.size() > 1){
                ResponseResult responseResult = ResponseUtil.fail(TipCode.ACCOUNT_USERNAME_EXISTING);
                return responseResult;
            }
            userExample = new UserExample();
            userExample.createCriteria().andUserAlipayAccountEqualTo(alipay);
            users = userService.queryAllObjByExample(userExample);
            if (users.size() > 1){
                ResponseResult responseResult = ResponseUtil.fail(TipCode.ACCOUNT_ALIPAY_EXISTING);
                return responseResult;
            }
            User user = new User();
            user.setId(UUIDGenerator.generateUUID());
            user.setWxOpenid(openId);
            user.setUserAlipayAccount(alipay);
            user.setUserName(userName);
            userService.addObj(user);
            return ResponseResult.success();
        } catch (IOException e) {
            throw new CommonException("微信登陆凭证校验失败！");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/bindPhone",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> bindPhone(@RequestBody CodePhone codePhone, HttpServletRequest request) {
        String uid = request.getAttribute("uid") + "";
        if (StringUtils.isBlank(codePhone.getId())) {
            throw new CommonException("验证码ID不能为空,请重新获取");
        }
        if (StringUtils.isBlank(codePhone.getPhonecode())) {
            throw new CommonException("验证码不能为空");
        }
        if (StringUtils.isBlank(codePhone.getUserphone())) {
            throw new CommonException("手机号不能为空！请重新输入并获取验证码！");
        }
        CodePhoneExample codePhoneExample = new CodePhoneExample();
        codePhoneExample.createCriteria().andIdEqualTo(codePhone.getId())
                .andPhonecodeEqualTo(codePhone.getPhonecode())
                .andUserphoneEqualTo(codePhone.getUserphone());
        List<CodePhone> codePhones = codePhoneService.queryAllObjByExample(codePhoneExample);
        if (codePhones.size() < 1){
            throw new CommonException("验证码错误");
        }

        User user = new User();
        user.setId(uid);
        user.setUserPhone(codePhone.getUserphone());
        this.userService.modifyObj(user);
        codePhoneService.deleteObjById(codePhone.getId());
        return ResponseResult.success();
    }
}