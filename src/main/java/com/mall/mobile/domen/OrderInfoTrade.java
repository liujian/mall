package com.mall.mobile.domen;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-29 13:46
 **/

public class OrderInfoTrade implements Serializable {

    /**
     * 订单编号
     */
    private String orderid;

    /**
     *商品类型（组合、商品）
     */
    private String tradetype;

    /**
     *商品编号
     */
    private Integer tradeid;

    /**
     *商品参数名称id
     */
    private Integer tradepramnameid;

    /**
     *商品参数id
     */
    private Integer tradepramid;

    /**
     *商品数量
     */
    private Integer tradenum;

    /**
     *商品单价
     */
    private BigDecimal tradeprice;

    /**
     *商品总价
     */
    private BigDecimal tradetotalprice;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public Integer getTradeid() {
        return tradeid;
    }

    public void setTradeid(Integer tradeid) {
        this.tradeid = tradeid;
    }

    public Integer getTradepramnameid() {
        return tradepramnameid;
    }

    public void setTradepramnameid(Integer tradepramnameid) {
        this.tradepramnameid = tradepramnameid;
    }

    public Integer getTradepramid() {
        return tradepramid;
    }

    public void setTradepramid(Integer tradepramid) {
        this.tradepramid = tradepramid;
    }

    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public BigDecimal getTradeprice() {
        return tradeprice;
    }

    public void setTradeprice(BigDecimal tradeprice) {
        this.tradeprice = tradeprice;
    }

    public BigDecimal getTradetotalprice() {
        return tradetotalprice;
    }

    public void setTradetotalprice(BigDecimal tradetotalprice) {
        this.tradetotalprice = tradetotalprice;
    }
}

