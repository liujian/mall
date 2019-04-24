package com.mall.pc.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;
import com.mall.pc.service.TradeParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 10:47
 **/
@Controller
@RequestMapping(value = "/trade")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TradeParamController {


    @Autowired
    private TradeParamService tradeParamService;


//    /**
//     * 获取商品参数列表
//     * @param request
//     * @return
//     */
//    @RequestMapping(value="/querytradeparam",method = RequestMethod.GET)
//    @ResponseBody
//    public BasicData querytradeparam(
//            @RequestParam(required = true) Integer tradeid,
//            HttpServletRequest request){
//        try{
//
//            return tradeParamService.querytradeparam(tradeid);
//        }catch (Exception e){
//            e.printStackTrace();
//            return BasicData.CreateErrorMsg(e.getMessage());
//        }
//
//    }

//    /**
//     * 新增商品参数
//     * @param tradeParam
//     * @param request
//     * @return
//     */
//    @RequestMapping(value="/insertradeparam",method = RequestMethod.POST)
//    @ResponseBody
//    public BasicData insertradeparam(@RequestBody(required = false) TradeParam tradeParam, HttpServletRequest request){
//        try{
//            return tradeParamService.insertradeparam(tradeParam);
//        }catch (Exception e){
//            e.printStackTrace();
//            return BasicData.CreateErrorMsg(e.getMessage());
//        }
//
//    }
//
//    /**
//     * 修改商品参数
//     * @param tradeParam
//     * @param request
//     * @return
//     */
//    @RequestMapping(value="/updatetradeparam",method = RequestMethod.POST)
//    @ResponseBody
//    public BasicData updatetradeparam(@RequestBody(required = false)  TradeParam tradeParam, HttpServletRequest request){
//        try{
//            return tradeParamService.updatetradeparam(tradeParam);
//        }catch (Exception e){
//            e.printStackTrace();
//            return BasicData.CreateErrorMsg(e.getMessage());
//        }
//
//    }
//
//
//    /**
//     * 删除商品参数
//     * @param id
//     * @param request
//     * @return
//     */
//    @RequestMapping(value="/deltradeparam",method = RequestMethod.GET)
//    @ResponseBody
//    public BasicData deltradeparam(@RequestParam(required = true) Integer id, HttpServletRequest request){
//        try{
//            return tradeParamService.deltradeparam(id);
//        }catch (Exception e){
//            e.printStackTrace();
//            return BasicData.CreateErrorMsg(e.getMessage());
//        }
//
//    }
}

