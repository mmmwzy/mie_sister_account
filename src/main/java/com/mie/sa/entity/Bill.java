package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="账单信息表")
public class Bill implements Serializable {
    private String id;

    @ApiModelProperty("账单内容类型（1：餐饮，2：交通,3：住房，4：加装，5其他，6：公共资金）")
    private Byte billContextType;

    @ApiModelProperty("账单类型（0：支出，1：收入）")
    private Byte billType;

    @ApiModelProperty("账单描述")
    private String billDescribe;

    @ApiModelProperty("账单金额")
    private BigDecimal billAmount;

    @ApiModelProperty("账单备注")
    private String billRemark;

    @ApiModelProperty("账单创建人姓名")
    private String billUserName;

    @ApiModelProperty("账单创建人ID")
    private String billUserId;

    @ApiModelProperty("账单报销类型（0：不报销，1：需要报销）")
    private Byte billDispatchType;

    @ApiModelProperty("账单报销状态（0 ：审核中，1：审核通过，未报销，2：审核通过，已报销，3：审核不通过，未报销）")
    private Byte billDispatchStatus;

    @ApiModelProperty("报销转账订单号")
    private String billDispatchOrder;

    private String billDataView;

    private Date billDate;

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

    public Byte getBillContextType() {
        return billContextType;
    }

    public void setBillContextType(Byte billContextType) {
        this.billContextType = billContextType;
    }

    public Byte getBillType() {
        return billType;
    }

    public void setBillType(Byte billType) {
        this.billType = billType;
    }

    public String getBillDescribe() {
        return billDescribe;
    }

    public void setBillDescribe(String billDescribe) {
        this.billDescribe = billDescribe == null ? null : billDescribe.trim();
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark == null ? null : billRemark.trim();
    }

    public String getBillUserName() {
        return billUserName;
    }

    public void setBillUserName(String billUserName) {
        this.billUserName = billUserName == null ? null : billUserName.trim();
    }

    public String getBillUserId() {
        return billUserId;
    }

    public void setBillUserId(String billUserId) {
        this.billUserId = billUserId == null ? null : billUserId.trim();
    }

    public Byte getBillDispatchType() {
        return billDispatchType;
    }

    public void setBillDispatchType(Byte billDispatchType) {
        this.billDispatchType = billDispatchType;
    }

    public Byte getBillDispatchStatus() {
        return billDispatchStatus;
    }

    public void setBillDispatchStatus(Byte billDispatchStatus) {
        this.billDispatchStatus = billDispatchStatus;
    }

    public String getBillDispatchOrder() {
        return billDispatchOrder;
    }

    public void setBillDispatchOrder(String billDispatchOrder) {
        this.billDispatchOrder = billDispatchOrder == null ? null : billDispatchOrder.trim();
    }

    public String getBillDataView() {
        return billDataView;
    }

    public void setBillDataView(String billDataView) {
        this.billDataView = billDataView == null ? null : billDataView.trim();
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
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