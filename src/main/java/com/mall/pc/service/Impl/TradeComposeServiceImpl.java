package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.TradeComposeMapper;
import com.mall.pc.domen.TradeCompose;
import com.mall.pc.service.TradeComposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-24 15:24
 **/
@Service
public class TradeComposeServiceImpl implements TradeComposeService {

    @Autowired
    private TradeComposeMapper tradeComposeMapper;

    @Override
    public BasicData insertTradeCompose(TradeCompose tradeCompose) {
        tradeComposeMapper.insertTradeCompose(tradeCompose);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateTradeCompose(TradeCompose tradeCompose) {
        tradeComposeMapper.updateTradeCompose(tradeCompose);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delTradeCompose(Integer id) {
        tradeComposeMapper.delTradeCompose(id);
        return BasicData.CreateSucess();
    }
}

