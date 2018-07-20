package com.mie.sa.utils;

import com.mie.base.core.entity.ResponseResult;
import com.mie.sa.constant.TipCode;

/**
 * Created by WangRicky on 2018/7/10.
 */
public class ResponseUtil {


    public static ResponseResult<String> fail(TipCode code){
        return fail(code, "");
    }

    public static <T> ResponseResult<T> fail(TipCode code, T data){
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(code.getCode());
        responseResult.setMsg(code.getMsg());
        responseResult.setData(data);
        return responseResult;
    }
}
