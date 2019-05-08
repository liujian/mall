package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.Advertise;
import com.mall.pc.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-08 13:49
 **/
@Controller
@RequestMapping(value = "/adver")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdvertiseController {

    @Autowired
    private AdvertiseService advertiseService;


    /**
     * 获取广告列表
     * @param request
     * @return
     */
    @RequestMapping(value="/queryadverlist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryadverlist(
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            return advertiseService.queryAdvertise();
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *广告详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/queryAdvertiseById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryAdvertiseById(@RequestParam(required = true) Integer  id, HttpServletRequest request){
        try{
            return advertiseService.queryAdvertiseById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 修改广告图
     * @param advertise
     * @param request
     * @return
     */
    @RequestMapping(value="/updateAdvertise",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateAdvertise(@RequestBody(required = false) Advertise advertise, HttpServletRequest request){
        try{
            return advertiseService.updateAdvertise(advertise);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }
}

