package com.mall.pc.sys.service.impl;

import com.mall.pc.sys.dao.PermissionMapper;
import com.mall.pc.sys.dao.RoleMapper;
import com.mall.pc.sys.dao.RolePermissionMapper;
import com.mall.pc.sys.domen.*;
import com.mall.pc.sys.service.RoleService;
import com.mall.pc.sys.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/21
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService {
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Permission> getPermissions(Integer id) {
        RolePermissionExample rpExample = new RolePermissionExample();
        RolePermissionExample.Criteria rpCriteria = rpExample.createCriteria();
        rpCriteria.andRoleIdEqualTo(id);
        List<RolePermission> rpList = rolePermissionMapper.selectByExample(rpExample);

        ArrayList<Integer> permIdList = new ArrayList<Integer>();

        for (RolePermission list : rpList) {
            permIdList.add(list.getPermId());
        }

        PermissionExample example = new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(permIdList);
        example.setOrderByClause("sort asc");
        List<Permission> permissionList = permissionMapper.selectByExample(example);

        return permissionList;
    }

    /**
     * 根据条件查询角色列表
     * @param roleName
     * @param state
     * @return
     */
    @Override
    public List<Role> getRoleList(String roleName, String state) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setState(state);
        List<Role> roleList = roleMapper.getRoleList(role);
        return roleList;
    }

    /**
     * 新增角色
     * @param vo
     * @return
     */
    @Override
    @Transactional
    public void addRole(RoleVO vo) throws ParseException {
        Date currentDate = new Date();
        Role role = new Role();
        role.setCreateTime(formatter.parse(formatter.format(currentDate)));
        role.setUpdateTime(formatter.parse(formatter.format(currentDate)));
        role.setRoleName(vo.getRoleName());
        role.setState(vo.getState());
        role.setRemark(vo.getRemark());
        roleMapper.insert(role);

        List<Integer> Ids = vo.getPermissionIds();
        for (Integer permId : Ids) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(role.getId());
            rolePermission.setPermId(permId);
            rolePermissionMapper.insert(rolePermission);
        }
    }

    /**
     * 修改角色
     * @param vo
     * @return
     */
    @Override
    @Transactional
    public void updateRole(RoleVO vo) throws ParseException {
        Role sRole = roleMapper.selectByPrimaryKey(vo.getId());
        Date currentDate = new Date();
        vo.setUpdateTime(formatter.parse(formatter.format(currentDate)));
        vo.setCreateTime(sRole.getCreateTime());
        roleMapper.updateByPrimaryKey(vo);

        RolePermissionExample exmple = new RolePermissionExample();
        RolePermissionExample.Criteria cr = exmple.createCriteria();
        cr.andRoleIdEqualTo(vo.getId());
        rolePermissionMapper.deleteByExample(exmple);

        List<Integer> Ids = vo.getPermissionIds();
        for (Integer permId : Ids) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(vo.getId());
            rolePermission.setPermId(permId);
            rolePermissionMapper.insert(rolePermission);
        }
    }

    /**
     * 删除角色
     * @param id  角色ID
     * @return
     */
    @Override
    @Transactional
    public void deleteRole(Integer id) {
        RolePermissionExample exmple = new RolePermissionExample();
        RolePermissionExample.Criteria cr = exmple.createCriteria();
        cr.andRoleIdEqualTo(id);
        rolePermissionMapper.deleteByExample(exmple);
        roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据角色ID查询
     * @param id
     * @return
     */
    @Override
    public RoleVO getRoleById(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(role, vo);

        RolePermissionExample example = new RolePermissionExample();
        RolePermissionExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(id);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);

        ArrayList<Integer> permIdList = new ArrayList<Integer>();

        for (RolePermission list : rolePermissions) {
            permIdList.add(list.getPermId());
        }
        vo.setPermissionIds(permIdList);
        return vo;
    }

    /**
     * 查询角色编码是否已存在
     * @param id
     * @param roleCode
     * @return
     */
    @Override
    public Boolean validRoleCode(Integer id, String roleCode) {
        if (id == null) {//新增校验
            RoleExample roleExample = new RoleExample();
            RoleExample.Criteria criteria = roleExample.createCriteria();
            criteria.andRoleCodeEqualTo(roleCode);
            List<Role> roles = roleMapper.selectByExample(roleExample);
            if (roles.size() > 0) {
                return true;
            } else {
                return false;
            }

        } else {//修改校验
            Role role = roleMapper.selectByPrimaryKey(id);
            if (roleCode.equals(role.getRoleCode())) {
                return false;
            } else {
                RoleExample roleExample1 = new RoleExample();
                RoleExample.Criteria criteria1 = roleExample1.createCriteria();
                criteria1.andRoleCodeEqualTo(roleCode);
                List<Role> roles1 = roleMapper.selectByExample(roleExample1);
                if (roles1.size() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}
