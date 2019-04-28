package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.Discount;
import com.mall.pc.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 09:42
 **/
@Controller
@RequestMapping(value = "/discode")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    /**
     * 获取折扣码列表
     * @param request
     * @return
     */
    @RequestMapping(value="/queryDiscountlist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryDiscountlist(
            @RequestParam(required = false) String disname,
            @RequestParam(required = false) String discode,
            @RequestParam(required = false) String disway,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            Discount discount = new Discount();
            discount.setDisname(disname);
            discount.setDiscode(discode);
            discount.setDisway(disway);
            PageHelper.startPage(pagenum,pagesize);
            return discountService.queryDiscountlist(discount);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *折扣码详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/queryDiscountById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryDiscountById(@RequestParam(required = true) Integer  id, HttpServletRequest request){
        try{
            return discountService.queryDiscountById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增折扣码信息
     * @param discount
     * @param request
     * @return
     */
    @RequestMapping(value="/insertDiscount",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertDiscount(@RequestBody(required = false) Discount discount, HttpServletRequest request){
        try{
            return discountService.insertDiscount(discount);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改折扣码
     * @param discount
     * @param request
     * @return
     */
    @RequestMapping(value="/updateDiscount",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateDiscount(@RequestBody(required = false) Discount discount, HttpServletRequest request){
        try{
            return discountService.updateDiscount(discount);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除折扣码
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delDiscount",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delDiscount(@RequestParam(required = true) Integer id, HttpServletRequest request){
        try{
            return discountService.delDiscount(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }





}

