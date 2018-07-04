package com.mie.sa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="sa_book")
public class Book implements Serializable {
    private String id;

    @ApiModelProperty("????")
    private BigDecimal book_balance;

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

    public BigDecimal getBook_balance() {
        return book_balance;
    }

    public void setBook_balance(BigDecimal book_balance) {
        this.book_balance = book_balance;
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