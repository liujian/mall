package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 13:36
 **/

public class Brand implements Serializable {

    /**
     *id
     */
    private Integer id;


    /**
     *品牌名称
     */
    private String brandname;

    /**
     *品牌商标
     */
    private String brandicon;

    /**
     * 品牌介绍
     */
    private String brandinfo;

    /**
     *是否展示首页
     */
    private String ishome;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getBrandicon() {
        return brandicon;
    }

    public void setBrandicon(String brandicon) {
        this.brandicon = brandicon;
    }

    public String getBrandinfo() {
        return brandinfo;
    }

    public void setBrandinfo(String brandinfo) {
        this.brandinfo = brandinfo;
    }

    public String getIshome() {
        return ishome;
    }

    public void setIshome(String ishome) {
        this.ishome = ishome;
    }
}

