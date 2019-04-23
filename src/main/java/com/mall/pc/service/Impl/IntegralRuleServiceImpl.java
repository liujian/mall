package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.IntegralRuleMapper;
import com.mall.pc.domen.IntegralRule;
import com.mall.pc.service.IntegralRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-23 14:15
 **/
@Service
public class IntegralRuleServiceImpl implements IntegralRuleService {

    @Autowired
    private IntegralRuleMapper integralRuleMapper;

    @Override
    public BasicData queryIntegralRule() {
        IntegralRule integralRule =integralRuleMapper.queryIntegralRule();
        return BasicData.CreateSucess(integralRule);
    }

    @Override
    public BasicData updateIntegralRule(IntegralRule integralRule) {
        integralRuleMapper.updateIntegralRule(integralRule);
        return BasicData.CreateSucess();
    }
}

