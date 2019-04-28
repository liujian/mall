package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.TaxRateMapper;
import com.mall.pc.domen.TaxRate;
import com.mall.pc.service.TaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-26 15:25
 **/
@Service
public class TaxRateServiceImpl implements TaxRateService {

    @Autowired
    private TaxRateMapper taxRateMapper;

    @Override
    public BasicData queryTaxRatelist(TaxRate taxRate) {

        List<TaxRate> taxRates = taxRateMapper.queryTaxRatelist(taxRate);

        return BasicData.CreateSucess(taxRates);
    }

    @Override
    public BasicData queryTaxRateByCode(Integer id) {
        TaxRate taxRate = taxRateMapper.queryTaxRateById(id);
        return BasicData.CreateSucess(taxRate);
    }

    @Override
    public BasicData insertTaxRate(TaxRate taxRate) {
        TaxRate taxRate1 = taxRateMapper.queryTaxRateByCode(taxRate.getZipcode());
        if(taxRate1!=null){
            return BasicData.CreateErrorMsg("该邮编信息以存在!");
        }
         taxRateMapper.insertTaxRate(taxRate);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateTaxRate(TaxRate taxRate) {
        taxRateMapper.updateTaxRate(taxRate);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delTaxRate(Integer id) {
        taxRateMapper.delTaxRate(id);
        return BasicData.CreateSucess();
    }
}

