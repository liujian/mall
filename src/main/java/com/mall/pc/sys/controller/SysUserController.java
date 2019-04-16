package com.mall.pc.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.param.BasicData;
import com.mall.base.InvalidOldPasswordException;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.domen.SysUser;
import com.mall.pc.sys.dto.PasswordDTO;
import com.mall.pc.sys.dto.SysUserDTO;
import com.mall.pc.sys.service.SysUserService;
import com.mall.pc.sys.vo.SysUserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/22
 * @description:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 根据条件查询用户列表
     * @param dto  查询条件
     * @return
     */
    @RequestMapping(value="/getUserList",method = RequestMethod.POST)
    @ResponseBody
    public BasicData getUserList(@RequestBody SysUserDTO dto){
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        try {
            List<SysUserVO> userList = sysUserService.getUserList(dto.getLoginName());
            PageInfo<SysUserVO> pageData = new PageInfo<>(userList);
            return BasicData.CreateSucess(pageData);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ResponseBody
    public BasicData addUser(@RequestBody SysUser sysUser){
        try {
            sysUserService.addUser(sysUser);
            return BasicData.CreateSucess();
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateUser(@RequestBody SysUser sysUser){
        try {
            sysUserService.updateUser(sysUser);
            return BasicData.CreateSucess();
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 删除用户
     * @param id  用户ID
     * @return
     */
    @RequestMapping(value="/deleteUser",method = RequestMethod.GET)
    @ResponseBody
    public BasicData deleteUser(@RequestParam Integer id){
        try {
            sysUserService.deleteUser(id);
            return BasicData.CreateSucess();
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 根据用户ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="/getUserById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getUserById(@RequestParam Integer id){
        try {
            SysUser sysUser = sysUserService.getUserById(id);
            return BasicData.CreateSucess(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 根据登录名查询
     * @param loginname
     * @return
     */
    @RequestMapping(value="/findByLoginName",method = RequestMethod.POST)
    @ResponseBody
    public BasicData findByLoginName(@RequestParam String loginname){
        try {
            SysUser sysUser = sysUserService.findByLoginName(loginname);
            return BasicData.CreateSucess(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 根据登录名查询角色
     * @param loginName
     * @return
     */
    @RequestMapping(value="/findRoleByLoginName",method = RequestMethod.GET)
    @ResponseBody
    public BasicData findRoleByLoginName(@RequestParam String loginName){
        try {
            SysUser sysUser = sysUserService.findByLoginName(loginName);
            Role role = sysUserService.getRole(sysUser.getRoleId());
            String roleCode = role.getRoleCode();
            return BasicData.CreateSucess(roleCode);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 修改密码
     * @param dto
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public BasicData updatePassword(@RequestBody PasswordDTO dto) {
        try {
            String oldPassword = dto.getOldPassword();
            String newPassword = dto.getNewPassword();
            sysUserService.updatePassword(oldPassword, newPassword);
            return BasicData.CreateSucess();
        } catch (InvalidOldPasswordException e) {
            return BasicData.CreateErrorMsg("旧密码错误");
        } catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 查询用户名是否已存在
     * @param id
     * @param loginName
     * @return
     */
    @RequestMapping(value="/validLoginName",method = RequestMethod.GET)
    @ResponseBody
    public BasicData validLoginName(@RequestParam Integer id, @RequestParam String loginName){
        try {
            Boolean flag = sysUserService.validLoginName(id, loginName);
            return BasicData.CreateSucess(flag);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 查询手机号是否已存在
     * @param id
     * @param phone
     * @return
     */
    @RequestMapping(value="/validPhone",method = RequestMethod.GET)
    @ResponseBody
    public BasicData validPhone(@RequestParam Integer id, @RequestParam String phone){
        try {
            Boolean flag = sysUserService.validPhone(id, phone);
            return BasicData.CreateSucess(flag);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

}
