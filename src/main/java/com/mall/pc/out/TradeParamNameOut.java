package com.mall.pc.out;

import com.mall.pc.domen.TradeParam;
import com.mall.pc.domen.TradeParamName;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-24 13:47
 **/

public class TradeParamNameOut {

    private TradeParamName tradeParamName;

    private List<TradeParam> tradeParams;

    public TradeParamName getTradeParamName() {
        return tradeParamName;
    }

    public void setTradeParamName(TradeParamName tradeParamName) {
        this.tradeParamName = tradeParamName;
    }

    public List<TradeParam> getTradeParams() {
        return tradeParams;
    }

    public void setTradeParams(List<TradeParam> tradeParams) {
        this.tradeParams = tradeParams;
    }
}

