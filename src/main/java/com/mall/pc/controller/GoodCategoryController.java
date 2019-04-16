package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.service.GoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-12 11:07
 **/
@Controller
@RequestMapping(value = "/cate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GoodCategoryController {

    @Autowired
    private GoodCategoryService goodCategoryService;


    /**
     * 获取分类列表
     * @param request
     * @return
     */
    @RequestMapping(value="/QueryGoodCategorys",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QueryGoodCategorys(
                                    @RequestParam(required = false) Integer fatherid,
                                    @RequestParam(required = true) Integer pagenum,
                                    @RequestParam(required = true) Integer pagesize,
                                    HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            return goodCategoryService.QueryGoodCategorys(fatherid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *分类详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/QueryGoodCategoryById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QueryGoodCategoryById(@RequestParam(required = true) Integer  id, HttpServletRequest request){
        try{
            return goodCategoryService.QueryGoodCategoryById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增分类
     * @param goodCategory
     * @param request
     * @return
     */
    @RequestMapping(value="/insertcategory",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertcategory(@RequestBody(required = false) TradeCategory goodCategory, HttpServletRequest request){
        try{
            return goodCategoryService.insertcategory(goodCategory);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改分类
     * @param goodCategory
     * @param request
     * @return
     */
    @RequestMapping(value="/updatecategory",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updatecategory(@RequestBody(required = false) TradeCategory goodCategory, HttpServletRequest request){
        try{
            return goodCategoryService.updatecategory(goodCategory);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除分类
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delcategory",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delcategory(@RequestParam(required = true) Integer id, HttpServletRequest request){
        try{
            return goodCategoryService.delcategory(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }



}

