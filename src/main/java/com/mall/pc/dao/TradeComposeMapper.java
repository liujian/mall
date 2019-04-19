package com.mall.pc.dao;

import com.mall.pc.domen.TradeCompose;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeComposeMapper {

    List<TradeCompose> queryTradeComposelistByMaintrade(Integer maintrade);

    TradeCompose queryTradeComposeById(Integer id);

    void insertTradeCompose(TradeCompose tradeCompose);

    void updateTradeCompose(TradeCompose tradeCompose);

    void delTradeCompose(Integer id);



}
