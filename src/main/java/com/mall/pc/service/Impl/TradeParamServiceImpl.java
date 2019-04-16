package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.TradeParamMapper;
import com.mall.pc.domen.TradeParam;
import com.mall.pc.service.TradeParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 15:29
 **/
@Service
public class TradeParamServiceImpl implements TradeParamService {


    @Autowired
    private TradeParamMapper tradeParamMapper;

    @Override
    public BasicData querytradeparam(Integer tradeid) {

        List<TradeParam> list = tradeParamMapper.querytradeparam(tradeid);

        return BasicData.CreateSucess(list);
    }


    @Override
    public BasicData insertradeparam(TradeParam tradeParam) {
        TradeParam tradeParam1 = tradeParamMapper.querytradeparamByparam(tradeParam);
        if(tradeParam1!=null){
            return BasicData.CreateErrorMsg("This parameter already exists");
        }
        tradeParamMapper.insertradeparam(tradeParam);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updatetradeparam(TradeParam tradeParam) {
        tradeParamMapper.updatetradeparam(tradeParam);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData deltradeparam(Integer id) {
        tradeParamMapper.deltradeparam(id);
        return BasicData.CreateSucess();
    }
}

