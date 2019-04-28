package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.Discount;

import java.util.List;

public interface DiscountService {

    BasicData queryDiscountlist(Discount discount);

    BasicData queryDiscountById(Integer id);

    BasicData insertDiscount(Discount discount);

    BasicData updateDiscount(Discount discount);

    BasicData delDiscount(Integer id);



}
