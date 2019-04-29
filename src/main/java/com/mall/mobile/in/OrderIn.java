package com.mall.mobile.in;

import com.mall.mobile.domen.Cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-29 14:22
 **/

public class OrderIn {


    /**
     * token
     */
    private String token;

    /**
     *件数
     */
    private Integer tradenum;

    /**
     *商品金额
     */
    private BigDecimal tradeprice;

    /**
     *订单折扣码
     */
    private String orderdiscount;

    /**
     *订单折扣金额
     */
    private BigDecimal discountprice;

    /**
     *订单积分抵扣数
     */
    private Integer orderintegral;

    /**
     *订单积分抵扣金额
     */
    private BigDecimal integralprice;

    /**
     *订单商品实际金额
     */
    private BigDecimal actualprice;

    /**
     *运费
     */
    private BigDecimal freight;

    /**
     *税钱
     */
    private BigDecimal tax;

    /**
     *订单总金额
     */
    private BigDecimal ordertotalprice;
    /**
     * 支付方式
     */
    private String payway;

    /**
     * 收件人姓名
     */
    private String name;

    /**
     * 收件人手机号
     */
    private String phone;

    /**
     * 收件人地址
     */
    private String address;

    /**
     * 购物车列表
     */
    private List<Cart> cartList;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getOrderdiscount() {
        return orderdiscount;
    }

    public void setOrderdiscount(String orderdiscount) {
        this.orderdiscount = orderdiscount;
    }

    public BigDecimal getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(BigDecimal discountprice) {
        this.discountprice = discountprice;
    }

    public Integer getOrderintegral() {
        return orderintegral;
    }

    public void setOrderintegral(Integer orderintegral) {
        this.orderintegral = orderintegral;
    }

    public BigDecimal getIntegralprice() {
        return integralprice;
    }

    public void setIntegralprice(BigDecimal integralprice) {
        this.integralprice = integralprice;
    }

    public BigDecimal getActualprice() {
        return actualprice;
    }

    public void setActualprice(BigDecimal actualprice) {
        this.actualprice = actualprice;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getOrdertotalprice() {
        return ordertotalprice;
    }

    public void setOrdertotalprice(BigDecimal ordertotalprice) {
        this.ordertotalprice = ordertotalprice;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}

