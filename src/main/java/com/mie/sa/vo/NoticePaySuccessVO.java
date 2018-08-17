package com.mie.sa.vo;

import java.io.Serializable;

/**
 * Created by WangRicky on 2018/8/13.
 */
public class NoticePaySuccessVO implements Serializable{

    private static final long serialVersionUID = 4968499375654616146L;
    private String userId;

    private String payAmount;

    private String payOrderId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    @Override
    public String toString() {
        return "NoticePaySuccessVO{" +
                "userId='" + userId + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", payOrderId='" + payOrderId + '\'' +
                '}';
    }
}
