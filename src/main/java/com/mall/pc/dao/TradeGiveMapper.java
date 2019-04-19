package com.mall.pc.dao;

import com.mall.pc.domen.TradeGive;
import com.mall.pc.domen.TradePhoto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeGiveMapper {

    List<TradeGive> queryTradeGivelistByTradeid(Integer tradeid);

    TradeGive queryTradeGiveById(Integer id);

    void insertTradeGive(TradeGive tradeGive);

    void updateTradeGive(TradeGive tradeGive);

    void delTradeGive(Integer id);

}
