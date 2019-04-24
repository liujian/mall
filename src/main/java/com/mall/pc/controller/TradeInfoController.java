package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.*;
import com.mall.pc.in.TradeParamIn;
import com.mall.pc.service.TradeInfoService;
import com.mall.pc.service.TradeParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

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

    @Autowired
    private TradeParamService tradeParamService;


    //商品信息模块

    /**
     * 获取商品列表
     * @param request
     * @return
     */
    @RequestMapping(value="/Querytrades",method = RequestMethod.GET)
    @ResponseBody
    public BasicData Querytrades(
            @RequestParam(required = false) String barcode,
            @RequestParam(required = false) String tradename,
            @RequestParam(required = false) Integer tradeclass,
            @RequestParam(required = false) Integer classify,
            @RequestParam(required = false) Integer brandid,
            @RequestParam(required = false) String invalid,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            TradeInfo tradeInfo = new TradeInfo();
            tradeInfo.setBarcode(barcode);
            tradeInfo.setTradename(tradename);
            tradeInfo.setTradeclass(tradeclass);
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
    public BasicData QuerytradeById(@RequestParam(required = true) Integer id, HttpServletRequest request){
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
     * 删除商品
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


    //优惠方案模块

    /**
     * 修改商品优惠方式
     * @param coupway
     * @param tradeid
     * @param request
     * @return
     */
    @RequestMapping(value="/updatecoupway",method = RequestMethod.GET)
    @ResponseBody
    public BasicData updatecoupway(@RequestParam(required = false) String coupway,
                                   @RequestParam(required = false) Integer fullpiece,
                                   @RequestParam(required = false) BigDecimal fullprice,
                                  @RequestParam(required = false) Integer tradeid,
                                  HttpServletRequest request){
        try{
            return tradeInfoService.updatecoupway(coupway,fullpiece,fullprice,tradeid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    /**
     * 查询赠送商品列表
     * @param coupway
     * @param tradeid
     * @param request
     * @return
     */
    @RequestMapping(value="/QueryTradeGiveList",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QueryTradeGiveList(@RequestParam(required = false) String coupway,
                                        @RequestParam(required = false) Integer tradeid,
                                     HttpServletRequest request){
        try{
            return tradeInfoService.QueryTradeGiveList(coupway,tradeid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }



    /**
     * 新增赠送商品
     * @param tradeGive
     * @param request
     * @return
     */
    @RequestMapping(value="/insertTradeGive",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertTradeGive(@RequestBody(required = false) TradeGive tradeGive,
                                    HttpServletRequest request){
        try{
            return tradeInfoService.insertTradeGive(tradeGive);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    /**
     * 删除赠送商品
     * @param id 赠品id
     * @param request
     * @return
     */
    @RequestMapping(value="/delTradeGive",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delTradeGive( @RequestParam(required = false) Integer id,
                                     HttpServletRequest request){
        try{
            return tradeInfoService.delTradeGive(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    //限时特价模块

    /**
     * 限时特价
     * @param tradeid
     * @param promoteprice
     * @param promotedate
     * @param request
     * @return
     */
    @RequestMapping(value="/promote",method = RequestMethod.GET)
    @ResponseBody
    public BasicData promote(@RequestParam(required = false) Integer tradeid,
                             @RequestParam(required = false) BigDecimal promoteprice,
                             @RequestParam(required = false) Date promotedate,
                             HttpServletRequest request){
        try{


            return tradeInfoService.promote(tradeid,promoteprice,promotedate);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    //商品属性模块

    /**
     * 商品属性名称列表
     * @param request
     * @return
     */
    @RequestMapping(value="/querytradeparmnameList",method = RequestMethod.GET)
    @ResponseBody
    public BasicData querytradeparmnameList(@RequestParam(required = false) Integer tradeid,
                                      HttpServletRequest request){
        try{
            return tradeParamService.querytradeparmnameList(tradeid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    /**
     * 新增商品属性名称
     * @param request
     * @return
     */
    @RequestMapping(value="/addtradeparmname",method = RequestMethod.POST)
    @ResponseBody
    public BasicData addtradeparmname(@RequestBody(required = false) TradeParamName tradeParamName,
                             HttpServletRequest request){
        try{
            return tradeParamService.addtradeparmname(tradeParamName);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    /**
     * 修改商品属性名称
     * @param request
     * @return
     */
    @RequestMapping(value="/updatetradeparmname",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updatetradeparmname(@RequestBody(required = false) TradeParamName tradeParamName,
                                      HttpServletRequest request){
        try{
            return tradeParamService.updatetradeparmname(tradeParamName);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 删除商品属性名称
     * @param id 商品属性名称id
     * @param request
     * @return
     */
    @RequestMapping(value="/deltradeparmname",method = RequestMethod.GET)
    @ResponseBody
    public BasicData deltradeparmname(@RequestParam(required = false) Integer id,
                                         HttpServletRequest request){
        try{
            return tradeParamService.deltradeparmname(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 新增商品参数
     * @param tradeParam
     * @param request
     * @return
     */
    @RequestMapping(value="/insertradeparam",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertradeparam(@RequestBody(required = false) TradeParam tradeParam, HttpServletRequest request){
        try{
            return tradeParamService.insertradeparam(tradeParam);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改商品参数
     * @param tradeParam
     * @param request
     * @return
     */
    @RequestMapping(value="/updatetradeparam",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updatetradeparam(@RequestBody(required = false)  TradeParam tradeParam, HttpServletRequest request){
        try{
            return tradeParamService.updatetradeparam(tradeParam);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除商品参数
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/deltradeparam",method = RequestMethod.GET)
    @ResponseBody
    public BasicData deltradeparam(@RequestParam(required = true) Integer id, HttpServletRequest request){
        try{
            return tradeParamService.deltradeparam(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    //相册模块
    /**
     * 获取商品相册列表
     * @param request
     * @return
     */
    @RequestMapping(value="/Querytransphotos",method = RequestMethod.GET)
    @ResponseBody
    public BasicData Querytransphotos(
            @RequestParam(required = true) Integer tradeid,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            return tradeInfoService.Querytransphotos(tradeid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 查看商品相册详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/QuerytranphotoById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QuerytranphotoById(@RequestParam(required = true) Integer id,
                                        HttpServletRequest request){
        try{
            return tradeInfoService.QuerytranphotoById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增商品相册信息
     * @param tradePhoto
     * @param request
     * @return
     */
    @RequestMapping(value="/insertTradePhoto",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertTradePhoto(@RequestBody(required = false) TradePhoto tradePhoto, HttpServletRequest request){
        try{
            return tradeInfoService.insertTradePhoto(tradePhoto);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改商品相册信息
     * @param tradePhoto
     * @param request
     * @return
     */
    @RequestMapping(value="/updateTradePhoto",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateTradePhoto(@RequestBody(required = false) TradePhoto tradePhoto, HttpServletRequest request){
        try{
            return tradeInfoService.updateTradePhoto(tradePhoto);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除相册信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delTradePhoto",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delTradePhoto(@RequestParam(required = true) Integer id,
                                   HttpServletRequest request){
        try{
            return tradeInfoService.delTradePhoto(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    //商品翻译模块

    /**
     * 获取商品翻译列表
     * @param request
     * @return
     */
    @RequestMapping(value="/Querytranslates",method = RequestMethod.GET)
    @ResponseBody
    public BasicData Querytranslates(
            @RequestParam(required = true) Integer tradeid,
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            return tradeInfoService.Querytranslates(tradeid);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 查看商品翻译详情
     * @param tradeid
     * @param languagetype
     * @param request
     * @return
     */
    @RequestMapping(value="/QuerytranslateById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData QuerytranslateById(@RequestParam(required = true) Integer tradeid,
                                        @RequestParam(required = true) String  languagetype,
                                        HttpServletRequest request){
        try{
            return tradeInfoService.QuerytranslateById(tradeid,languagetype);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增商品翻译
     * @param tradeInfoTranslate
     * @param request
     * @return
     */
    @RequestMapping(value="/insertTradeSlate",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertTradeSlate(@RequestBody(required = false) TradeInfoTranslate tradeInfoTranslate, HttpServletRequest request){
        try{
            return tradeInfoService.insertTradeSlate(tradeInfoTranslate);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改商品翻译内容
     * @param tradeInfoTranslate
     * @param request
     * @return
     */
    @RequestMapping(value="/updateTradeSlate",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateTradeSlate(@RequestBody(required = false) TradeInfoTranslate tradeInfoTranslate, HttpServletRequest request){
        try{
            return tradeInfoService.updateTradeSlate(tradeInfoTranslate);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除商品翻译
     * @param tradeid
     * @param languagetype
     * @param request
     * @return
     */
    @RequestMapping(value="/delTradeSlate",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delTradeSlate(@RequestParam(required = true) Integer tradeid,
                                   @RequestParam(required = true) String  languagetype,
                                   HttpServletRequest request){
        try{
            return tradeInfoService.delTradeSlate(tradeid,languagetype);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


}

