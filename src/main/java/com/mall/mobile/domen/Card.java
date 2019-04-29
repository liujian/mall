package com.mall.mobile.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-29 09:17
 **/

public class Card implements Serializable {


    /**
     *用户id
     */
    private Integer userid;
    /**
     *持卡人姓名
     */
    private String cardname;

    /**
     *卡号
     */
    private String cardno;

    /**
     *有效日期
     */
    private String expirydate;

    /**
     *信用卡CVC
     */
    private String cvc;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}

