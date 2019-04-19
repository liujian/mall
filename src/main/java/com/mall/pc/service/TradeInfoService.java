package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.in.TradeParamIn;

public interface TradeInfoService {


    BasicData Querytrades(TradeInfo tradeInfo);

    BasicData QuerytradeById(Integer id);

    BasicData insertTradeInfo(TradeParamIn tradeParamIn);

    BasicData updateTradeInfo(TradeParamIn tradeParamIn);

    BasicData delTradeInfo(Integer id);

    BasicData queryAlltradelist(Integer classify,String search);

    BasicData querytradelistByClassify(Integer classify,String search);

    BasicData QuerytradeBysearchname(String searchname);

    BasicData QuerytradeBybarcode(String barcode);
}
