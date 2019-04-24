package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-24 11:27
 **/

public class TradeParamName implements Serializable {

    /**
     *id
     */
    private Integer id;

    /**
     *商品id
     */
    private Integer tradeid;

    /**
     *参数名称
     */
    private String paramname;


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

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname;
    }
}

