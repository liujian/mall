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
     *参数名称
     */
    private String param;

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
}

