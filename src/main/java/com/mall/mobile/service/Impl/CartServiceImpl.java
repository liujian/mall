package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.CartMapper;
import com.mall.mobile.domen.Cart;
import com.mall.mobile.out.CartOut;
import com.mall.mobile.out.TradeComposeout;
import com.mall.mobile.out.TradeInfoOut;
import com.mall.mobile.service.CartService;
import com.mall.pc.dao.TradeCategoryMapper;
import com.mall.pc.dao.TradeComposeMapper;
import com.mall.pc.dao.TradeInfoMapper;
import com.mall.pc.dao.TradeParamMapper;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.domen.TradeCompose;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;
import org.apache.commons.collections.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 16:31
 **/
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private TradeInfoMapper tradeInfoMapper;

    @Autowired
    private TradeParamMapper tradeParamMapper;

    @Autowired
    private TradeComposeMapper tradeComposeMapper;

    @Autowired
    private TradeCategoryMapper tradeCategoryMapper;

    @Override
    public BasicData getCartList(Integer userid) {
        List<Cart> cartList =cartMapper.getCartList(userid);
        List<CartOut> cartOuts = new ArrayList<CartOut>();
        for(Cart cart:cartList){
            CartOut cartOut = new CartOut();
            if("PT".equals(cart.getTradetype())){
                TradeInfoOut tradeInfoOut = new TradeInfoOut();
                TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(cart.getTradid());
                TradeParam tradeParam = new TradeParam();
                tradeParam.setTradeid(cart.getTradid());
                tradeParam.setParam_zw(cart.getTradparmname());
                tradeParam.setParam(cart.getTradparm());
                TradeParam tradeParam1 = tradeParamMapper.querytradeparamByparam(tradeParam);
                tradeInfoOut.setTradeInfo(tradeInfo);
                tradeInfoOut.setTradeParam(tradeParam);
                cartOut.setTradeInfoOut(tradeInfoOut);

                TradeCategory tradeCategory = tradeCategoryMapper.QueryGoodCategoryById(tradeInfo.getTradeclass());
                cartOut.setTradeCategory(tradeCategory);
            }
            if("ZH".equals(cart.getTradetype())){
                TradeComposeout tradeComposeout = new TradeComposeout();

                TradeCompose tradeCompose = tradeComposeMapper.queryTradeComposeById(cart.getTradid());
                tradeComposeout.setComposename_zw(tradeCompose.getComposename_zw());
                tradeComposeout.setComposename_yw(tradeCompose.getComposename_yw());
                tradeComposeout.setComposename_jt(tradeCompose.getComposename_jt());
                tradeComposeout.setId(tradeCompose.getId());
                tradeComposeout.setComposeprice(tradeCompose.getComposeprice());
                TradeInfo maintrade = tradeInfoMapper.QuerytradeById(tradeCompose.getMaintrade());
                tradeComposeout.setMaintrade(maintrade);
                TradeInfo subtrade = tradeInfoMapper.QuerytradeById(tradeCompose.getSubtrade());
                tradeComposeout.setSubtrade(subtrade);
                cartOut.setTradeComposeout(tradeComposeout);
                TradeCategory tradeCategory = tradeCategoryMapper.QueryGoodCategoryById(subtrade.getTradeclass());
                cartOut.setTradeCategory(tradeCategory);
            }

            cartOuts.add(cartOut);
        }

        return BasicData.CreateSucess(cartOuts);
    }

    @Override
    public BasicData addCart(Cart cart) {
        return null;
    }

    @Override
    public BasicData updateCart(Cart cart) {
        return null;
    }

    @Override
    public BasicData delCart(Cart cart) {
        return null;
    }
}

