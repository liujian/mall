package com.mall.pc.dao;

import com.mall.pc.domen.TaxRate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaxRateMapper {

    List<TaxRate> queryTaxRatelist(TaxRate taxRate);

    TaxRate queryTaxRateByCode(String zipcode);

    TaxRate queryTaxRateById(Integer id);

    void insertTaxRate(TaxRate taxRate);

    void updateTaxRate(TaxRate taxRate);

    void delTaxRate(Integer id);



}
