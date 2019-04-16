package com.mall.pc.sys.dao;

import com.mall.base.BaseMapper;
import com.mall.pc.sys.domen.Permission;
import com.mall.pc.sys.domen.PermissionExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission, PermissionExample> {

}
