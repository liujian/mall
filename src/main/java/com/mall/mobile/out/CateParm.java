package com.mall.mobile.out;

import com.mall.pc.domen.TradeCategory;
import com.mall.pc.domen.TradeInfo;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 16:25
 **/

public class CateParm {

    private TradeCategory tradeCategory;

    private List<TradeInfo> tradeInfoList;

    public TradeCategory getTradeCategory() {
        return tradeCategory;
    }

    public void setTradeCategory(TradeCategory tradeCategory) {
        this.tradeCategory = tradeCategory;
    }

    public List<TradeInfo> getTradeInfoList() {
        return tradeInfoList;
    }

    public void setTradeInfoList(List<TradeInfo> tradeInfoList) {
        this.tradeInfoList = tradeInfoList;
    }
}

