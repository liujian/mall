package com.mall.mobile.in;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-29 09:34
 **/

public class CardIn {

    private String languagetype;

    public String getLanguagetype() {
        return languagetype;
    }

    public void setLanguagetype(String languagetype) {
        this.languagetype = languagetype;
    }

    /**
     *用户token
     */
    private String  token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

