package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 15:22
 **/

public class TradeGive implements Serializable {

    /**
     *id
     */
    private Integer id;

    /**
     *商品id
     */
    private Integer tradeid;

    /**
     *赠送商品id
     */
    private Integer givetradeid;

    /**
     *类别
     */
    private String cate;


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

    public Integer getGivetradeid() {
        return givetradeid;
    }

    public void setGivetradeid(Integer givetradeid) {
        this.givetradeid = givetradeid;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
}

