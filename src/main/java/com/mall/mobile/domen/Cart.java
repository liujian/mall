package com.mall.mobile.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 15:57
 **/

public class Cart implements Serializable {

    /**
     *购物车id
     */
    private Integer id;

    /**
     *用户id
     */
    private Integer userid;

    /**
     *商品id
     */
    private Integer tradid;


    /**
     *商品参数名称id
     */
    private Integer tradparmnameid;


    /**
     *商品参数型号id
     */
    private Integer tradparmid;


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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTradid() {
        return tradid;
    }

    public void setTradid(Integer tradid) {
        this.tradid = tradid;
    }

    public Integer getTradparmnameid() {
        return tradparmnameid;
    }

    public void setTradparmnameid(Integer tradparmnameid) {
        this.tradparmnameid = tradparmnameid;
    }

    public Integer getTradparmid() {
        return tradparmid;
    }

    public void setTradparmid(Integer tradparmid) {
        this.tradparmid = tradparmid;
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

