package com.mall.mobile.out;

import com.mall.pc.domen.TradeCategory;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-08 17:20
 **/

public class TradeCategoryOut {

    private TradeCategory tradeCategory;

    private List<TradeCategory> tradeCategoryList;

    public TradeCategory getTradeCategory() {
        return tradeCategory;
    }

    public void setTradeCategory(TradeCategory tradeCategory) {
        this.tradeCategory = tradeCategory;
    }

    public List<TradeCategory> getTradeCategoryList() {
        return tradeCategoryList;
    }

    public void setTradeCategoryList(List<TradeCategory> tradeCategoryList) {
        this.tradeCategoryList = tradeCategoryList;
    }
}

