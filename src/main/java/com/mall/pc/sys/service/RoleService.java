package com.mall.pc.sys.service;

import com.mall.pc.sys.domen.Permission;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.vo.RoleVO;

import java.text.ParseException;
import java.util.List;

public interface RoleService {
    List<Permission> getPermissions(Integer id);

    /**
     * 根据条件查询角色列表
     * @param roleName
     * @param state
     * @return
     */
    List<Role> getRoleList(String roleName, String state);

    /**
     * 新增角色
     * @param vo
     * @return
     */
    void addRole(RoleVO vo) throws ParseException;

    /**
     * 修改角色
     * @param vo
     * @return
     */
    void updateRole(RoleVO vo) throws ParseException;

    /**
     * 删除角色
     * @param id  角色ID
     * @return
     */
    void deleteRole(Integer id);

    /**
     * 根据角色ID查询
     * @param id
     * @return
     */
    RoleVO getRoleById(Integer id);

    /**
     * 查询角色编码是否已存在
     * @param id
     * @param roleCode
     * @return
     */
    Boolean validRoleCode(Integer id, String roleCode);
}
