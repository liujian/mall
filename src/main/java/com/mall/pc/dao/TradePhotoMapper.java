package com.mall.pc.dao;

import com.mall.pc.domen.TradePhoto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TradePhotoMapper {

    List<TradePhoto> queryTradePhotolistByTradeid(Integer tradeid);

    TradePhoto queryTradePhotoById(Integer id);

    void insertTradePhoto(TradePhoto tradePhoto);

    void updateTradePhoto(TradePhoto tradePhoto);

    void delTradePhoto(Integer id);

}
