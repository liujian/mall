package com.mall.pc.sys.vo;

import com.mall.pc.sys.domen.Permission;

import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/22
 * @description:
 */
public class PermissionVO {
    private Permission permission;
    private List<PermissionVO> subMenuList;

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public List getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List subMenuList) {
        this.subMenuList = subMenuList;
    }
}
