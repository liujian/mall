package com.mall.pc.sys.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.sys.service.PermissionService;
import com.mall.pc.sys.vo.PermissionVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/22
 * @description:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    /**
     * 获取当前用户菜单树
     * @return
     */
    @RequestMapping(value = "/getMenuTree", method = RequestMethod.POST)
    @ResponseBody
    public BasicData getMenuTree(HttpServletRequest request) {
        try {
            List<PermissionVO> list = permissionService.getMenuTree();
            return BasicData.CreateSucess(list);
        } catch (Exception e) {
            return BasicData.CreateError();
        }
    }

    /**
     * 获取权限树
     * @return
     */
    @RequestMapping(value = "/getPermissionTree", method = RequestMethod.GET)
    @ResponseBody
    public BasicData getPermissionTree(HttpServletRequest request) {
        try {
            List<PermissionVO> list = permissionService.getPermissionTree();
            return BasicData.CreateSucess(list);
        } catch (Exception e) {
            return BasicData.CreateError();
        }
    }
}
