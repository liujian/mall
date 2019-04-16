package com.mall.pc.dao;

import com.mall.pc.domen.TradeInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TradeInfoMapper {

    List<TradeInfo> Querytrades(TradeInfo tradeInfo);

    List<TradeInfo> queryAlltradelist(Integer classify);

    List<TradeInfo> querytradelistByClassify(Integer classify);

    List<TradeInfo> QuerytradeBysearchname(String searchname);

    TradeInfo QuerytradeById(Integer id);

    TradeInfo QuerytradeByBarcode(String barcode);

    void insertTradeInfo(TradeInfo tradeInfo);

    void updateTradeInfo(TradeInfo tradeInfo);

    void delTradeInfo(Integer id);



}
