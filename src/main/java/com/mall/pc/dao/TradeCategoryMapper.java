package com.mall.pc.dao;

import com.mall.pc.domen.TradeCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeCategoryMapper {

    List<TradeCategory> QueryGoodCategorys(@Param("fatherid")Integer fatherid);

    TradeCategory QueryGoodCategoryById(Integer id);

    void insertcategory(TradeCategory goodCategory);

    void updatecategory(TradeCategory goodCategory);

    void delcategory(Integer id);



}
