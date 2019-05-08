package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-12 09:22
 **/

public class TradeCategory implements Serializable {

    /**
     *id
     */
    private Integer id;

    /**
     *分类名称
     */
    private String classify;


    /**
     * 分类图片
     */
    private String classifyimage;

    /**
     *父类id
     */
    private Integer fatherid;


    /**
     *首页是否展示小图标
     */
    private String ishomeicon;

    /**
     *图标
     */
    private String icons;


    /**
     *是否展示首页
     */
    private String ishome;

    /**
     *首页展示图片
     */
    private String homeimage;


    /**
     *首页展示图片跳转方式
     */
    private String homeimageaddway;


    /**
     *首页图片跳转id
     */
    private String homeimageaddid;

    /**
     *排序
     */

    private Integer sort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public String getIshomeicon() {
        return ishomeicon;
    }

    public void setIshomeicon(String ishomeicon) {
        this.ishomeicon = ishomeicon;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    public String getIshome() {
        return ishome;
    }

    public void setIshome(String ishome) {
        this.ishome = ishome;
    }

    public String getHomeimage() {
        return homeimage;
    }

    public void setHomeimage(String homeimage) {
        this.homeimage = homeimage;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getHomeimageaddway() {
        return homeimageaddway;
    }

    public void setHomeimageaddway(String homeimageaddway) {
        this.homeimageaddway = homeimageaddway;
    }

    public String getHomeimageaddid() {
        return homeimageaddid;
    }

    public void setHomeimageaddid(String homeimageaddid) {
        this.homeimageaddid = homeimageaddid;
    }

    public String getClassifyimage() {
        return classifyimage;
    }

    public void setClassifyimage(String classifyimage) {
        this.classifyimage = classifyimage;
    }
}

