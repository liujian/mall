package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeCompose;

public interface TradeComposeService {

    /**
     * 新增组合商品
     * @param tradeCompose
     * @return
     */
    BasicData insertTradeCompose(TradeCompose tradeCompose);

    /**
     * 修改组合商品
     * @param tradeCompose
     * @return
     */
    BasicData updateTradeCompose(TradeCompose tradeCompose);

    /**
     * 删除组合商品
     * @param id
     * @return
     */
    BasicData delTradeCompose(Integer id);
}
