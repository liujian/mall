package com.mall.mobile.out;

import com.mall.pc.domen.TradeInfo;

import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 16:49
 **/

public class TradeComposeout {

    /**
     *id
     */
    private Integer id;


    /**
     *组合名称中文
     */
    private String composename;



    /**
     *主商品id
     */
    private TradeInfo maintrade;

    /**
     *子商品id
     */
    private TradeInfo subtrade;

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

    public String getComposename() {
        return composename;
    }

    public void setComposename(String composename) {
        this.composename = composename;
    }

    public TradeInfo getMaintrade() {
        return maintrade;
    }

    public void setMaintrade(TradeInfo maintrade) {
        this.maintrade = maintrade;
    }

    public TradeInfo getSubtrade() {
        return subtrade;
    }

    public void setSubtrade(TradeInfo subtrade) {
        this.subtrade = subtrade;
    }

    public BigDecimal getComposeprice() {
        return composeprice;
    }

    public void setComposeprice(BigDecimal composeprice) {
        this.composeprice = composeprice;
    }
}

