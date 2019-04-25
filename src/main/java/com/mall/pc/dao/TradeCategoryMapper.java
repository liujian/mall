package com.mall.pc.dao;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.domen.TradeCategoryTranslate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeCategoryMapper {

    List<TradeCategory> QueryGoodCategorys(@Param("fatherid")Integer fatherid);

    List<TradeCategory> QueryGoodCategorysByishomeicon();

    List<TradeCategory> QueryGoodCategorysByishome();

    TradeCategory QueryGoodCategoryById(Integer id);

    void insertcategory(TradeCategory goodCategory);

    void updatecategory(TradeCategory goodCategory);

    void delcategory(Integer id);


    //翻译模块


    List<TradeCategoryTranslate> Categorytranslates(Integer classid);

    TradeCategoryTranslate QueryCategorytranslateByclassidAndLanguagetype(@Param("classid")Integer classid, @Param("languagetype")String  languagetype);

    void insertCategoryTradeSlate(TradeCategoryTranslate tradeCategoryTranslate);

    void updateCategoryTradeSlate(TradeCategoryTranslate tradeCategoryTranslate);

    void delCategoryTradeSlate(@Param("classid")Integer classid,@Param("languagetype")String languagetype);



}
