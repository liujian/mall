package com.mall.pc.domen;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-15 10:22
 **/

public class Message implements Serializable {

    /**
     *消息id
     */
    private String messageid;

    /**
     *发布标题
     */
    private String title;

    /**
     *发布内容
     */
    private String content;

    /**
     *发布时间
     */
    private Date releasetime;

    /**
     *发布人员
     */
    private String publishers;

    /**
     *接受对象
     */
    private int recipients;

    /**
     *语言种类
     */
    private String languagetype;

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public int getRecipients() {
        return recipients;
    }

    public void setRecipients(int recipients) {
        this.recipients = recipients;
    }

    public String getLanguagetype() {
        return languagetype;
    }

    public void setLanguagetype(String languagetype) {
        this.languagetype = languagetype;
    }
}

