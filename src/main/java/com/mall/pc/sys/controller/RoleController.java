package com.mall.pc.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.param.BasicData;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.dto.RoleDTO;
import com.mall.pc.sys.service.RoleService;
import com.mall.pc.sys.vo.RoleVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/22
 * @description:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * 根据条件查询角色列表
     * @param dto  查询条件
     * @return
     */
    @RequestMapping(value="/getRoleList",method = RequestMethod.POST)
    @ResponseBody
    public BasicData getRoleList(@RequestBody RoleDTO dto){
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        try {
            List<Role> roleList = roleService.getRoleList(dto.getRoleName(), dto.getState());
            PageInfo<Role> pageData = new PageInfo<>(roleList);
            return BasicData.CreateSucess(pageData);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 新增角色
     * @param vo
     * @return
     */
    @RequestMapping(value="/addRole",method = RequestMethod.POST)
    @ResponseBody
    public BasicData addRole(@RequestBody RoleVO vo){
        try {
            roleService.addRole(vo);
            return BasicData.CreateSucess();
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 修改角色
     * @param vo
     * @return
     */
    @RequestMapping(value="/updateRole",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateRole(@RequestBody RoleVO vo){
        try {
            roleService.updateRole(vo);
            return BasicData.CreateSucess();
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 删除角色
     * @param id  角色ID
     * @return
     */
    @RequestMapping(value="/deleteRole",method = RequestMethod.GET)
    @ResponseBody
    public BasicData deleteRole(@RequestParam Integer id){
        try {
            roleService.deleteRole(id);
            return BasicData.CreateSucess();
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 根据角色ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="/getRoleById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getRoleById(@RequestParam Integer id){
        try {
            RoleVO role = roleService.getRoleById(id);
            return BasicData.CreateSucess(role);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }

    /**
     * 查询角色编码是否已存在
     * @param id
     * @param roleCode
     * @return
     */
    @RequestMapping(value="/validRoleCode",method = RequestMethod.GET)
    @ResponseBody
    public BasicData validRoleCode(@RequestParam Integer id, @RequestParam String roleCode){
        try {
            Boolean flag = roleService.validRoleCode(id, roleCode);
            return BasicData.CreateSucess(flag);
        } catch (Exception e) {
            e.printStackTrace();
            return BasicData.CreateError();
        }
    }
}
