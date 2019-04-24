package com.mall.mobile.out;

import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 16:52
 **/

public class TradeInfoOut {

    private TradeInfo tradeInfo;

    private String  tradeParamName;

    private String  tradeParam;

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

    public String getTradeParamName() {
        return tradeParamName;
    }

    public void setTradeParamName(String tradeParamName) {
        this.tradeParamName = tradeParamName;
    }

    public String getTradeParam() {
        return tradeParam;
    }

    public void setTradeParam(String tradeParam) {
        this.tradeParam = tradeParam;
    }
}

