package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="sa_book_checking")
public class BookChecking implements Serializable {
    private String id;

    @ApiModelProperty("账本ID")
    private String bookId;

    @ApiModelProperty("对账申请人ID")
    private String applyUserId;

    @ApiModelProperty("对账人ID")
    private String checkUserId;

    @ApiModelProperty("对账支付宝余额")
    private BigDecimal checkAlipayBalance;

    @ApiModelProperty("对账状态(0:已申请,1:正常,2:正差,3:负差)")
    private Byte checkStatus;

    @ApiModelProperty("对账差额")
    private BigDecimal checkBalance;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId == null ? null : applyUserId.trim();
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId == null ? null : checkUserId.trim();
    }

    public BigDecimal getCheckAlipayBalance() {
        return checkAlipayBalance;
    }

    public void setCheckAlipayBalance(BigDecimal checkAlipayBalance) {
        this.checkAlipayBalance = checkAlipayBalance;
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    public BigDecimal getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(BigDecimal checkBalance) {
        this.checkBalance = checkBalance;
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