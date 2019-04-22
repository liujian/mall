package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.service.HomeinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 16:15
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HomeController {

    @Autowired
    private HomeinfoService homeinfoService;

    @RequestMapping(value="/gethomeinfo",method = RequestMethod.GET)
    @ResponseBody
    public BasicData gethomeinfo(HttpServletRequest request){

        try{
            return homeinfoService.gethomeinfo();
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 根据品牌查找商品
     */
    @RequestMapping(value="/gettradeByBrand",method = RequestMethod.GET)
    @ResponseBody
    public BasicData gettradeByBrand(
                    @RequestParam(required = false) Integer brandid,
                                    HttpServletRequest request){

        try{
            return homeinfoService.gettradeByBrand(brandid);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


}

