package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 16:34
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {

    @Autowired
    private CartService cartService;


    /**
     * 获取我的购物车列表
     * @param request
     * @return
     */
    @RequestMapping(value="/getCartList",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getCartList(
            @RequestParam(required = false) Integer userid,
            HttpServletRequest request){
        try{
            return cartService.getCartList(userid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


}

