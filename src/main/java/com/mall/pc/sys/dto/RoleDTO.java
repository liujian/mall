package com.mall.pc.sys.dto;

/**
 * @author:mengchen
 * @date:2019/3/7
 * @description:
 */
public class RoleDTO extends UtilDTO{
    private String roleName;
    private String state;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
