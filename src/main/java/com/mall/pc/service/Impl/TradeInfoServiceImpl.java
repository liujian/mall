package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.TradeInfoMapper;
import com.mall.pc.dao.TradeParamMapper;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;
import com.mall.pc.service.TradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 13:19
 **/
@Service
public class TradeInfoServiceImpl implements TradeInfoService {

    @Autowired
    private TradeInfoMapper tradeInfoMapper;

    @Autowired
    private TradeParamMapper tradeParamMapper;

    @Override
    public BasicData Querytrades(TradeInfo tradeInfo) {

        List<TradeInfo> list =tradeInfoMapper.Querytrades(tradeInfo);

        return BasicData.CreateSucess(list);
    }

    @Override
    public BasicData QuerytradeById(Integer id) {
        Map map = new HashMap<>();
        TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(id);
        List<TradeParam> tradeParams = tradeParamMapper.querytradeparam(id);
        map.put("tradeInfo",tradeInfo);
        map.put("tradeParams",tradeParams);
        return BasicData.CreateSucess(map);
    }

    @Override
    public BasicData insertTradeInfo(TradeInfo tradeInfo) {

        TradeInfo trade = tradeInfoMapper.QuerytradeByBarcode(tradeInfo.getBarcode());
        if(trade!=null){
            return BasicData.CreateErrorMsg("This commodity bar code exists!");
        }
                tradeInfo.setInvalid("0");
        tradeInfoMapper.insertTradeInfo(tradeInfo);

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateTradeInfo(TradeInfo tradeInfo) {
        tradeInfoMapper.updateTradeInfo(tradeInfo);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delTradeInfo(Integer id) {
        tradeInfoMapper.delTradeInfo(id);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData queryAlltradelist(Integer classify) {
        List<TradeInfo> queryAlltradelist = tradeInfoMapper.queryAlltradelist(classify);

        return BasicData.CreateSucess(queryAlltradelist);
    }

    @Override
    public BasicData querytradelistByClassify(Integer classify) {
        List<TradeInfo> querytradelistByClassify = tradeInfoMapper.querytradelistByClassify(classify);
        return BasicData.CreateSucess(querytradelistByClassify);
    }

    @Override
    public BasicData QuerytradeBysearchname(String searchname) {

        List<TradeInfo> tradeInfos= tradeInfoMapper.QuerytradeBysearchname(searchname);

        return BasicData.CreateSucess(tradeInfos);
    }

    @Override
    public BasicData QuerytradeBybarcode(String barcode) {

        TradeInfo tradeInfo = tradeInfoMapper.QuerytradeByBarcode(barcode);
        return BasicData.CreateSucess(tradeInfo);
    }







}

