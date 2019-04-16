package com.mall.pc.sys.service.impl;

import com.mall.pc.sys.dao.PermissionMapper;
import com.mall.pc.sys.domen.Permission;
import com.mall.pc.sys.domen.PermissionExample;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.domen.SysUser;
import com.mall.pc.sys.service.PermissionService;
import com.mall.pc.sys.service.RoleService;
import com.mall.pc.sys.service.SysUserService;
import com.mall.pc.sys.vo.PermissionVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/22
 * @description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionMapper permissionMapper;
    /**
     * 获取当前用户菜单树
     * @return
     */
    @Override
    public List<PermissionVO> getMenuTree() {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        //用户角色
        Role role = sysUserService.getRole(sysUser.getRoleId());

        //权限列表
        List<Permission> permissionList = roleService.getPermissions(role.getId());

        ArrayList<PermissionVO> voList = new ArrayList<PermissionVO>();
        for (Permission permission : permissionList) {
            PermissionVO vo = new PermissionVO();
            vo.setPermission(permission);
            if (permission.getParentId() == 0) {
                List subMenuList = getPermissionByParentId(permission.getId(),permissionList);
                if (subMenuList.size() > 0) {
                    vo.setSubMenuList(subMenuList);
                }
                voList.add(vo);
            }

        }

        return voList;
    }

    /**
     * 获取权限树
     * @return
     */
    @Override
    public List<PermissionVO> getPermissionTree() {
        List<Permission> list = permissionMapper.selectByExample(null);

        ArrayList<PermissionVO> voList = new ArrayList<PermissionVO>();
        for (Permission permission : list) {
            PermissionVO vo = new PermissionVO();
            vo.setPermission(permission);
            if (permission.getParentId() == 0) {
                List<PermissionVO> subMenuList = getPermissionByParentId(permission.getId(),list);
                if (subMenuList.size() > 0) {
                    vo.setSubMenuList(subMenuList);
                }
                voList.add(vo);
            }
        }

        return voList;
    }

    /**
     * 根据父ID获取子菜单
     * @param id
     * @return
     */
    private List<PermissionVO> getPermissionByParentId(Integer id,List<Permission> permissionList1) {

        PermissionExample exmple = new PermissionExample();
        PermissionExample.Criteria cr = exmple.createCriteria();
        cr.andParentIdEqualTo(id);
        exmple.setOrderByClause("sort asc");
        List<Permission> permissionList = permissionMapper.selectByExample(exmple);
        ArrayList<PermissionVO> voList = new ArrayList<PermissionVO>();
        for (Permission permission : permissionList) {
            PermissionVO vo = new PermissionVO();
            vo.setPermission(permission);
            if ("1".equals(permission.getType())) {
                List<PermissionVO> subMenuList = getPermissionByParentId(permission.getId(),permissionList1);
                if (subMenuList.size() > 0) {
                    vo.setSubMenuList(subMenuList);
                }

            }
            if (permissionList1.contains(permission)) {
                voList.add(vo);
            }

        }
        return voList;
    }
}
