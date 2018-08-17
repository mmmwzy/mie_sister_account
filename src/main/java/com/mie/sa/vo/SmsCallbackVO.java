package com.mie.sa.vo;

import java.io.Serializable;

/**
 * 短信回复入参
 * Created by WangRicky on 2018/7/25.
 */
public class SmsCallbackVO implements Serializable {
    private static final long serialVersionUID = -2179058627656353052L;
    //通道扩展码，默认没有开通（需要填空）
    private String extend;
    //手机号码
    private String mobile;
    //国家码
    private String nationcode;
    //短信签名
    private String sign;
    //用户回复的内容
    private String text;
    //unix 时间戳（单位：秒）
    private Long time;

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNationcode() {
        return nationcode;
    }

    public void setNationcode(String nationcode) {
        this.nationcode = nationcode;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
