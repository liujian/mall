package com.mall.pc.service;

import com.mall.common.param.Basic;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeGive;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParamName;
import com.mall.pc.in.TradeParamIn;

import java.math.BigDecimal;
import java.util.Date;

public interface TradeInfoService {


    BasicData Querytrades(TradeInfo tradeInfo);

    BasicData QuerytradeById(Integer id);

    BasicData insertTradeInfo(TradeParamIn tradeParamIn);

    BasicData updateTradeInfo(TradeParamIn tradeParamIn);

    BasicData delTradeInfo(Integer id);

    BasicData queryAlltradelist(Integer classify,String search);

    BasicData querytradelistByClassify(Integer classify,String search);

    BasicData QuerytradeBysearchname(String searchname);

    BasicData QuerytradeBybarcode(String barcode);



    //优惠模块

    /**
     * 修改商品优惠方式
     * @param coupway
     * @param tradeid
     * @return
     */
    BasicData updatecoupway(String coupway, Integer fullpiece, BigDecimal fullprice, Integer tradeid);

    /**
     * 新增赠送商品
     * @param tradeGive
     * @return
     */
    BasicData insertTradeGive(TradeGive tradeGive);

    /**
     * 删除赠品
     * @param id
     * @return
     */
    BasicData delTradeGive(Integer id);


    //促销模块

    /**
     * 促销方式
     * @param tradeid 商品id
     * @param promoteprice 促销价格
     * @param promotedate 促销时间
     * @return
     */
    BasicData promote(Integer tradeid,BigDecimal promoteprice,Date promotedate);

    //组合商品



}
