package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-08 13:33
 **/

public class Advertise implements Serializable {

    /**
     *广告区域id
     */
    private Integer id;

    /**
     *广告图
     */
    private String image;

    /**
     *广告跳转方式
     */
    private String addway;

    /**
     *跳转id
     */
    private Integer addid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddway() {
        return addway;
    }

    public void setAddway(String addway) {
        this.addway = addway;
    }

    public Integer getAddid() {
        return addid;
    }

    public void setAddid(Integer addid) {
        this.addid = addid;
    }
}

