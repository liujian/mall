package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.common.service.MailService;
import com.mall.mobile.dao.IntegralMapper;
import com.mall.mobile.dao.InterestMapper;
import com.mall.mobile.dao.UserMapper;
import com.mall.mobile.domen.Integral;
import com.mall.mobile.domen.Interest;
import com.mall.mobile.domen.User;
import com.mall.mobile.in.*;
import com.mall.mobile.service.UserLoginService;
import com.mall.utils.CheckUtil;
import com.mall.utils.FireBaseUtils;
import com.mall.utils.LoginUtil;
import com.mall.utils.SafetyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-09 10:07
 **/
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IntegralMapper integralMapper;

    @Autowired
    private InterestMapper interestMapper;

    @Autowired
    private FireBaseUtils fireBaseUtils;

    @Autowired
    private MailService mailService;
    @Value("${server.port}")
    protected String port;

    @Resource
    TemplateEngine templateEngine;

    @Override
    public BasicData registration(RegistrationParam param) {

        if(!CheckUtil.isEmail(param.getEmailAddress())){
            return BasicData.CreateErrorInvalidEmail(param.getLanguagetype());
        }
        if (param.getPassword() == null || param.getPassword().isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord(param.getLanguagetype());
        }

        User user = userMapper.selectByEmailAddress(param.getEmailAddress());
        if (user != null) {
            return BasicData.CreateErrorRegist(param.getLanguagetype());
        }

        String password = SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getPassword());

        user = new User();
        user.setEmailAddress(param.getEmailAddress());
        user.setPassword(password);
        user.setLanguagetype(param.getLanguagetype());
        //邮箱未验证
        user.setVerified("1");
  //      user.setFireBaseToken(param.getFireBaseToken());

        userMapper.insertUser(user);
        user = userMapper.selectByEmailAddress(user.getEmailAddress());
        Map map = new HashMap<>();
        String token = LoginUtil.getToken();
        user.setToken(token);
        user.setFireBaseToken(param.getFireBaseToken());
        userMapper.updateToken(user);
        //增加用户语言主题订阅
        fireBaseUtils.subTopic(param.getFireBaseToken(),param.getLanguagetype());

        //获取用户积分信息
        Integral integral = integralMapper.getIntegralByUserid(user.getId());
        if(integral==null){
            integral =new Integral();
            integral.setUserid(user.getId());
            integral.setExpendscore(0);
            integral.setSurpluscore(0);
            integral.setTotalscore(0);
            integralMapper.addIntegral(integral);
        }
        //获取用户喜爱信息
        List<Interest> interest = interestMapper.getInterestList(user.getId());

        map.put("user",user);
        map.put("integral",integral);
        map.put("interestsize",interest.size());

		String to = user.getEmailAddress();
		String subject = "小口袋: Please verify your email account";

        Context context = new Context();
        context.setVariable("emailadress", user.getEmailAddress());
        String tempContext = templateEngine.process("/registration", context);
		try {
			mailService.sendHtmlMail(to, subject, tempContext);
			System.out.println("成功了");
		} catch (MessagingException e) {
			System.out.println("失败了");
			e.printStackTrace();
		}

        return BasicData.CreateSucess(map,param.getLanguagetype());

    }



    @Override
    public BasicData login(LoginParam param) {
        String EmailAddress = param.getEmailAddress();
        String password = param.getPassword();
        if(!CheckUtil.isEmail(param.getEmailAddress())){
            return BasicData.CreateErrorInvalidEmail(param.getLanguagetype());
        }

        if (password == null || password.isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord(param.getLanguagetype());
        }

        User user = userMapper.selectByEmailAddress(EmailAddress);
        if (user == null) {
            return BasicData.CreateErrorEmailOrPassword(param.getLanguagetype());
        }


        if (!(SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getPassword())).equals(user.getPassword())) {
            return BasicData.CreateErrorEmailOrPassword(param.getLanguagetype());
        }
        //取消用户原来语言主题订阅
        fireBaseUtils.subTopic(user.getFireBaseToken(),user.getLanguagetype());

        Map map = new HashMap<>();
        String token = LoginUtil.getToken();
        user.setToken(token);
        user.setFireBaseToken(param.getFireBaseToken());
        user.setLanguagetype(param.getLanguagetype());
        userMapper.updateToken(user);
        //增加用户新语言主题订阅
        fireBaseUtils.subTopic(param.getFireBaseToken(),param.getLanguagetype());

        //获取用户积分信息
        Integral integral = integralMapper.getIntegralByUserid(user.getId());
        if(integral==null){
            integral =new Integral();
            integral.setUserid(user.getId());
            integral.setExpendscore(0);
            integral.setSurpluscore(0);
            integral.setTotalscore(0);
            integralMapper.addIntegral(integral);
        }
        //获取用户喜爱信息
        List<Interest> interest = interestMapper.getInterestList(user.getId());

        map.put("user",user);
        map.put("integral",integral);
        map.put("interestsize",interest.size());
        return BasicData.CreateSucess(map,param.getLanguagetype());
    }

    @Override
    public BasicData subTopic(TokenParam param) {
        User user = userMapper.selectByToken(param.getToken());
        if(user==null){
            return BasicData.CreateErrorInvalidUser(param.getLanguagetype());
        }
        //取消用户原来语言主题订阅
        fireBaseUtils.subTopic(user.getFireBaseToken(),user.getLanguagetype());

        user.setLanguagetype(param.getLanguagetype());
        userMapper.updateToken(user);
        //增加用户新语言主题订阅
        fireBaseUtils.subTopic(user.getFireBaseToken(),param.getLanguagetype());

        return BasicData.CreateSucess(null,param.getLanguagetype());
    }

    @Override
    public BasicData logout(TokenParam param) {

        User user = userMapper.selectByToken(param.getToken());
        if(user==null){
            return BasicData.CreateErrorAccount(param.getLanguagetype());
        }else{
            user.setFireBaseToken("");
            user.setToken("");

            userMapper.updateToken(user);

        }
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData forgetPassword(NewPasswordParam param) {

        if (param.getEmailAddress() == null || param.getEmailAddress().isEmpty()) {
            return BasicData.CreateErrorInvalidEmail(param.getLanguagetype());
        }
        if (param.getNewPassword() == null || param.getNewPassword().isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord(param.getLanguagetype());
        }

        User user = userMapper.selectByEmailAddress(param.getEmailAddress());
        if (user == null) {
            return BasicData.CreateErrorAccount(param.getLanguagetype());
        }

        String password = SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getNewPassword());
        user.setPassword(password);
        user.setUpdateDate(new Date());
        userMapper.updatePassword(user);

        return BasicData.CreateSucess(user);
    }

    @Override
    public BasicData updateEmail(UpdateEmaileParam param) {
        String EmailAddress = param.getEmailAddress();
        String password = param.getPassword();


        if(!CheckUtil.isEmail(param.getEmailAddress())){
            return BasicData.CreateErrorInvalidEmail(param.getLanguagetype());
        }
        if(!CheckUtil.isEmail(param.getNewEmailAddress())){
            return BasicData.CreateErrorInvalidEmail(param.getLanguagetype());
        }

        if (password == null || password.isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord(param.getLanguagetype());
        }
        User user = userMapper.selectByEmailAddress(param.getNewEmailAddress());
        if (user != null) {
            return BasicData.CreateErrorRegist(param.getLanguagetype());
        }


        User user1 = userMapper.selectByEmailAddress(EmailAddress);
        if (user1 == null) {
            return BasicData.CreateErrorEmailOrPassword(param.getLanguagetype());
        }


        if (!(SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getPassword())).equals(user1.getPassword())) {
            return BasicData.CreateErrorEmailOrPassword(param.getLanguagetype());
        }
        String newpassword = SafetyUtil.addMD5Salt(param.getNewEmailAddress(),param.getPassword());

        user1.setEmailAddress(param.getNewEmailAddress());
        user1.setPassword(newpassword);
        userMapper.updateEmail(user1);
        String token = LoginUtil.getToken();
        user1.setToken(token);
        userMapper.updateToken(user1);
        return BasicData.CreateSucess(user1);
    }

    @Override
    public BasicData updatePassword(NewPasswordParam param) {
        User user = userMapper.selectByToken(param.getToken());
        if(user==null){
            return BasicData.CreateErrorInvalidUser(param.getLanguagetype());
        }
        if (param.getPassword() == null || param.getPassword().isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord(param.getLanguagetype());
        }
        if (!(SafetyUtil.addMD5Salt(user.getEmailAddress(),param.getPassword())).equals(user.getPassword())) {
            return BasicData.CreateErrorEmailOrPassword(param.getLanguagetype());
        }
        String newpassword = SafetyUtil.addMD5Salt(user.getEmailAddress(),param.getNewPassword());

        user.setPassword(newpassword);
        userMapper.updateEmail(user);
        String token = LoginUtil.getToken();
        user.setToken(token);
        userMapper.updateToken(user);
        return  BasicData.CreateSucess(user);
    }


}

