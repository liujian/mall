package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 15:06
 **/

public class TradeParam implements Serializable {

    /**
     * 参数id
     */
    private Integer id;

    /**
     *商品id
     */
    private Integer tradeid;

    /**
     *参数名称id
     */
    private Integer paramnameid;

    /**
     *参数
     */
    private String param;

    /**
     *商品数量
     */
    private Integer tradenum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTradeid() {
        return tradeid;
    }

    public void setTradeid(Integer tradeid) {
        this.tradeid = tradeid;
    }

    public Integer getParamnameid() {
        return paramnameid;
    }

    public void setParamnameid(Integer paramnameid) {
        this.paramnameid = paramnameid;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }
}

