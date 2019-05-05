package com.mall.mobile.domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-29 13:25
 **/

public class OrderInfo implements Serializable {


    /**
     *订单编号
     */
     private String orderid;

    /**
     *用户id
     */
    private Integer userid;

    /**
     *商品分类
     */
    private Integer classid;

    /**
     *订单状态
     */
    private String orderstatus;

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
     *支付方式
     */
    private String payway;

    /**
     *支付流水号
     */
    private String payflowcode;

    /**
     *订单创建时间
     */
    private Date createtime;

    /**
     *快递方式
     */
    private String expressway;

    /**
     *快递单号
     */
    private String expresscode;


    /**
     *收件人姓名
     */
    private String name;

    /**
     *收件人手机号
     */
    private String phone;

    /**
     *收件人地址
     */
    private String address;

    /**
     *订单支付状态
     */
    private String paystatus;

    /**
     *订单付款时间
     */
    private Date paytime;

    /**
     *发货时间
     */
    private Date sendtime;


    /**
     *成交时间
     */
    private Date finaltime;

    public String getExpressway() {
        return expressway;
    }

    public void setExpressway(String expressway) {
        this.expressway = expressway;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
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

    public String getPayflowcode() {
        return payflowcode;
    }

    public void setPayflowcode(String payflowcode) {
        this.payflowcode = payflowcode;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getExpresscode() {
        return expresscode;
    }

    public void setExpresscode(String expresscode) {
        this.expresscode = expresscode;
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

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getFinaltime() {
        return finaltime;
    }

    public void setFinaltime(Date finaltime) {
        this.finaltime = finaltime;
    }
}

