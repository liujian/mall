package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.in.OrderIn;
import com.mall.mobile.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-23 15:17
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 购物车首次结账
     * @param token token
     * @param tradeclass 分类id
     * @param discode 抵扣码
     * @param integral 兑换积分
     * @param zipcode 邮编
     * @param request
     * @return
     */
    @RequestMapping(value="/cartorder",method = RequestMethod.GET)
    @ResponseBody
    public BasicData cartorder(
            @RequestParam(required = true) String token,
            @RequestParam(required = true) Integer tradeclass,
            @RequestParam(required = false) String discode,
            @RequestParam(required = false) Integer integral,
            @RequestParam(required = false) String zipcode,
            HttpServletRequest request){

        try{
            return orderService.cartorder(token,tradeclass,discode,integral,zipcode);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    @RequestMapping(value="/payorder",method = RequestMethod.GET)
    @ResponseBody
    public BasicData payorder(
            @RequestBody(required = true) OrderIn orderIn,
            HttpServletRequest request){

        try{
            return orderService.payorder(orderIn);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

}

