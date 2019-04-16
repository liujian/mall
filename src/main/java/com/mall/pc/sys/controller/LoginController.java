package com.mall.pc.sys.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.sys.domen.Permission;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.domen.SysUser;
import com.mall.pc.sys.service.RoleService;
import com.mall.pc.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:mengchen
 * @date:2019/2/21
 * @description:
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> login(@RequestParam String loginName, @RequestParam String password) {
        //用来存放添加的返回消息
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        try {
            subject.login(token);
            subject.getSession().setTimeout(1800000*2*24*7);

            SysUser SysUser = (SysUser) subject.getPrincipal();
            Role role = sysUserService.getRole(SysUser.getRoleId());
            ArrayList<String> permissionList = new ArrayList<String>();
            for (Permission p : roleService.getPermissions(role.getId())) {
                permissionList.add(p.getPermCode());
            }
            map.put("token", subject.getSession().getId());
            map.put("permissionList", permissionList);
            map.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            map.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            map.put("msg", "登录失败，该用户已被冻结");
        } catch (AccountException e) {
            map.put("msg", "权限异常");
        } catch (AuthenticationException e) {
            map.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/androidlogin", method = RequestMethod.POST)
    @ResponseBody
    public BasicData androidlogin(@RequestBody SysUser sysUser) {
        //用来存放添加的返回消息
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getLoginName(), sysUser.getPassword());
        try {
            subject.login(token);
            subject.getSession().setTimeout(-1000l);
            map.put("token", subject.getSession().getId());
            map.put("msg", "登录成功");
            return BasicData.CreateSucess(map);
        } catch (IncorrectCredentialsException e) {
            return BasicData.CreateErrorMsg("密码错误");
        } catch (LockedAccountException e) {
            return BasicData.CreateErrorMsg("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            return BasicData.CreateErrorMsg("该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }



    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> logout() {
        //用来存放添加的返回消息
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            map.put("msg", "退出成功");
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Map<String, Object> unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 401);
        map.put("msg", "未登录");
        return map;
    }
}
