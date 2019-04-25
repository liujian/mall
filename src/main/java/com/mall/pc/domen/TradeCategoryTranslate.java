package com.mall.pc.domen;

import java.io.Serializable;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-25 09:43
 **/

public class TradeCategoryTranslate implements Serializable{

    /**
     *分类id
     */
    private Integer classid;

    /**
     *分类名称
     */
    private String classifyname;
    /**
     *语言类型
     */
    private String languagetype;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname;
    }

    public String getLanguagetype() {
        return languagetype;
    }

    public void setLanguagetype(String languagetype) {
        this.languagetype = languagetype;
    }
}

