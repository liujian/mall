package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.*;
import com.mall.pc.domen.*;
import com.mall.pc.in.TradeParamIn;
import com.mall.pc.out.TradeParamOut;
import com.mall.pc.service.TradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private TradePhotoMapper tradePhotoMapper;

    @Autowired
    private TradeComposeMapper tradeComposeMapper;

    @Autowired
    private TradeGiveMapper tradeGiveMapper;

    @Override
    public BasicData Querytrades(TradeInfo tradeInfo) {

        List<TradeInfo> list =tradeInfoMapper.Querytrades(tradeInfo);

        return BasicData.CreateSucess(list);
    }

    @Override
    public BasicData QuerytradeById(Integer id) {
        TradeParamOut tradeParamOut = new TradeParamOut();
        TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(id);
        List<TradeParam> tradeParams = tradeParamMapper.querytradeparam(id);
        List<TradePhoto> tradePhotos = tradePhotoMapper.queryTradePhotolistByTradeid(id);
        List<TradeCompose> tradeComposes = tradeComposeMapper.queryTradeComposelistByMaintrade(id);
        List<TradeGive> tradeGives = tradeGiveMapper.queryTradeGivelistByTradeid(id);
        tradeParamOut.setTradeInfo(tradeInfo);
        tradeParamOut.setTradeParams(tradeParams);
        tradeParamOut.setTradePhotos(tradePhotos);
        tradeParamOut.setTradeComposes(tradeComposes);
        tradeParamOut.setTradeGives(tradeGives);
        return BasicData.CreateSucess(tradeParamOut);
    }

    @Override
    public BasicData insertTradeInfo(TradeParamIn tradeParamIn) {
        TradeInfo tradeInfo = tradeParamIn.getTradeInfo();

        TradeInfo trade = tradeInfoMapper.QuerytradeByBarcode(tradeInfo.getBarcode());
        if(trade!=null){
            return BasicData.CreateErrorMsg("This commodity bar code exists!");
        }
        tradeInfo.setInvalid("0");
        tradeInfo.setCreatedate(new Date());
        tradeInfoMapper.insertTradeInfo(tradeInfo);
        TradeInfo trade1 = tradeInfoMapper.QuerytradeByBarcode(tradeInfo.getBarcode());
        Integer tradeid=trade1.getId();
        //新增商品参数信息
        List<TradeParam> tradeParams =tradeParamIn.getTradeParams();
        for(TradeParam tradeParam :tradeParams){
            tradeParam.setTradeid(tradeid);
            tradeParamMapper.insertradeparam(tradeParam);
        }

        //新增相册信息
        List<TradePhoto> tradePhotos = tradeParamIn.getTradePhotos();
        for(TradePhoto tradePhoto : tradePhotos){
            tradePhoto.setTradeid(tradeid);
            tradePhotoMapper.insertTradePhoto(tradePhoto);
        }

        //新增组合套餐信息
        List<TradeCompose> tradeComposes = tradeParamIn.getTradeComposes();
        for(TradeCompose tradeCompose : tradeComposes){
            tradeCompose.setMaintrade(tradeid);
            tradeComposeMapper.insertTradeCompose(tradeCompose);
        }

        //新增赠送商品
        List<TradeGive> tradeGives = tradeParamIn.getTradeGives();
        for(TradeGive tradeGive : tradeGives){
            tradeGive.setTradeid(tradeid);
            tradeGiveMapper.insertTradeGive(tradeGive);
        }

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateTradeInfo(TradeParamIn tradeParamIn) {
        //更新商品信息
        TradeInfo tradeInfo = tradeParamIn.getTradeInfo();
        tradeInfoMapper.updateTradeInfo(tradeInfo);
        //更新商品参数信息
        List<TradeParam> tradeParams =tradeParamIn.getTradeParams();
        for(TradeParam tradeParam :tradeParams){
            tradeParamMapper.updatetradeparam(tradeParam);
        }

        //更新相册信息
        List<TradePhoto> tradePhotos = tradeParamIn.getTradePhotos();
        for(TradePhoto tradePhoto : tradePhotos){
            tradePhotoMapper.updateTradePhoto(tradePhoto);
        }

        //更新组合套餐信息
        List<TradeCompose> tradeComposes = tradeParamIn.getTradeComposes();
        for(TradeCompose tradeCompose : tradeComposes){
            tradeComposeMapper.updateTradeCompose(tradeCompose);
        }
        //更新赠送商品
        List<TradeGive> tradeGives = tradeParamIn.getTradeGives();
        for(TradeGive tradeGive : tradeGives){
            tradeGiveMapper.updateTradeGive(tradeGive);
        }


        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delTradeInfo(Integer id) {
        tradeInfoMapper.delTradeInfo(id);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData queryAlltradelist(Integer classify,String search) {
        List<TradeInfo> queryAlltradelist = tradeInfoMapper.queryAlltradelist(classify,search);

        return BasicData.CreateSucess(queryAlltradelist);
    }

    @Override
    public BasicData querytradelistByClassify(Integer classify,String search) {
        List<TradeInfo> querytradelistByClassify = tradeInfoMapper.querytradelistByClassify(classify,search);
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

