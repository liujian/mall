package com.mall.pc.sys.dao;

import com.mall.base.BaseMapper;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.domen.RoleExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleExample> {

    /**
     * 根据条件查询角色列表
     * @param role
     * @return
     */
    List<Role> getRoleList(Role role);
}
