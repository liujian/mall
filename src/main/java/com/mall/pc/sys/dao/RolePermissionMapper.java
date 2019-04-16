package com.mall.pc.sys.dao;

import com.mall.base.BaseMapper;
import com.mall.pc.sys.domen.RolePermission;
import com.mall.pc.sys.domen.RolePermissionExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission, RolePermissionExample> {
}
