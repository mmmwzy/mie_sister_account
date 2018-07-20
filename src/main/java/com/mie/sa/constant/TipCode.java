package com.mie.sa.constant;

import com.mie.base.core.utils.ResponseCode;

/**
 * Created by WangRicky on 2018/7/10.
 */
public enum TipCode {
    ACCOUNT_USERNAME_EXISTING("5101", "用户姓名/昵称已存在", "ACCOUNT_USERNAME_EXISTING"),
    ACCOUNT_ALIPAY_EXISTING("5101","用户支付宝账号已存在", "ACCOUNT_ALIPAY_EXISTING"),
    ACCOUNT_WXOPENID_EXISTING("5102", "该微信号已存在", "ACCOUNT_WXOPENID_EXISTING");

    private String httpCode;
    private String msg;
    private String key;

    private TipCode(String httpCode, String msg, String key) {
        this.httpCode = httpCode;
        this.key = key;
        this.msg = msg;
    }

    public String getCode() {
        return this.httpCode;
    }

    public String getKey() {
        return this.key;
    }

    public String getMsg() {
        return this.msg;
    }
}
