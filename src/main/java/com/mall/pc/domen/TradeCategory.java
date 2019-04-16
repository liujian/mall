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
     *分类名称_中文
     */
    private String classify_zw;

    /**
     *分类名称_英文
     */
    private String classify_yw;

    /**
     *分类名称_简体
     */
    private String classify_jt;

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
     *分类图片
     */
    private String homeimage;

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

    public String getClassify_zw() {
        return classify_zw;
    }

    public void setClassify_zw(String classify_zw) {
        this.classify_zw = classify_zw;
    }

    public String getClassify_yw() {
        return classify_yw;
    }

    public void setClassify_yw(String classify_yw) {
        this.classify_yw = classify_yw;
    }

    public String getClassify_jt() {
        return classify_jt;
    }

    public void setClassify_jt(String classify_jt) {
        this.classify_jt = classify_jt;
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


    public String getClassifyimage() {
        return classifyimage;
    }

    public void setClassifyimage(String classifyimage) {
        this.classifyimage = classifyimage;
    }
}

