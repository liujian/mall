package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.service.TradeInfoService;
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
public class TradeInfoController {


    @Autowired
    private TradeInfoService tradeInfoService;


    /**
     * 获取商品列表
     * @param request
     * @return
     */
    @RequestMapping(value="/Querytrades",method = RequestMethod.GET)
    @ResponseBody
    public BasicData Querytrades(
            @RequestParam(required = false) String barcode,
            @RequestParam(required = false) String tradename_zw,
            @RequestParam(required = false) String classify,
            @RequestParam(required = false) Integer brandid,
            @RequestParam(required = false) String invalid,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            TradeInfo tradeInfo = new TradeInfo();
            tradeInfo.setBarcode(barcode);
            tradeInfo.setTradename_zw(tradename_zw);
            tradeInfo.setClassify(classify);
            tradeInfo.setBrandid(brandid);
            tradeInfo.setInvalid(invalid);
            return tradeInfoService.Querytrades(tradeInfo);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 商品详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/QuerytradeById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QuerytradeById(@RequestParam(required = true) Integer  id, HttpServletRequest request){
        try{
            return tradeInfoService.QuerytradeById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增商品
     * @param tradeInfo
     * @param request
     * @return
     */
    @RequestMapping(value="/insertTradeInfo",method = RequestMethod.POST)
    @ResponseBody
    public BasicData TradeInfo(@RequestBody(required = false) TradeInfo tradeInfo, HttpServletRequest request){
        try{
            return tradeInfoService.insertTradeInfo(tradeInfo);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改商品
     * @param tradeInfo
     * @param request
     * @return
     */
    @RequestMapping(value="/updateTradeInfo",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateTradeInfo(@RequestBody(required = false) TradeInfo tradeInfo, HttpServletRequest request){
        try{
            return tradeInfoService.updateTradeInfo(tradeInfo);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除分类
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delTradeInfo",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delTradeInfo(@RequestParam(required = true) Integer id, HttpServletRequest request){
        try{
            return tradeInfoService.delTradeInfo(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }
}

