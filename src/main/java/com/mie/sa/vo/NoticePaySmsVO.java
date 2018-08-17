package com.mie.sa.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by WangRicky on 2018/8/13.
 */
public class NoticePaySmsVO implements Serializable{

    private static final long serialVersionUID = 3369307930803433834L;

    private String originatorId;

    private String payAmount;

    private String payDescribe;

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDescribe() {
        return payDescribe;
    }

    public void setPayDescribe(String payDescribe) {
        this.payDescribe = payDescribe;
    }

    @Override
    public String toString() {
        return "NoticePaySmsVO{" +
                "originatorId='" + originatorId + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", payDescribe='" + payDescribe + '\'' +
                '}';
    }
}

