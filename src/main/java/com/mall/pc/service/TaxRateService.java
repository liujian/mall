package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TaxRate;

import java.util.List;

public interface TaxRateService {

    BasicData queryTaxRatelist(TaxRate taxRate);

    BasicData queryTaxRateByCode(Integer id);

    BasicData insertTaxRate(TaxRate taxRate);

    BasicData updateTaxRate(TaxRate taxRate);

    BasicData delTaxRate(Integer id);
}
