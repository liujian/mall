package com.mall.pc.dao;

import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeParamMapper {

    List<TradeParam> querytradeparam(Integer tradeid,Integer paramnameid);

    TradeParam querytradeparamByparam(TradeParam tradeParam);

    void insertradeparam(TradeParam tradeParam);

    void updatetradeparam(TradeParam tradeParam);

    void deltradeparam(Integer id);

    void deltradeparamByParamnameid(Integer paramnameid);



}
