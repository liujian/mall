package com.mall.mobile.out;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-05 09:27
 **/

public class OrderOuts {

    /**
     * 订单编号
     */
    private String orderid;
    /**
     * 分类名称
     */
    private String classname;

    /**
     * 订单状态
     */
    private String orderstatus;

    /**
     * 订单商品信息
     */
    List<OrderTradeOut> orderOutTradeList;


    /**
     * 商品件数
     */
    private Integer tradenum;

    /**
     * 合计金额
     */
    private BigDecimal ordertotalprice;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public List<OrderTradeOut> getOrderOutTradeList() {
        return orderOutTradeList;
    }

    public void setOrderOutTradeList(List<OrderTradeOut> orderOutTradeList) {
        this.orderOutTradeList = orderOutTradeList;
    }

    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public BigDecimal getOrdertotalprice() {
        return ordertotalprice;
    }

    public void setOrdertotalprice(BigDecimal ordertotalprice) {
        this.ordertotalprice = ordertotalprice;
    }
}

