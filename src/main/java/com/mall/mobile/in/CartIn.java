package com.mall.mobile.in;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-23 10:44
 **/

public class CartIn {



    /**
     *用户token
     */
    private String token;

    /**
     *商品id
     */
    private Integer tradid;


    /**
     *商品参数名称
     */
    private String tradparmname;


    /**
     *商品参数型号
     */
    private String tradparm;


    /**
     *商品数量
     */
    private Integer tradenum;


    /**
     *商品分类id
     */
    private Integer tradeclass;


    /**
     *商品类型（普通，组合）
     */
    private String tradetype;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getTradid() {
        return tradid;
    }

    public void setTradid(Integer tradid) {
        this.tradid = tradid;
    }

    public String getTradparmname() {
        return tradparmname;
    }

    public void setTradparmname(String tradparmname) {
        this.tradparmname = tradparmname;
    }

    public String getTradparm() {
        return tradparm;
    }

    public void setTradparm(String tradparm) {
        this.tradparm = tradparm;
    }

    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public Integer getTradeclass() {
        return tradeclass;
    }

    public void setTradeclass(Integer tradeclass) {
        this.tradeclass = tradeclass;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }
}

