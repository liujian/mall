package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 10:12
 **/

public class TradePhoto implements Serializable {

    /**
     *id
     */
    private Integer id;

    /**
     *商品id
     */
    private Integer tradeid;

    /**
     *图片描述
     */
    private String imagexplain;

    /**
     *图片地址
     */
    private String image;

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

    public String getImagexplain() {
        return imagexplain;
    }

    public void setImagexplain(String imagexplain) {
        this.imagexplain = imagexplain;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

