package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-24 09:38
 **/

public class TradeInfoTranslate implements Serializable {


    /**
     *商品编号
     */
    private Integer tradeid;

    /**
     *语言类型
     */
    private String languagetype;
    /**
     *商品名称
     */
    private String tradename;

    /**
     *商品介绍
     */
    private String introduce;

    /**
     *商品亮点
     */
    private String tradebright;

    /**
     *更多信息
     */
    private String moreinfo;


    public Integer getTradeid() {
        return tradeid;
    }

    public void setTradeid(Integer tradeid) {
        this.tradeid = tradeid;
    }

    public String getLanguagetype() {
        return languagetype;
    }

    public void setLanguagetype(String languagetype) {
        this.languagetype = languagetype;
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTradebright() {
        return tradebright;
    }

    public void setTradebright(String tradebright) {
        this.tradebright = tradebright;
    }

    public String getMoreinfo() {
        return moreinfo;
    }

    public void setMoreinfo(String moreinfo) {
        this.moreinfo = moreinfo;
    }
}

