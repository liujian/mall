package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.domen.Cart;
import com.mall.mobile.domen.CustAdress;
import com.mall.mobile.in.CartIn;
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
            @RequestParam(required = false) String token,
            HttpServletRequest request){
        try{
            return cartService.getCartList(token);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 加入我的购物车
     * @param request
     * @return
     */
    @RequestMapping(value="/addMyCart",method = RequestMethod.POST)
    @ResponseBody
    public BasicData addMyCart(
            @RequestBody(required = false) CartIn cartIn,
            HttpServletRequest request){
        try{
            return cartService.addCart(cartIn);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *删除购物车商品
     * @param request
     * @return
     */
    @RequestMapping(value="/delMyCart",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delMyCart(
            @RequestParam(required = false)Integer id,
            @RequestParam(required = false)String token,
            HttpServletRequest request){
        try{
            return cartService.delCart(token,id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *加减购物车商品
     * @param request
     * @return
     */
    @RequestMapping(value="/adddelCart",method = RequestMethod.GET)
    @ResponseBody
    public BasicData adddelCart(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String token,
            HttpServletRequest request){
        try{
            return cartService.adddelCart(token,id,type);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


}

