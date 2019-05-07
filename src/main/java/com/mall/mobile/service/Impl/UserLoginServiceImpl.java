package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.IntegralMapper;
import com.mall.mobile.dao.InterestMapper;
import com.mall.mobile.dao.UserMapper;
import com.mall.mobile.domen.Integral;
import com.mall.mobile.domen.Interest;
import com.mall.mobile.domen.User;
import com.mall.mobile.in.*;
import com.mall.mobile.service.UserLoginService;
import com.mall.utils.CheckUtil;
import com.mall.utils.LoginUtil;
import com.mall.utils.SafetyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public BasicData registration(RegistrationParam param) {

        if(!CheckUtil.isEmail(param.getEmailAddress())){
            return BasicData.CreateErrorInvalidEmail();
        }
        if (param.getPassword() == null || param.getPassword().isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord();
        }

        User user = userMapper.selectByEmailAddress(param.getEmailAddress());
        if (user != null) {
            return BasicData.CreateErrorRegist();
        }

        String password = SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getPassword());

        user = new User();
        user.setEmailAddress(param.getEmailAddress());
        user.setPassword(password);
        //邮箱未验证
        user.setVerified("1");
  //      user.setFireBaseToken(param.getFireBaseToken());

        userMapper.insertUser(user);

        return BasicData.CreateSucess(user);
    }



    @Override
    public BasicData login(LoginParam param) {
        String EmailAddress = param.getEmailAddress();
        String password = param.getPassword();
        if(!CheckUtil.isEmail(param.getEmailAddress())){
            return BasicData.CreateErrorInvalidEmail();
        }

        if (password == null || password.isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord();
        }

        User user = userMapper.selectByEmailAddress(EmailAddress);
        if (user == null) {
            return BasicData.CreateErrorEmailOrPassword();
        }


        if (!(SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getPassword())).equals(user.getPassword())) {
            return BasicData.CreateErrorEmailOrPassword();
        }
        Map map = new HashMap<>();
        String token = LoginUtil.getToken();
        user.setToken(token);
        user.setFireBaseToken(param.getFireBaseToken());
        userMapper.updateToken(user);
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
        return BasicData.CreateSucess(map);
    }

    @Override
    public BasicData logout(TokenParam param) {

        User user = userMapper.selectByToken(param.getToken());
        if(user==null){
            return BasicData.CreateErrorAccount();
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
            return BasicData.CreateErrorInvalidEmail();
        }
        if (param.getNewPassword() == null || param.getNewPassword().isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord();
        }

        User user = userMapper.selectByEmailAddress(param.getEmailAddress());
        if (user == null) {
            return BasicData.CreateErrorAccount();
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
            return BasicData.CreateErrorInvalidEmail();
        }
        if(!CheckUtil.isEmail(param.getNewEmailAddress())){
            return BasicData.CreateErrorInvalidEmail();
        }

        if (password == null || password.isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord();
        }
        User user = userMapper.selectByEmailAddress(param.getNewEmailAddress());
        if (user != null) {
            return BasicData.CreateErrorRegist();
        }


        User user1 = userMapper.selectByEmailAddress(EmailAddress);
        if (user1 == null) {
            return BasicData.CreateErrorEmailOrPassword();
        }


        if (!(SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getPassword())).equals(user1.getPassword())) {
            return BasicData.CreateErrorEmailOrPassword();
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
            return BasicData.CreateErrorInvalidUser();
        }
        if (param.getPassword() == null || param.getPassword().isEmpty()) {
            return BasicData.CreateErrorInvalidPassWord();
        }
        if (!(SafetyUtil.addMD5Salt(user.getEmailAddress(),param.getPassword())).equals(user.getPassword())) {
            return BasicData.CreateErrorEmailOrPassword();
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

