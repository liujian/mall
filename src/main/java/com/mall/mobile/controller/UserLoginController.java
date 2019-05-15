package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.in.*;
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
    @RequestMapping(value="/registration",method = RequestMethod.POST)
    @ResponseBody
    public BasicData registration(@RequestBody RegistrationParam param, HttpServletRequest request) {
        try{
            return userLoginService.registration(param);
        }catch (Exception e){
          e.printStackTrace();
           return BasicData.CreateErrorMsg(e.getMessage());
        }

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
    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public BasicData userLogin(@RequestBody LoginParam param, HttpServletRequest request) {

        try{
            return userLoginService.login(param);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }


    }


    /**
     * 切换登录语言主题订阅
     *
     * @param param
     * @return
     * @throws Exception
     * @author liujian
     * @Date 2018-09-25
     */
    @RequestMapping(value="/subTopic",method = RequestMethod.POST)
    @ResponseBody
    public BasicData subTopic(@RequestBody TokenParam param, HttpServletRequest request) {

        try{
            return userLoginService.subTopic(param);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }


    }


    /**
     * 修改登录邮箱
     *
     * @param param
     * @return
     */
    @RequestMapping(value="/updateEmail",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateEmail(@RequestBody UpdateEmaileParam param) {


        try{
            return userLoginService.updateEmail(param);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改登录密码
     *
     * @param param
     * @return
     */
    @RequestMapping(value="/updatePassword",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updatePassword(@RequestBody NewPasswordParam param) {
        try{
            return userLoginService.updatePassword(param);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

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
    @RequestMapping(value="/userLogout",method = RequestMethod.POST)
    @ResponseBody
    public BasicData userLogout(@RequestBody TokenParam param, HttpServletRequest request) {

        try{
            return userLoginService.logout(param);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
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
    @RequestMapping(value="/forgetPassword",method = RequestMethod.POST)
    @ResponseBody
    public BasicData forgetPassword(@RequestBody NewPasswordParam param, HttpServletRequest request) {
        try{
            return userLoginService.forgetPassword(param);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


}

