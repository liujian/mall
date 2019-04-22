package com.mall.mobile.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 14:22
 **/

public class Integral implements Serializable {

    /**
     *用户id
     */
    private Integer userid;

    /**
     *总积分
     */
    private Integer totalscore;

    /**
     *消耗积分
     */
    private Integer expendscore;

    /**
     *剩余积分
     */
    private Integer surpluscore;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getExpendscore() {
        return expendscore;
    }

    public void setExpendscore(Integer expendscore) {
        this.expendscore = expendscore;
    }

    public Integer getSurpluscore() {
        return surpluscore;
    }

    public void setSurpluscore(Integer surpluscore) {
        this.surpluscore = surpluscore;
    }
}

