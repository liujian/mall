package com.mall.pc.domen;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 09:13
 **/

public class Discount implements Serializable{

    /**
     *id
     */
    private Integer id;


    /**
     *折扣码名称
     */
    private String disname;

    /**
     *折扣码
     */
    private String discode;

    /**
     *折扣比
     */
    private BigDecimal disratio;

    /**
     *折扣方式
     */
    private String disway;

    /**
     *折扣商品id
     */
    private Integer tradeid;

    /**
     *是否失效
     */
    private String invalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisname() {
        return disname;
    }

    public void setDisname(String disname) {
        this.disname = disname;
    }

    public String getDiscode() {
        return discode;
    }

    public void setDiscode(String discode) {
        this.discode = discode;
    }

    public BigDecimal getDisratio() {
        return disratio;
    }

    public void setDisratio(BigDecimal disratio) {
        this.disratio = disratio;
    }

    public String getDisway() {
        return disway;
    }

    public void setDisway(String disway) {
        this.disway = disway;
    }

    public Integer getTradeid() {
        return tradeid;
    }

    public void setTradeid(Integer tradeid) {
        this.tradeid = tradeid;
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }
}

