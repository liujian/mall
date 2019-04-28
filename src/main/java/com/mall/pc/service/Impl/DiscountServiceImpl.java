package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.DiscountMapper;
import com.mall.pc.domen.Discount;
import com.mall.pc.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 09:36
 **/
@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountMapper discountMapper;

    @Override
    public BasicData queryDiscountlist(Discount discount) {
        List<Discount> discountList = discountMapper.queryDiscountlist(discount);
        return BasicData.CreateSucess(discountList);
    }

    @Override
    public BasicData queryDiscountById(Integer id) {
        Discount discount = discountMapper.queryDiscountById(id);
        return BasicData.CreateSucess(discount);
    }

    @Override
    public BasicData insertDiscount(Discount discount) {

        Discount discount1=discountMapper.queryDiscountByCode(discount.getDiscode());
        if(discount1!=null){
            return BasicData.CreateErrorMsg("该折扣码以存在!");
        }
        discount.setInvalid("0");
        discountMapper.insertDiscount(discount);

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateDiscount(Discount discount) {
        discountMapper.updateDiscount(discount);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delDiscount(Integer id) {
        discountMapper.delDiscount(id);
        return BasicData.CreateSucess();
    }
}

