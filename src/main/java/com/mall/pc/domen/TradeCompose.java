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
     *组合名称中文
     */
    private String composename_zw;

    /**
     *组合名称英文
     */
    private String composename_yw;

    /**
     *组合名称繁体
     */
    private String composename_jt;

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

    public String getComposename_zw() {
        return composename_zw;
    }

    public void setComposename_zw(String composename_zw) {
        this.composename_zw = composename_zw;
    }

    public String getComposename_yw() {
        return composename_yw;
    }

    public void setComposename_yw(String composename_yw) {
        this.composename_yw = composename_yw;
    }

    public String getComposename_jt() {
        return composename_jt;
    }

    public void setComposename_jt(String composename_jt) {
        this.composename_jt = composename_jt;
    }
}

