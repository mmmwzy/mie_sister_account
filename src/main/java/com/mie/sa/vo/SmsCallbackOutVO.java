package com.mie.sa.vo;

import java.io.Serializable;

/**
 * 短信回复出参
 * Created by WangRicky on 2018/7/25.
 */
public class SmsCallbackOutVO implements Serializable{
    private static final long serialVersionUID = 4259729579268570864L;

    private String result;

    private String errmsg;

    public SmsCallbackOutVO(){}

    public SmsCallbackOutVO(String result, String errmsg){
        this.result = result;
        this.errmsg = errmsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
