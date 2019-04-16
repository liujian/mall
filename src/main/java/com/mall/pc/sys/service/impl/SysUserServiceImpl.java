package com.mall.pc.sys.service.impl;

import com.mall.base.InvalidOldPasswordException;
import com.mall.pc.sys.dao.RoleMapper;
import com.mall.pc.sys.dao.SysUserMapper;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.domen.RoleExample;
import com.mall.pc.sys.domen.SysUser;
import com.mall.pc.sys.domen.SysUserExample;
import com.mall.pc.sys.dto.Password;
import com.mall.pc.sys.service.SysUserService;
import com.mall.pc.sys.vo.SysUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/21
 * @description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Value("${default.password}")
    private String defaultPassword;
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public Role getRole(Integer roleId) {
        RoleExample exmple = new RoleExample();
        RoleExample.Criteria criteria = exmple.createCriteria();
        if (roleId != null) {
            criteria.andIdEqualTo(roleId);
        }
        List<Role> roleList = roleMapper.selectByExample(exmple);

        return roleList.get(0);
    }

    /**
     * 根据条件查询用户列表
     * @param loginName
     * @return
     */
    @Override
    public List<SysUserVO> getUserList(String loginName) {
        SysUser user = new SysUser();
        user.setLoginName(loginName);
        List<SysUserVO> sysUserList = sysUserMapper.getUserList(user);
        return sysUserList;
    }

    /**
     * 根据条件查询用户总数
     * @param sysUser
     * @return
     */
    @Override
    public int countUserList(SysUser sysUser) {
        int count = sysUserMapper.countUserList(sysUser);
        return count;
    }

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    @Override
    public void addUser(SysUser sysUser) throws ParseException {
        Date currentDate = new Date();
        sysUser.setCreateTime(formatter.parse(formatter.format(currentDate)));
        sysUser.setUpdateTime(formatter.parse(formatter.format(currentDate)));
        String pwdMd5 = new SimpleHash("md5", defaultPassword, null, 2).toHex();
        sysUser.setPassword(pwdMd5);
        sysUserMapper.insert(sysUser);
    }

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    @Override
    public void updateUser(SysUser sysUser) throws ParseException {
        SysUser user = sysUserMapper.selectByPrimaryKey(sysUser.getId());
        Date currentDate = new Date();
        sysUser.setUpdateTime(formatter.parse(formatter.format(currentDate)));
        sysUser.setCreateTime(user.getCreateTime());
        sysUser.setPassword(user.getPassword());
        sysUserMapper.updateByPrimaryKey(sysUser);
    }

    /**
     * 删除用户
     * @param id  用户ID
     * @return
     */
    @Override
    public void deleteUser(Integer id) {
        sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据用户ID查询
     * @param id
     * @return
     */
    @Override
    public SysUser getUserById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据登录名查询
     * @param loginName
     * @return
     */
    @Override
    public SysUser findByLoginName(String loginName) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(example);

        return sysUserList.get(0);
    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public void updatePassword(String oldPassword, String newPassword) throws InvalidOldPasswordException {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        Password password = new Password();

        if(!sysUser.getPassword().equals(password.encryptPassword(oldPassword))){
            throw new InvalidOldPasswordException(newPassword);
        }

        String newPwd = password.encryptPassword(newPassword);
        sysUser.setPassword(newPwd);
        sysUserMapper.updateByPrimaryKey(sysUser);
    }

    /**
     * 查询用户名是否已存在
     * @param id
     * @param loginName
     * @return
     */
    @Override
    public Boolean validLoginName(Integer id, String loginName) {
        if (id == null) {//新增校验
            SysUserExample sysUserExample = new SysUserExample();
            SysUserExample.Criteria criteria = sysUserExample.createCriteria();
            criteria.andLoginNameEqualTo(loginName);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            if (sysUsers.size() > 0) {
                return true;
            } else {
                return false;
            }

        } else {//修改校验
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
            if (loginName.equals(sysUser.getLoginName())) {
                return false;
            } else {
                SysUserExample sysUserExample1 = new SysUserExample();
                SysUserExample.Criteria criteria1 = sysUserExample1.createCriteria();
                criteria1.andLoginNameEqualTo(loginName);
                List<SysUser> sysUsers1 = sysUserMapper.selectByExample(sysUserExample1);
                if (sysUsers1.size() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * 查询手机号是否已存在
     * @param id
     * @param phone
     * @return
     */
    @Override
    public Boolean validPhone(Integer id, String phone) {
        if (id == null) {//新增校验
            SysUserExample sysUserExample = new SysUserExample();
            SysUserExample.Criteria criteria = sysUserExample.createCriteria();
            criteria.andPhoneEqualTo(phone);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            if (sysUsers.size() > 0) {
                return true;
            } else {
                return false;
            }

        } else {//修改校验
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
            if (phone.equals(sysUser.getPhone())) {
                return false;
            } else {
                SysUserExample sysUserExample1 = new SysUserExample();
                SysUserExample.Criteria criteria1 = sysUserExample1.createCriteria();
                criteria1.andPhoneEqualTo(phone);
                List<SysUser> sysUsers1 = sysUserMapper.selectByExample(sysUserExample1);
                if (sysUsers1.size() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
