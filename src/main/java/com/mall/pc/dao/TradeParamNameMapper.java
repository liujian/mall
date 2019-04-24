package com.mall.pc.dao;

import com.mall.pc.domen.TradeParam;
import com.mall.pc.domen.TradeParamName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeParamNameMapper {

    List<TradeParamName> querytradeparamName(Integer tradeid);

    void insertradeparamName(TradeParamName tradeParamName);

    void updatetradeparamName(TradeParamName tradeParamName);

    void deltradeparamName(Integer id);



}
