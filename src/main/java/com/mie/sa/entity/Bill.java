package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="?????")
public class Bill implements Serializable {
    private String id;

    @ApiModelProperty("?????0????1????")
    private Byte bill_type;

    @ApiModelProperty("????")
    private String bill_describe;

    @ApiModelProperty("????")
    private BigDecimal bill_amount;

    @ApiModelProperty("????")
    private String bill_remark;

    @ApiModelProperty("?????")
    private String bill_user;

    @ApiModelProperty("???????0?????1??????")
    private Byte bill_dispatch_type;

    @ApiModelProperty("???????0 ?????1??????????2??????????3???????????")
    private Byte bill_dispatch_status;

    @ApiModelProperty("???????")
    private String bill_dispatch_order;

    @ApiModelProperty("????")
    private Date create_time;

    @ApiModelProperty("????")
    private Date update_time;

    @ApiModelProperty("???(0?????1????)")
    private Byte is_delete;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getBill_type() {
        return bill_type;
    }

    public void setBill_type(Byte bill_type) {
        this.bill_type = bill_type;
    }

    public String getBill_describe() {
        return bill_describe;
    }

    public void setBill_describe(String bill_describe) {
        this.bill_describe = bill_describe == null ? null : bill_describe.trim();
    }

    public BigDecimal getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(BigDecimal bill_amount) {
        this.bill_amount = bill_amount;
    }

    public String getBill_remark() {
        return bill_remark;
    }

    public void setBill_remark(String bill_remark) {
        this.bill_remark = bill_remark == null ? null : bill_remark.trim();
    }

    public String getBill_user() {
        return bill_user;
    }

    public void setBill_user(String bill_user) {
        this.bill_user = bill_user == null ? null : bill_user.trim();
    }

    public Byte getBill_dispatch_type() {
        return bill_dispatch_type;
    }

    public void setBill_dispatch_type(Byte bill_dispatch_type) {
        this.bill_dispatch_type = bill_dispatch_type;
    }

    public Byte getBill_dispatch_status() {
        return bill_dispatch_status;
    }

    public void setBill_dispatch_status(Byte bill_dispatch_status) {
        this.bill_dispatch_status = bill_dispatch_status;
    }

    public String getBill_dispatch_order() {
        return bill_dispatch_order;
    }

    public void setBill_dispatch_order(String bill_dispatch_order) {
        this.bill_dispatch_order = bill_dispatch_order == null ? null : bill_dispatch_order.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Byte getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Byte is_delete) {
        this.is_delete = is_delete;
    }
}