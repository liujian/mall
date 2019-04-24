package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.TradeParamMapper;
import com.mall.pc.dao.TradeParamNameMapper;
import com.mall.pc.domen.TradeParam;
import com.mall.pc.domen.TradeParamName;
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

    @Autowired
    private TradeParamNameMapper tradeParamNameMapper;


    @Override
    public BasicData querytradeparmnameList(Integer tradeid) {
        List<TradeParamName> tradeParamNames = tradeParamNameMapper.querytradeparamName(tradeid);
        return BasicData.CreateSucess(tradeParamNames);
    }

    @Override
    public BasicData addtradeparmname(TradeParamName tradeParamName) {
        tradeParamNameMapper.insertradeparamName(tradeParamName);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updatetradeparmname(TradeParamName tradeParamName) {
        tradeParamNameMapper.updatetradeparamName(tradeParamName);
        return  BasicData.CreateSucess();
    }

    @Override
    public BasicData deltradeparmname(Integer id) {

        tradeParamNameMapper.deltradeparamName(id);
        //删除商品参数名称下的参数
        tradeParamMapper.deltradeparamByParamnameid(id);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData querytradeparam(Integer tradeid,Integer paramnameid) {

        List<TradeParam> list = tradeParamMapper.querytradeparam(tradeid,paramnameid);

        return BasicData.CreateSucess(list);
    }


    @Override
    public BasicData insertradeparam(TradeParam tradeParam) {
        TradeParam tradeParam1 = tradeParamMapper.querytradeparamByparam(tradeParam);
        if(tradeParam1!=null){
            return BasicData.CreateErrorMsg("此参数以存在！");
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

