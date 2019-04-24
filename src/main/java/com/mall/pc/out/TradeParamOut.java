package com.mall.pc.out;

import com.mall.pc.domen.*;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 10:34
 **/

public class TradeParamOut {

    private TradeInfo tradeInfo;

    private List<TradeParamNameOut> tradeParamNameOuts;

    private List<TradePhoto> tradePhotos;

    private List<TradeCompose> tradeComposes;

    private List<TradeGive> tradeGives;

    private List<TradeInfoTranslate> tradeInfoTranslates;

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

    public List<TradeParamNameOut> getTradeParamNameOuts() {
        return tradeParamNameOuts;
    }

    public void setTradeParamNameOuts(List<TradeParamNameOut> tradeParamNameOuts) {
        this.tradeParamNameOuts = tradeParamNameOuts;
    }

    public List<TradePhoto> getTradePhotos() {
        return tradePhotos;
    }

    public void setTradePhotos(List<TradePhoto> tradePhotos) {
        this.tradePhotos = tradePhotos;
    }

    public List<TradeCompose> getTradeComposes() {
        return tradeComposes;
    }

    public void setTradeComposes(List<TradeCompose> tradeComposes) {
        this.tradeComposes = tradeComposes;
    }

    public List<TradeGive> getTradeGives() {
        return tradeGives;
    }

    public void setTradeGives(List<TradeGive> tradeGives) {
        this.tradeGives = tradeGives;
    }

    public List<TradeInfoTranslate> getTradeInfoTranslates() {
        return tradeInfoTranslates;
    }

    public void setTradeInfoTranslates(List<TradeInfoTranslate> tradeInfoTranslates) {
        this.tradeInfoTranslates = tradeInfoTranslates;
    }
}

