package com.mall.pc.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeCompose;
import com.mall.pc.in.TradeParamIn;
import com.mall.pc.service.TradeComposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-24 15:23
 **/
@Controller
@RequestMapping(value = "/compose")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TradeComposeController {

    @Autowired
    private TradeComposeService tradeComposeService;


    /**
     * 新增组合商品
     * @param tradeCompose
     * @param request
     * @return
     */
    @RequestMapping(value="/insertTradeCompose",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertTradeCompose(@RequestBody(required = false) TradeCompose tradeCompose, HttpServletRequest request){
        try{
            return tradeComposeService.insertTradeCompose(tradeCompose);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    /**
     * 修改商品
     * @param tradeCompose
     * @param request
     * @return
     */
    @RequestMapping(value="/updateTradeCompose",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateTradeCompose(@RequestBody(required = false) TradeCompose tradeCompose, HttpServletRequest request){
        try{
            return tradeComposeService.updateTradeCompose(tradeCompose);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 删除商品
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delTradeCompose",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delTradeCompose(@RequestParam(required = true) Integer id, HttpServletRequest request){
        try{
            return tradeComposeService.delTradeCompose(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }






}

