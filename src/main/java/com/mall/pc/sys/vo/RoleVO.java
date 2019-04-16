package com.mall.pc.sys.vo;

import com.mall.pc.sys.domen.Role;

import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/22
 * @description:
 */
public class RoleVO extends Role {

    private List<Integer> permissionIds;

    public List<Integer> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
