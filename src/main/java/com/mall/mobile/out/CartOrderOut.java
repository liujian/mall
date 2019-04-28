package com.mall.mobile.out;

import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 10:59
 **/

public class CartOrderOut {

    /**
     *件数
     */
     private Integer tradenum;

    /**
     *折扣
     */
    private BigDecimal discount;

    /**
     *积分抵扣
     */
    private BigDecimal integraldeduct;


    /**
     *小计
     */
    private BigDecimal subtotal;

    /**
     *税
     */
    private BigDecimal tax;

    /**
     *运费
     */
    private BigDecimal freight;

    /**
     *总计
     */
    private BigDecimal total;

    /**
     *折扣码
     */
    private String discode;

    /**
     *折扣码是否有效
     */
    private Boolean discodevalid;

    /**
     * 积分抵扣积分
     */
    private Integer integral;

    /**
     * 您的积分
     */
    private Integer myintegral;


    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getIntegraldeduct() {
        return integraldeduct;
    }

    public void setIntegraldeduct(BigDecimal integraldeduct) {
        this.integraldeduct = integraldeduct;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDiscode() {
        return discode;
    }

    public void setDiscode(String discode) {
        this.discode = discode;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getMyintegral() {
        return myintegral;
    }

    public void setMyintegral(Integer myintegral) {
        this.myintegral = myintegral;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Boolean getDiscodevalid() {
        return discodevalid;
    }

    public void setDiscodevalid(Boolean discodevalid) {
        this.discodevalid = discodevalid;
    }
}

