package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.IntegralMapper;
import com.mall.mobile.dao.InterestMapper;
import com.mall.mobile.dao.UserMapper;
import com.mall.mobile.domen.Integral;
import com.mall.mobile.domen.Interest;
import com.mall.mobile.domen.User;
import com.mall.mobile.in.LoginParam;
import com.mall.mobile.in.NewPasswordParam;
import com.mall.mobile.in.RegistrationParam;
import com.mall.mobile.in.TokenParam;
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
        if (param.getEmailAddress() == null || param.getEmailAddress().isEmpty()) {
            return BasicData.CreateErrorMsg("Email address is empty");
        }
        if(!CheckUtil.isEmail(param.getEmailAddress())){
            return BasicData.CreateErrorMsg("Illegal mailbox");
        }


        if (param.getPassword() == null || param.getPassword().isEmpty()) {
            return BasicData.CreateErrorInvalidUser();
        }




        User user = userMapper.selectByEmailAddress(param.getEmailAddress());
        if (user != null) {
            return BasicData.CreateErrorMsg("User["+param.getEmailAddress()+"] Already Exist");
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
        if (EmailAddress == null || EmailAddress.isEmpty()) {
            return BasicData.CreateErrorMsg("Email address is empty");
        }

        if(!CheckUtil.isEmail(param.getEmailAddress())){
            return BasicData.CreateErrorMsg("Illegal mailbox");
        }

        if (password == null || password.isEmpty()) {
            return BasicData.CreateErrorMsg("Password is empty");
        }

        User user = userMapper.selectByEmailAddress(EmailAddress);
        if (user == null) {
            return BasicData.CreateErrorMsg("The Email or password you entered is incorrect!");
        }


        if (!(SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getPassword())).equals(user.getPassword())) {
            return BasicData.CreateErrorMsg("The Email or password you entered is incorrect!");
        }
        Map map = new HashMap<>();
        String token = LoginUtil.getToken();
        user.setToken(token);
        user.setFireBaseToken(param.getFireBaseToken());
        userMapper.updateToken(user);
        //获取用户积分信息
        Integral integral = integralMapper.getIntegralByUserid(user.getId());
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
            return BasicData.CreateErrorMsg("This account not exists!");
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
            return BasicData.CreateErrorMsg("Email address is empty");
        }
        if (param.getNewPassword() == null || param.getNewPassword().isEmpty()) {
            return BasicData.CreateErrorMsg("NewPassword is empty");
        }

        User user = userMapper.selectByEmailAddress(param.getEmailAddress());
        if (user == null) {
            return BasicData.CreateErrorMsg("This account does not exist!");
        }

        String password = SafetyUtil.addMD5Salt(param.getEmailAddress(),param.getNewPassword());
        user.setPassword(password);
        user.setUpdateDate(new Date());
        userMapper.updatePassword(user);

        return BasicData.CreateSucess(user);
    }


}

