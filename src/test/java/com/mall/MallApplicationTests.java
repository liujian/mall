package com.mall;

import com.mall.common.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

	@Autowired
	private MailService mailService;
	@Test
	public void contextLoads() {


	}

//	@Test
//	public void test1() {
//		String to = "864282457@qq.com";
//		String subject = "测试";
//		String content = "今晚要加班，不用等我了";
//
//		try {
//			mailService.sendSimpleMail(to, subject, content);
//			System.out.println("成功了");
//		} catch (MailException e) {
//			System.out.println("失败了");
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void test2() {
//		String to = "1812898723@qq.com";
//		String subject = "这小美女谁啊";
//		String rscId = "img110";
//		String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";
//		// 此处为linux系统路径
//		String imgPath = "F:\\个人资料\\微信图片_20190319134141.jpg";
//		try {
//			mailService.sendInlineResourceMail(to, subject, content, imgPath, rscId);
//			System.out.println("成功了");
//		} catch (MessagingException e) {
//			System.out.println("失败了");
//			e.printStackTrace();
//		}
//	}
//
//
//
//	@Test
//	public void test3() {
//		String to = "864282457@qq.com";
//		String subject = "猜猜我今天买了啥";
//		String content = "<html><head></head><body><h3>哈哈，什么都没有</h3></body></html>";
//		try {
//			mailService.sendHtmlMail(to, subject, content);
//			System.out.println("成功了");
//		} catch (MessagingException e) {
//			System.out.println("失败了");
//			e.printStackTrace();
//		}
//	}
//
//
//	@Test
//	public void test4() {
//		String to = "864282457@qq.com";
//		String subject = "这是一个有附件的邮件，记得接受文件";
//		String content = "嗯哼？自己看附件";
//		String imgPath = "F:\\个人资料\\微信图片_20190319134141.jpg";
//		try {
//			mailService.sendAttachmentsMail(to, subject, content, imgPath);
//			System.out.println("成功了");
//		} catch (MessagingException e) {
//			System.out.println("失败了");
//			e.printStackTrace();
//		}
//
//	}
}
