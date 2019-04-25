package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.TradeCategoryMapper;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.domen.TradeCategoryTranslate;
import com.mall.pc.service.GoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-12 11:08
 **/
@Service
public class GoodCategoryServiceimpl implements GoodCategoryService {

    @Autowired
    private TradeCategoryMapper categoryMapper;

    @Override
    public BasicData QueryGoodCategorys(Integer fatherid) {
        List<TradeCategory> list =categoryMapper.QueryGoodCategorys(fatherid);
        return BasicData.CreateSucess(list);
    }

    @Override
    public BasicData QueryGoodCategorys(Integer fatherid,String languagetype) {
        List<TradeCategory> tradeCategories = new ArrayList<>();
        List<TradeCategory> list =categoryMapper.QueryGoodCategorys(fatherid);
        for(TradeCategory tradeCategory:list){
            TradeCategoryTranslate tradeCategoryTranslate = categoryMapper.QueryCategorytranslateByclassidAndLanguagetype(tradeCategory.getId(),languagetype);
            if(tradeCategoryTranslate!=null&&!tradeCategoryTranslate.getClassifyname().isEmpty()){
                tradeCategory.setClassify(tradeCategoryTranslate.getClassifyname());
            }
            tradeCategories.add(tradeCategory);
        }

        return BasicData.CreateSucess(tradeCategories);
    }

    @Override
    public BasicData QueryGoodCategoryById(Integer id) {

        TradeCategory goodCategory = categoryMapper.QueryGoodCategoryById(id);

        return BasicData.CreateSucess(goodCategory);
    }

    @Override
    public BasicData insertcategory(TradeCategory goodCategory) {

        categoryMapper.insertcategory(goodCategory);

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updatecategory(TradeCategory goodCategory) {

        categoryMapper.updatecategory(goodCategory);

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delcategory(Integer id) {

        categoryMapper.delcategory(id);

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData Categorytranslates(Integer classid) {
        List<TradeCategoryTranslate> tradeCategoryTranslates = categoryMapper.Categorytranslates(classid);
        return BasicData.CreateSucess(tradeCategoryTranslates);
    }

    @Override
    public BasicData QueryCategorytranslateByclassidAndLanguagetype(Integer classid, String languagetype) {
        TradeCategoryTranslate tradeCategoryTranslate = categoryMapper.QueryCategorytranslateByclassidAndLanguagetype(classid,languagetype);

        return BasicData.CreateSucess(tradeCategoryTranslate);
    }

    @Override
    public BasicData insertCategoryTradeSlate(TradeCategoryTranslate tradeCategoryTranslate) {
        TradeCategoryTranslate CategoryTranslate = categoryMapper.QueryCategorytranslateByclassidAndLanguagetype(tradeCategoryTranslate.getClassid(),tradeCategoryTranslate.getLanguagetype());
        if(CategoryTranslate!=null){
            return BasicData.CreateErrorMsg("该翻译语言以存在");
        }
        categoryMapper.insertCategoryTradeSlate(tradeCategoryTranslate);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateCategoryTradeSlate(TradeCategoryTranslate tradeCategoryTranslate) {
        categoryMapper.updateCategoryTradeSlate(tradeCategoryTranslate);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delCategoryTradeSlate(Integer classid, String languagetype) {
        categoryMapper.delCategoryTradeSlate(classid,languagetype);
        return BasicData.CreateSucess();
    }
}

