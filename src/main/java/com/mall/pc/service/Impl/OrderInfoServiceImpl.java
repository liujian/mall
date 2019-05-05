package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.*;
import com.mall.mobile.domen.OrderInfo;
import com.mall.mobile.domen.OrderInfoTrade;
import com.mall.mobile.out.OrderTradeOut;
import com.mall.mobile.out.TradeComposeout;
import com.mall.mobile.out.TradeInfoOut;
import com.mall.pc.dao.*;
import com.mall.pc.domen.*;
import com.mall.pc.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mall
 * @description: OrderInfoService
 * @author: liu.j
 * @create: 2019-05-05 13:53
 **/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private TradeInfoMapper tradeInfoMapper;

    @Autowired
    private TradeComposeMapper tradeComposeMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderInfoTradeMapper orderInfoTradeMapper;

    @Autowired
    private TradeCategoryMapper tradeCategoryMapper;

    @Autowired
    private TradeParamNameMapper tradeParamNameMapper;

    @Autowired
    private TradeParamMapper tradeParamMapper;

    @Override
    public BasicData queryOrderInfolist(OrderInfo orderInfo) {
        List<OrderInfo> orderInfoList = orderInfoMapper.queryOrderInfolist(orderInfo);
        return BasicData.CreateSucess(orderInfoList);
    }

    @Override
    public BasicData queryRBZYOrderInfolist(OrderInfo orderInfo) {
        List<OrderInfo> orderInfoList = orderInfoMapper.queryRBZYOrderInfolist(orderInfo);
        return BasicData.CreateSucess(orderInfoList);
    }

    @Override
    public BasicData queryTHOrderInfolist(OrderInfo orderInfo) {
        List<OrderInfo> orderInfoList = orderInfoMapper.queryTHOrderInfolist(orderInfo);
        return BasicData.CreateSucess(orderInfoList);
    }

    @Override
    public BasicData queryOrderInfo(String orderid) {
        Map map = new HashMap<>();
        OrderInfo orderInfo = orderInfoMapper.queryOrderByOrderId(orderid);
        map.put("orderInfo",orderInfo);
        //处理订单商品信息
        List<OrderTradeOut> orderOutTradeList = new ArrayList<>();
        List<OrderInfoTrade> orderInfoTrades = orderInfoTradeMapper.queryAllOrderInfoTradeByOrderid(orderInfo.getOrderid());
        for(OrderInfoTrade orderInfoTrade : orderInfoTrades){
            OrderTradeOut orderTradeOut = new OrderTradeOut();
            //普通商品
            if("PT".equals(orderInfoTrade.getTradetype())){
                orderTradeOut.setOrderid(orderInfoTrade.getOrderid());
                orderTradeOut.setTradenum(orderInfoTrade.getTradenum());
                orderTradeOut.setTradetype(orderInfoTrade.getTradetype());
                orderTradeOut.setTradeprice(orderInfoTrade.getTradeprice());
                TradeInfoOut tradeInfoOut = new TradeInfoOut();

                TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(orderInfoTrade.getTradeid());
                tradeInfoOut.setTradeInfo(tradeInfo);
                //参数名称，参数
                TradeParamName tradeParamName = tradeParamNameMapper.querytradeparamNameById(orderInfoTrade.getTradepramnameid());
                TradeParam tradeParam = tradeParamMapper.querytradeparamById(orderInfoTrade.getTradepramid());
                if(tradeParamName!=null){
                    tradeInfoOut.setTradeParamName(tradeParamName.getParamname());
                }
                if(tradeParam!=null){
                    tradeInfoOut.setTradeParam(tradeParam.getParam());
                }
                orderTradeOut.setTradeInfoOut(tradeInfoOut);
                orderOutTradeList.add(orderTradeOut);

            }
            //组合商品
            if("ZH".equals(orderInfoTrade.getTradetype())){

                orderTradeOut.setOrderid(orderInfoTrade.getOrderid());
                orderTradeOut.setTradenum(orderInfoTrade.getTradenum());
                orderTradeOut.setTradetype(orderInfoTrade.getTradetype());
                orderTradeOut.setTradeprice(orderInfoTrade.getTradeprice());

                TradeComposeout tradeComposeout = new TradeComposeout();
                TradeCompose tradeCompose = tradeComposeMapper.queryTradeComposeById(orderInfoTrade.getTradeid());
                tradeComposeout.setComposename(tradeCompose.getComposename());
                tradeComposeout.setId(tradeCompose.getId());
                tradeComposeout.setComposeprice(tradeCompose.getComposeprice());
                TradeInfo maintrade = tradeInfoMapper.QuerytradeById(tradeCompose.getMaintrade());
                tradeComposeout.setMaintrade(maintrade);
                TradeInfo subtrade = tradeInfoMapper.QuerytradeById(tradeCompose.getSubtrade());
                tradeComposeout.setSubtrade(subtrade);
                orderTradeOut.setTradeComposeout(tradeComposeout);
                orderOutTradeList.add(orderTradeOut);
            }
        }
        map.put("orderOutTradeList",orderOutTradeList);
        return BasicData.CreateSucess(map);
    }
}

