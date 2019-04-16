package com.mall.pc.sys.dao;

import com.mall.base.BaseMapper;
import com.mall.pc.sys.domen.SysUser;
import com.mall.pc.sys.domen.SysUserExample;
import com.mall.pc.sys.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser, SysUserExample> {
    /**
     * 根据条件查询用户列表
     * @param sysUser
     * @return
     */
    List<SysUserVO> getUserList(SysUser sysUser);

    /**
     * 根据条件查询用户总数
     * @param sysUser
     * @return
     */
    int countUserList(SysUser sysUser);
}
