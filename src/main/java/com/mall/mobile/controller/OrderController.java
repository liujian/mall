package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

//    /**
//     * 结账
//     * @param request
//     * @return
//     */
//    @RequestMapping(value="/settlement",method = RequestMethod.GET)
//    @ResponseBody
//    public BasicData settlement(HttpServletRequest request){
//
//        try{
//            return orderService.settlement();
//        }catch(Exception e){
//            e.printStackTrace();
//            return BasicData.CreateErrorMsg(e.getMessage());
//        }
//    }

}

