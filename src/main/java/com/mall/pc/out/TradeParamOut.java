package com.mall.pc.out;

import com.mall.pc.domen.TradeCompose;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;
import com.mall.pc.domen.TradePhoto;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 10:34
 **/

public class TradeParamOut {

    private TradeInfo tradeInfo;

    private List<TradeParam> tradeParams;

    private List<TradePhoto> tradePhotos;

    private List<TradeCompose> tradeComposes;

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

    public List<TradeParam> getTradeParams() {
        return tradeParams;
    }

    public void setTradeParams(List<TradeParam> tradeParams) {
        this.tradeParams = tradeParams;
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
}

