package com.mall.pc.service;

import com.mall.common.param.Basic;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.*;
import com.mall.pc.in.TradeParamIn;

import java.math.BigDecimal;
import java.util.Date;

public interface TradeInfoService {


    BasicData Querytrades(TradeInfo tradeInfo);

    BasicData QuerytradeById(Integer id);

    BasicData QuerytradeById(Integer id,String languagetype);

    BasicData insertTradeInfo(TradeInfo tradeInfo);

    BasicData updateTradeInfo(TradeInfo tradeInfo);

    BasicData delTradeInfo(Integer id);

    BasicData queryAlltradelist(Integer classify,String search,String languagetype);

    BasicData querytradelistByClassify(Integer classify,String search,String languagetype);

    BasicData QuerytradeBysearchname(String searchname,String languagetype);

    BasicData QuerytradeBybarcode(String barcode,String languagetype);



    //优惠模块

    /**
     * 修改商品优惠方式
     * @param coupway
     * @param tradeid
     * @return
     */
    BasicData updatecoupway(String coupway, Integer fullpiece, BigDecimal fullprice, Integer tradeid);

    /**
     * 查询赠送商品列表
     * @param coupway
     * @param tradeid
     * @return
     */
    BasicData QueryTradeGiveList(String coupway,Integer tradeid);

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

    //相册模块

    /**
     * 获取商品相册列表
     * @param tradeid
     * @return
     */
    BasicData Querytransphotos(Integer tradeid);

    /**
     * 查看商品相册详情
     * @param id
     * @return
     */
    BasicData QuerytranphotoById(Integer id);

    /**
     * 新增商品相册信息
     * @param tradePhoto
     * @return
     */
    BasicData insertTradePhoto(TradePhoto tradePhoto);

    /**
     * 修改商品相册信息
     * @param tradePhoto
     * @return
     */
    BasicData updateTradePhoto(TradePhoto tradePhoto);

    /**
     * 删除相册信息
     * @param id
     * @return
     */
    BasicData delTradePhoto(Integer id);

    //翻译模块

    /**
     * 查询商品翻译列表
     * @param tradeid
     * @return
     */
    BasicData Querytranslates( Integer tradeid );

    /**
     * 查看商品翻译详情
     * @param tradeid
     * @param languagetype
     * @return
     */
    BasicData QuerytranslateById(Integer tradeid,String languagetype);

    /**
     * 新增商品翻译
     * @param tradeInfoTranslate
     * @return
     */
    BasicData insertTradeSlate(TradeInfoTranslate tradeInfoTranslate);

    /**
     * 修改商品翻译
     * @param tradeInfoTranslate
     * @return
     */
    BasicData updateTradeSlate(TradeInfoTranslate tradeInfoTranslate);

    /**
     * 删除商品翻译
     * @param tradeid
     * @param languagetype
     * @return
     */
    BasicData delTradeSlate(Integer tradeid,String languagetype);


}
