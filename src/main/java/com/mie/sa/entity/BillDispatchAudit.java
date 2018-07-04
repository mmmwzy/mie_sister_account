package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="sa_bill_dispatch_audit")
public class BillDispatchAudit implements Serializable {
    private String id;

    @ApiModelProperty("??ID")
    private String bill_id;

    @ApiModelProperty("???ID")
    private String audit_user_id;

    @ApiModelProperty("????(0:???,1:??,2:???)")
    private Byte audit_status;

    @ApiModelProperty("????")
    private String audit_remark;

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

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id == null ? null : bill_id.trim();
    }

    public String getAudit_user_id() {
        return audit_user_id;
    }

    public void setAudit_user_id(String audit_user_id) {
        this.audit_user_id = audit_user_id == null ? null : audit_user_id.trim();
    }

    public Byte getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(Byte audit_status) {
        this.audit_status = audit_status;
    }

    public String getAudit_remark() {
        return audit_remark;
    }

    public void setAudit_remark(String audit_remark) {
        this.audit_remark = audit_remark == null ? null : audit_remark.trim();
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