package com.mall.pc.dao;

import com.mall.pc.domen.TradeGive;
import com.mall.pc.domen.TradePhoto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeGiveMapper {

    List<TradeGive> queryTradeGivelistByTradeid(@Param("tradeid")Integer tradeid, @Param("cate")String cate);

    TradeGive queryTradeGiveById(Integer id);

    void insertTradeGive(TradeGive tradeGive);

    void updateTradeGive(TradeGive tradeGive);

    void delTradeGiveById(Integer id);

    void delTradeGiveByTradeid(Integer tradeid);

}
