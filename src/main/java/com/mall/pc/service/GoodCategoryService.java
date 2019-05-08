package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.domen.TradeCategoryTranslate;
import org.apache.ibatis.annotations.Param;

public interface GoodCategoryService {

    BasicData QueryAllCategorys(String languagetype);

    BasicData QueryGoodCategorys(Integer fatherid);

    BasicData QueryGoodCategorys(Integer fatherid,String languagetype);

    BasicData QueryGoodCategoryById(Integer id);

    BasicData insertcategory(TradeCategory goodCategory);

    BasicData updatecategory(TradeCategory goodCategory);

    BasicData delcategory(Integer id);

    //分类翻译模块

    BasicData Categorytranslates(Integer classid);

    BasicData QueryCategorytranslateByclassidAndLanguagetype(Integer classid,String languagetype);

    BasicData insertCategoryTradeSlate(TradeCategoryTranslate tradeCategoryTranslate);

    BasicData updateCategoryTradeSlate(TradeCategoryTranslate tradeCategoryTranslate);

    BasicData delCategoryTradeSlate(Integer classid,String languagetype);
}
