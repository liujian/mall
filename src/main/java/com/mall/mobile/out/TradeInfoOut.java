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

    private TradeParam tradeParam;

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

    public TradeParam getTradeParam() {
        return tradeParam;
    }

    public void setTradeParam(TradeParam tradeParam) {
        this.tradeParam = tradeParam;
    }
}

