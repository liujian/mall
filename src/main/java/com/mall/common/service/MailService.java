package com.mall.common.service;

import org.springframework.mail.MailException;

import javax.mail.MessagingException;

public interface MailService {

    /**
     * 简单的文本邮件
     * @param to 邮件接受者
     * @param subject  主题
     * @param content 内容
     * @throws MailException
     */
    public void sendSimpleMail(String to, String subject, String content) throws MailException;

    /**
     * 富文本邮件 如果需要发送多张图片，可以改变传参方式，使用集合添加多个<img src='cid:rscId'>和
     *helper.addInline(rscId, res);即可实现
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @throws MessagingException
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException;

    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException;

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException;
}
