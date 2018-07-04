package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="sa_book_checking")
public class BookChecking implements Serializable {
    private String id;

    @ApiModelProperty("??ID")
    private String book_id;

    @ApiModelProperty("?????ID")
    private String apply_user_id;

    @ApiModelProperty("???ID")
    private String check_user_id;

    @ApiModelProperty("???????")
    private BigDecimal check_alipay_balance;

    @ApiModelProperty("????(0:???,1:??,2:??,3:??)")
    private Byte check_status;

    @ApiModelProperty("????")
    private BigDecimal check_balance;

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

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id == null ? null : book_id.trim();
    }

    public String getApply_user_id() {
        return apply_user_id;
    }

    public void setApply_user_id(String apply_user_id) {
        this.apply_user_id = apply_user_id == null ? null : apply_user_id.trim();
    }

    public String getCheck_user_id() {
        return check_user_id;
    }

    public void setCheck_user_id(String check_user_id) {
        this.check_user_id = check_user_id == null ? null : check_user_id.trim();
    }

    public BigDecimal getCheck_alipay_balance() {
        return check_alipay_balance;
    }

    public void setCheck_alipay_balance(BigDecimal check_alipay_balance) {
        this.check_alipay_balance = check_alipay_balance;
    }

    public Byte getCheck_status() {
        return check_status;
    }

    public void setCheck_status(Byte check_status) {
        this.check_status = check_status;
    }

    public BigDecimal getCheck_balance() {
        return check_balance;
    }

    public void setCheck_balance(BigDecimal check_balance) {
        this.check_balance = check_balance;
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