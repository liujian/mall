package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.TaxRate;
import com.mall.pc.service.TaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-26 15:33
 **/
@Controller
@RequestMapping(value = "/taxrate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaxRateController {

    @Autowired
    private TaxRateService taxRateService;

    /**
     * 获取税率配置列表
     * @param country 城市
     * @param area 区域
     * @param zipcode 邮编
     * @param pagenum 页码
     * @param pagesize 页数
     * @param request
     * @return
     */
    @RequestMapping(value="/queryTaxRatelist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryTaxRatelist(
                                      @RequestParam(required = false) String country,
                                      @RequestParam(required = false) String area,
                                      @RequestParam(required = false) String zipcode,
                                      @RequestParam(required = true) Integer pagenum,
                                      @RequestParam(required = true) Integer pagesize,
                                      HttpServletRequest request){
        try{
            TaxRate taxRate = new TaxRate();
            taxRate.setCountry(country);
            taxRate.setArea(area);
            taxRate.setZipcode(zipcode);
            PageHelper.startPage(pagenum,pagesize);
            return taxRateService.queryTaxRatelist(taxRate);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 查看邮编信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/queryTaxRateByCode",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryTaxRateByCode(
            @RequestParam(required = false) Integer id,
            HttpServletRequest request){
        try{
            return taxRateService.queryTaxRateByCode(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增邮编税率信息
     * @param taxRate
     * @param request
     * @return
     */
    @RequestMapping(value="/insertTaxRate",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertTaxRate(
            @RequestBody(required = false) TaxRate taxRate,
            HttpServletRequest request){
        try{
            return taxRateService.insertTaxRate(taxRate);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改邮编税率信息
     * @param taxRate
     * @param request
     * @return
     */
    @RequestMapping(value="/updateTaxRate",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateTaxRate(
            @RequestBody(required = false) TaxRate taxRate,
            HttpServletRequest request){
        try{
            return taxRateService.updateTaxRate(taxRate);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 删除邮编税率信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delTaxRate",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delTaxRate(
            @RequestParam(required = false) Integer id,
            HttpServletRequest request){
        try{
            return taxRateService.delTaxRate(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

}

