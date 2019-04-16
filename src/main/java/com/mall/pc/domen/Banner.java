package com.mall.pc.domen;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 10:36
 **/

public class Banner implements Serializable {

    /**
     *id
     */
    private Integer id;

    /**
     *轮播图
     */
    private String image;

    /**
     *跳转方式
     */
    private String addway;

    /**
     *跳转id
     */
    private Integer addid;


    /**
     *排序
     */
    private Integer sort;

    /**
     *创建时间
     */
     private Date createtime;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

