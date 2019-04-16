package com.mall.mobile.domen;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 15:10
 **/

public class Interest implements Serializable {

    /**
     *id
     */
    private Integer id;

    /**
     *用户id
     */
    private Integer custid;

    /**
     *关注商品id
     */
    private Integer trandid;

    /**
     *关注时间
     */
    private Date createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public Integer getTrandid() {
        return trandid;
    }

    public void setTrandid(Integer trandid) {
        this.trandid = trandid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

