package com.mall.mobile.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.service.GoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 10:19
 **/
@Controller
@RequestMapping(value = "/mobile/cate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

    @Autowired
    private GoodCategoryService goodCategoryService;

    /**
     * 获取分类
     * @param request
     * @return
     */
    @RequestMapping(value="/QueryAllCategorys",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QueryAllCategorys(
            @RequestParam(required = false) String languagetype,
            HttpServletRequest request){
        try{
            return goodCategoryService.QueryAllCategorys(languagetype);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 获取分类列表
     * @param request
     * @return
     */
    @RequestMapping(value="/QueryGoodCategorys",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QueryGoodCategorys(
            @RequestParam(required = false) Integer fatherid,
            @RequestParam(required = false) String languagetype,
            HttpServletRequest request){
        try{
            return goodCategoryService.QueryGoodCategorys(fatherid,languagetype);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }
}

