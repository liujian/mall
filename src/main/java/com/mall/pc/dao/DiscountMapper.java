package com.mall.pc.dao;

import com.mall.pc.domen.Discount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscountMapper {

    List<Discount> queryDiscountlist(Discount discount);

    Discount queryDiscountById(Integer id);

    Discount queryDiscountByCode(String discode);

    void insertDiscount(Discount discount);

    void updateDiscount(Discount discount);

    void delDiscount(Integer id);



}
