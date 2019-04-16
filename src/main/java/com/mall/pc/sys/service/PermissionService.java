package com.mall.pc.sys.service;

import com.mall.pc.sys.vo.PermissionVO;

import java.util.List;

public interface PermissionService {
    /**
     * 获取当前用户菜单树
     * @return
     */
    List<PermissionVO> getMenuTree();

    /**
     * 获取权限树
     * @return
     */
    List<PermissionVO> getPermissionTree();
}
