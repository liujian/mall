package com.mall.pc.sys.service;

import com.mall.base.InvalidOldPasswordException;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.domen.SysUser;
import com.mall.pc.sys.vo.SysUserVO;

import java.text.ParseException;
import java.util.List;

public interface SysUserService {
    Role getRole(Integer roleId);

    /**
     * 根据条件查询用户列表
     * @param loginName
     * @return
     */
    List<SysUserVO> getUserList(String loginName);

    /**
     * 根据条件查询用户总数
     * @param sysUser
     * @return
     */
    int countUserList(SysUser sysUser);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    void addUser(SysUser sysUser) throws ParseException;

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    void updateUser(SysUser sysUser) throws ParseException;

    /**
     * 删除用户
     * @param id  用户ID
     * @return
     */
    void deleteUser(Integer id);

    /**
     * 根据用户ID查询
     * @param id
     * @return
     */
    SysUser getUserById(Integer id);

    /**
     * 根据登录名查询
     * @param loginName
     * @return
     */
    SysUser findByLoginName(String loginName);

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    void updatePassword(String oldPassword, String newPassword) throws InvalidOldPasswordException;

    /**
     * 查询用户名是否已存在
     * @param id
     * @param loginName
     * @return
     */
    Boolean validLoginName(Integer id, String loginName);

    /**
     * 查询手机号是否已存在
     * @param id
     * @param phone
     * @return
     */
    Boolean validPhone(Integer id, String phone);
}
