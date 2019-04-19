package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.service.GoodCategoryService;
import com.mall.pc.service.TradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 10:19
 **/
@Controller
@RequestMapping(value = "/mobile/trade")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TradeController {

    @Autowired
    private TradeInfoService tradeInfoService;

    /**
     *  查看某类型全部商品
     * @param request
     * @return
     */
    @RequestMapping(value="/queryAlltradelist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryAlltradelist(
            @RequestParam(required = false) Integer classify,
            @RequestParam(required = false) String search,
            HttpServletRequest request){
        try{
            return tradeInfoService.queryAlltradelist(classify,search);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *  查看某小类全部商品
     * @param request
     * @return
     */
    @RequestMapping(value="/querytradelistByClassify",method = RequestMethod.GET)
    @ResponseBody
    public BasicData querytradelistByClassify(
            @RequestParam(required = false) Integer classify,
            @RequestParam(required = false) String search,
            HttpServletRequest request){
        try{
            return tradeInfoService.querytradelistByClassify(classify,search);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }



    /**
     *  查看某商品详情
     * @param request
     * @return
     */
    @RequestMapping(value="/QuerytradeById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QuerytradeById(
            @RequestParam(required = false) Integer id,
            HttpServletRequest request){
        try{
            return tradeInfoService.QuerytradeById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *  搜索某商品
     * @param request
     * @return
     */
    @RequestMapping(value="/QuerytradeByname",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QuerytradeByname(
            @RequestParam(required = false) String searchname,
            HttpServletRequest request){
        try{
            return tradeInfoService.QuerytradeBysearchname(searchname);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *  商品条形码搜索商品
     * @param request
     * @return
     */
    @RequestMapping(value="/QuerytradeBybarcode",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QuerytradeBybarcode(
            @RequestParam(required = false) String barcode,
            HttpServletRequest request){
        try{
            return tradeInfoService.QuerytradeBybarcode(barcode);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *  商品条形码搜索商品
     * @param request
     * @return
     */
    @RequestMapping(value="/QuerytradeBybrand",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QuerytradeBybrand(
            @RequestParam(required = false) Integer brandid,
            HttpServletRequest request){
        try{
            return tradeInfoService.QuerytradeBybrand(brandid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


}

