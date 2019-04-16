package com.mall.mobile.domen;

import java.io.Serializable;

/**
 * @program: server
 * @description:
 * @author: liu.j
 * @create: 2019-03-04 18:16
 **/

public class CustAdress implements Serializable {


    /**
     * id
     */
    private Integer id;

    /**
     * 客户编号
     */
    private Integer custid;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 门牌号
     */
    private String doornumber;

    /**
     * 标签
     */
    private String tab;


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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoornumber() {
        return doornumber;
    }

    public void setDoornumber(String doornumber) {
        this.doornumber = doornumber;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }
}

