package com.mall.mobile.out;

import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-05 09:32
 **/

public class OrderTradeOut {

    /**
     *订单编号
     */
    private String orderid;

    /**
     *商品类型（组合、商品）
     */
    private String tradetype;

    /**
     *普通商品
     */
    private TradeInfoOut tradeInfoOut;

    /**
     *组合商品
     */
    private TradeComposeout tradeComposeout;


    /**
     *商品数量
     */
    private Integer tradenum;

    /**
     *商品单价
     */
    private BigDecimal tradeprice;

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

    public TradeInfoOut getTradeInfoOut() {
        return tradeInfoOut;
    }

    public void setTradeInfoOut(TradeInfoOut tradeInfoOut) {
        this.tradeInfoOut = tradeInfoOut;
    }

    public TradeComposeout getTradeComposeout() {
        return tradeComposeout;
    }

    public void setTradeComposeout(TradeComposeout tradeComposeout) {
        this.tradeComposeout = tradeComposeout;
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
}

