package com.mall.pc.sys.vo;

import com.mall.pc.sys.domen.SysUser;

/**
 * @author:mengchen
 * @date:2019/2/22
 * @description:
 */
public class SysUserVO extends SysUser {
    private String stateName;
    private String roleName;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
