package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeCategory;

public interface GoodCategoryService {


    BasicData QueryGoodCategorys(Integer fatherid);

    BasicData QueryGoodCategoryById(Integer id);

    BasicData insertcategory(TradeCategory goodCategory);

    BasicData updatecategory(TradeCategory goodCategory);

    BasicData delcategory(Integer id);


}
