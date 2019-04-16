package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.in.LoginParam;
import com.mall.mobile.in.NewPasswordParam;
import com.mall.mobile.in.RegistrationParam;
import com.mall.mobile.in.TokenParam;
import com.mall.mobile.service.UserLoginService;
import com.mall.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-09 10:03
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;


    /**
     * 用户注册
     *
     * @param param
     * @return
     * @throws Exception
     * @author liujian
     * @Date 2018-09-25
     */
    @RequestMapping("registration")
    @ResponseBody
    public BasicData registration(@Valid @RequestBody RegistrationParam param, HttpServletRequest request) {

        return userLoginService.registration(param);
    }

//    /**
//     * 获取邮箱验证码
//     *
//     * @param param
//     * @return
//     */
//    @RequestMapping("getCode")
//    @ResponseBody
//    public BasicData getCode(@Valid @RequestBody GetCodeParam param) {
//        BasicData result = new BasicData();
//        String code = LoginUtil.getRandNum(6);
//        GetCodeResult data = new GetCodeResult();
//        data.setFlag(this.userLoginService.sendCode(param, code));
//        result.setData(data);
//        return result;
//    }


    /**
     * 用户登陆
     *
     * @param param
     * @return
     * @throws Exception
     * @author liujian
     * @Date 2018-09-25
     */
    @RequestMapping("userLogin")
    @ResponseBody
    public BasicData userLogin(@Valid @RequestBody LoginParam param, HttpServletRequest request) {
        return userLoginService.login(param);
    }

    /**
     * 用户登出
     *
     * @param param
     * @return
     * @throws Exception
     * @author liujian
     * @Date 2018-09-25
     */
    @RequestMapping("userLogout")
    @ResponseBody
    public BasicData userLogout(@Valid @RequestBody TokenParam param, HttpServletRequest request) {
        return userLoginService.logout(param);
    }


        /**
          * 忘记密码
          *
          * @param param
          * @return
          * @throws Exception
          * @author liujian
          * @Date 2018-11-05
          */
    @RequestMapping("forgetPassword")
    @ResponseBody
    public BasicData forgetPassword(@Valid @RequestBody NewPasswordParam param, HttpServletRequest request) {

        return userLoginService.forgetPassword(param);
    }


}

