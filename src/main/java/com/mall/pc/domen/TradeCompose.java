package com.mall.pc.domen;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 10:22
 **/

public class TradeCompose implements Serializable{


    /**
     *id
     */
    private Integer id;

    /**
     *主商品id
     */
    private Integer maintrade;

    /**
     *子商品id
     */
    private Integer subtrade;

    /**
     *组合价钱
     */
    private BigDecimal composeprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaintrade() {
        return maintrade;
    }

    public void setMaintrade(Integer maintrade) {
        this.maintrade = maintrade;
    }

    public Integer getSubtrade() {
        return subtrade;
    }

    public void setSubtrade(Integer subtrade) {
        this.subtrade = subtrade;
    }

    public BigDecimal getComposeprice() {
        return composeprice;
    }

    public void setComposeprice(BigDecimal composeprice) {
        this.composeprice = composeprice;
    }
}

