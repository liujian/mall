package com.mall.mobile.out;

import com.mall.pc.domen.TradeCategory;
import com.mall.pc.domen.TradeInfo;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 16:41
 **/

public class CartOut {

    private TradeInfoOut tradeInfoOut;

    private TradeComposeout TradeComposeout;

    private TradeCategory tradeCategory;

    public TradeInfoOut getTradeInfoOut() {
        return tradeInfoOut;
    }

    public void setTradeInfoOut(TradeInfoOut tradeInfoOut) {
        this.tradeInfoOut = tradeInfoOut;
    }

    public com.mall.mobile.out.TradeComposeout getTradeComposeout() {
        return TradeComposeout;
    }

    public void setTradeComposeout(com.mall.mobile.out.TradeComposeout tradeComposeout) {
        TradeComposeout = tradeComposeout;
    }

    public TradeCategory getTradeCategory() {
        return tradeCategory;
    }

    public void setTradeCategory(TradeCategory tradeCategory) {
        this.tradeCategory = tradeCategory;
    }
}

