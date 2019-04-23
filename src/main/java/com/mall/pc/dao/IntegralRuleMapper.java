package com.mall.pc.dao;

import com.mall.pc.domen.IntegralRule;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IntegralRuleMapper {


    IntegralRule queryIntegralRule();


    void updateIntegralRule(IntegralRule integralRule);




}
