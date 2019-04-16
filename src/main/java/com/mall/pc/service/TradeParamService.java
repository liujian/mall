package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;

public interface TradeParamService {


    BasicData querytradeparam(Integer tradeid);

    BasicData insertradeparam(TradeParam tradeParam);

    BasicData updatetradeparam(TradeParam tradeParam);

    BasicData deltradeparam(Integer id);
}
