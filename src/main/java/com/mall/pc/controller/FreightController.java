package com.mall.pc.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.Freight;
import com.mall.pc.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 10:30
 **/
@Controller
@RequestMapping(value = "/freight")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FreightController {

    @Autowired
    private FreightService freightService;


    /**
     *运费管理详情
     * @param request
     * @return
     */
    @RequestMapping(value="/queryFreight",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryFreight(HttpServletRequest request){
        try{
            return freightService.queryFreight();
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 修改运费
     * @param freight
     * @param request
     * @return
     */
    @RequestMapping(value="/updateFreight",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateFreight(@RequestBody(required = false) Freight freight, HttpServletRequest request){
        try{
            return freightService.updateFreight(freight);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }



}

