package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="sa_user")
public class User implements Serializable {
    private String id;

    @ApiModelProperty("??openId")
    private String wx_openId;

    @ApiModelProperty("???????")
    private String user_alipay_account;

    @ApiModelProperty("????")
    private String user_name;

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

    public String getWx_openId() {
        return wx_openId;
    }

    public void setWx_openId(String wx_openId) {
        this.wx_openId = wx_openId == null ? null : wx_openId.trim();
    }

    public String getUser_alipay_account() {
        return user_alipay_account;
    }

    public void setUser_alipay_account(String user_alipay_account) {
        this.user_alipay_account = user_alipay_account == null ? null : user_alipay_account.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
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