package com.mall.pc.dao;

import com.mall.pc.domen.TradeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeInfoMapper {

    List<TradeInfo> Querytrades(TradeInfo tradeInfo);

    List<TradeInfo> queryAlltradelist(@Param("classify") Integer classify, @Param("search")String search);

    List<TradeInfo> querytradelistByClassify(@Param("classify") Integer classify, @Param("search")String search);

    List<TradeInfo> QuerytradeBysearchname(String searchname);

    TradeInfo QuerytradeById(Integer id);

    TradeInfo QuerytradeByBarcode(String barcode);

    void insertTradeInfo(TradeInfo tradeInfo);

    void updateTradeInfo(TradeInfo tradeInfo);

    void delTradeInfo(Integer id);



}
