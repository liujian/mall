package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.Banner;
import com.mall.pc.domen.Brand;
import com.mall.pc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 13:52
 **/
@Controller
@RequestMapping(value = "/brand")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 获取品牌列表
     * @param request
     * @return
     */
    @RequestMapping(value="/queryBrandlist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryBrandlist(
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            return brandService.queryBrandlist();
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *品牌详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/queryBrandrById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryBrandrById(@RequestParam(required = true) Integer  id, HttpServletRequest request){
        try{
            return brandService.queryBrandrById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增品牌
     * @param brand
     * @param request
     * @return
     */
    @RequestMapping(value="/insertBrand",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertBanner(@RequestBody(required = false) Brand brand, HttpServletRequest request){
        try{
            return brandService.insertBrand(brand);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改品牌
     * @param brand
     * @param request
     * @return
     */
    @RequestMapping(value="/updateBrand",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateBrand(@RequestBody(required = false) Brand brand, HttpServletRequest request){
        try{
            return brandService.updateBrand(brand);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除品牌
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delBrand",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delBrand(@RequestParam(required = true) Integer id, HttpServletRequest request){
        try{
            return brandService.delBrand(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


}

