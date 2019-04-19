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
     *参数名称（中文）
     */
    private String param_zw;

    /**
     *参数名称（英文）
     */
    private String param_yw;

    /**
     *参数名称（繁体）
     */
    private String param_jt;

    /**
     *参数
     */
    private String param;

    /**
     *商品数量
     */
    private Integer tradenum;

    public Integer getTradeid() {
        return tradeid;
    }

    public void setTradeid(Integer tradeid) {
        this.tradeid = tradeid;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public String getParam_zw() {
        return param_zw;
    }

    public void setParam_zw(String param_zw) {
        this.param_zw = param_zw;
    }

    public String getParam_yw() {
        return param_yw;
    }

    public void setParam_yw(String param_yw) {
        this.param_yw = param_yw;
    }

    public String getParam_jt() {
        return param_jt;
    }

    public void setParam_jt(String param_jt) {
        this.param_jt = param_jt;
    }
}

