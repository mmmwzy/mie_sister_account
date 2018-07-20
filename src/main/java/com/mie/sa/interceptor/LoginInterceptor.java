package com.mie.sa.interceptor;

import com.mie.base.core.entity.ResponseResult;
import com.mie.base.core.utils.ResponseCode;
import com.mie.sa.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WangRicky on 2018/7/6.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Autoken");
        if (StringUtils.isBlank(token)){
            ResponseResult responseResult = ResponseResult.fail(ResponseCode.Account_No_Login);
            System.out.println(JSONObject.fromObject(responseResult).toString());
            response.setContentType("text/javascript; charset=utf-8");
            response.getWriter().write(JSONObject.fromObject(responseResult).toString());
            return false;
        }
        Claims claims ;
        try {
            claims = JWTUtil.parseJWT(token);
        }catch (Exception e){
            ResponseResult responseResult = ResponseResult.fail(ResponseCode.Account_No_Login);
            response.getWriter().append(responseResult.toString());
            return false;
        }
        String subject = claims.getSubject();
        try{
            JSONObject jsonObject = JSONObject.fromObject(subject);
            String userName = jsonObject.get("userName") + "";
            String uid = jsonObject.get("uid") + "";
            request.setAttribute("userName", userName);
            request.setAttribute("uid", uid);
        }catch (Exception e){
            logger.error("JSON转换异常,转换数据[" + subject + "]");
            ResponseResult responseResult = ResponseResult.fail(ResponseCode.ERROR);
            response.getWriter().append(responseResult.toString());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
