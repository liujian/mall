package com.mall.mobile.domen;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 14:57
 **/

public class Scoure implements Serializable {

    /**
     *id
     */
    private Integer id;


    /**
     *用户id
     */
    private Integer userid;

    /**
     *操作积分
     */
    private Integer operagral;

    /**
     *可用积分
     */
    private Integer usegral;

    /**
     *操作类型
     */
    private String operatype;


    /**
     *积分类型（奖励，抵扣，购物）
     */
    private String sourcetype;


    /**
     *积分说明
     */
    private String sourceinfo;

    /**
     *积分来源
     */
    private String gralscoure;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOperagral() {
        return operagral;
    }

    public void setOperagral(Integer operagral) {
        this.operagral = operagral;
    }

    public Integer getUsegral() {
        return usegral;
    }

    public void setUsegral(Integer usegral) {
        this.usegral = usegral;
    }

    public String getOperatype() {
        return operatype;
    }

    public void setOperatype(String operatype) {
        this.operatype = operatype;
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype;
    }

    public String getSourceinfo() {
        return sourceinfo;
    }

    public void setSourceinfo(String sourceinfo) {
        this.sourceinfo = sourceinfo;
    }

    public String getGralscoure() {
        return gralscoure;
    }

    public void setGralscoure(String gralscoure) {
        this.gralscoure = gralscoure;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

