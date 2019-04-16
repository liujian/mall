package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeInfo;

public interface TradeInfoService {


    BasicData Querytrades(TradeInfo tradeInfo);

    BasicData QuerytradeById(Integer id);

    BasicData insertTradeInfo(TradeInfo tradeInfo);

    BasicData updateTradeInfo(TradeInfo tradeInfo);

    BasicData delTradeInfo(Integer id);

    BasicData queryAlltradelist(Integer classify);

    BasicData querytradelistByClassify(Integer classify);

    BasicData QuerytradeBysearchname(String searchname);

    BasicData QuerytradeBybarcode(String barcode);
}
