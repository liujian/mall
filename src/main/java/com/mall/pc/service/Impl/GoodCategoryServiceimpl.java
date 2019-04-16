package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.TradeCategoryMapper;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.service.GoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

