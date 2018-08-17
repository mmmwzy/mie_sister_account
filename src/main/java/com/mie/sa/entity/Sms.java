package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="sa_sms")
public class Sms implements Serializable {
    private String id;

    @ApiModelProperty("短信ID")
    private String smsId;

    @ApiModelProperty("短信内容随机码")
    private String smsRandomCode;

    @ApiModelProperty("接受用户ID")
    private String userId;

    @ApiModelProperty("接受用户手机号")
    private String userPhone;

    @ApiModelProperty("关联账单ID")
    private String billId;

    @ApiModelProperty("短信状态：1：已处理，2：未处理")
    private Byte smsStatus;

    private Date createTime;

    private Date updateTime;

    @ApiModelProperty("软删除(0：已删除，1：未删除)")
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId == null ? null : smsId.trim();
    }

    public String getSmsRandomCode() {
        return smsRandomCode;
    }

    public void setSmsRandomCode(String smsRandomCode) {
        this.smsRandomCode = smsRandomCode == null ? null : smsRandomCode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public Byte getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(Byte smsStatus) {
        this.smsStatus = smsStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}