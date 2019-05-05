package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.mobile.domen.OrderInfo;
import com.mall.pc.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-05 13:52
 **/
@Controller
@RequestMapping(value = "/orderinfo")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 获取订单列表
     * @param request
     * @return
     */
    @RequestMapping(value="/queryOrderInfolist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryOrderInfolist(
            @RequestParam(required = false) String orderid,
            @RequestParam(required = false) String orderstatus,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderid(orderid);
            orderInfo.setOrderstatus(orderstatus);
            return orderInfoService.queryOrderInfolist(orderInfo);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 获取日本直邮订单列表
     * @param request
     * @return
     */
    @RequestMapping(value="/queryRBZYOrderInfolist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryRBZYOrderInfolist(
            @RequestParam(required = false) String orderid,
            @RequestParam(required = false) String orderstatus,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderid(orderid);
            orderInfo.setOrderstatus(orderstatus);
            return orderInfoService.queryRBZYOrderInfolist(orderInfo);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 获取退货订单列表
     * @param request
     * @return
     */
    @RequestMapping(value="/queryTHOrderInfolist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryTHOrderInfolist(
            @RequestParam(required = false) String orderid,
            @RequestParam(required = false) String orderstatus,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderid(orderid);
            orderInfo.setOrderstatus(orderstatus);
            return orderInfoService.queryTHOrderInfolist(orderInfo);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 订单信息详情
     * @param request
     * @return
     */
    @RequestMapping(value="/queryOrderInfo",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryOrderInfo(
            @RequestParam(required = false) String orderid,
            HttpServletRequest request){
        try{
            return orderInfoService.queryOrderInfo(orderid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

}

