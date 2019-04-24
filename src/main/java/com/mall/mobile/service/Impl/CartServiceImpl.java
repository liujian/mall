package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.CartMapper;
import com.mall.mobile.dao.UserMapper;
import com.mall.mobile.domen.Cart;
import com.mall.mobile.domen.User;
import com.mall.mobile.in.CartIn;
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

    @Autowired
    private UserMapper userMapper;

    @Override
    public BasicData getCartList(String token) {
        User user = userMapper.selectByToken(token);
//        if(user==null){
//            return BasicData.CreateErrorInvalidUser();
//        }
//        List<Cart> cartList =cartMapper.getCartList(user.getId());
//        List<CartOut> cartOuts = new ArrayList<CartOut>();
//        for(Cart cart:cartList){
//            CartOut cartOut = new CartOut();
//            if("PT".equals(cart.getTradetype())){
//                TradeInfoOut tradeInfoOut = new TradeInfoOut();
//                TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(cart.getTradid());
//                TradeParam tradeParam = new TradeParam();
//                tradeParam.setTradeid(cart.getTradid());
//                tradeParam.setParam(cart.getTradparmname());
//                tradeParam.setParam(cart.getTradparm());
//                TradeParam tradeParam1 = tradeParamMapper.querytradeparamByparam(tradeParam);
//                tradeInfoOut.setTradeInfo(tradeInfo);
//                tradeInfoOut.setTradeParam(tradeParam1);
//                cartOut.setTradeInfoOut(tradeInfoOut);
//
//                TradeCategory tradeCategory = tradeCategoryMapper.QueryGoodCategoryById(tradeInfo.getTradeclass());
//                cartOut.setTradeCategory(tradeCategory);
//                cartOut.setCartid(cart.getId());
//                cartOut.setTradetype(cart.getTradetype());
//                cartOut.setTradenum(cart.getTradenum());
//            }
//            if("ZH".equals(cart.getTradetype())){
//                TradeComposeout tradeComposeout = new TradeComposeout();
//
//                TradeCompose tradeCompose = tradeComposeMapper.queryTradeComposeById(cart.getTradid());
//                tradeComposeout.setComposename(tradeCompose.getComposename());
//                tradeComposeout.setId(tradeCompose.getId());
//                tradeComposeout.setComposeprice(tradeCompose.getComposeprice());
//                TradeInfo maintrade = tradeInfoMapper.QuerytradeById(tradeCompose.getMaintrade());
//                tradeComposeout.setMaintrade(maintrade);
//                TradeInfo subtrade = tradeInfoMapper.QuerytradeById(tradeCompose.getSubtrade());
//                tradeComposeout.setSubtrade(subtrade);
//                cartOut.setTradeComposeout(tradeComposeout);
//                TradeCategory tradeCategory = tradeCategoryMapper.QueryGoodCategoryById(subtrade.getTradeclass());
//                cartOut.setTradeCategory(tradeCategory);
//                cartOut.setCartid(cart.getId());
//                cartOut.setTradetype(cart.getTradetype());
//                cartOut.setTradenum(cart.getTradenum());
//            }
//
//            cartOuts.add(cartOut);
//        }

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData addCart(CartIn cartIn) {
        User user = userMapper.selectByToken(cartIn.getToken());
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        Cart cart =new Cart();
        cart.setUserid(user.getId());
        cart.setTradid(cartIn.getTradid());
        cart.setTradenum(cartIn.getTradenum());
        cart.setTradeclass(cartIn.getTradeclass());
        cart.setTradetype(cartIn.getTradetype());
        cart.setTradparm(cartIn.getTradparm());
        cart.setTradparmnameid(cartIn.getTradparmnameid());

//        if("PT".equals(cart.getTradetype())){
//           List<TradeParam> tradeParams = tradeParamMapper.querytradeparam(cart.getTradid());
//           if(tradeParams.size()>0&&(cart.getTradparmnameid()==null||cart.getTradparm()==null||cart.getTradparm().isEmpty())){
//               return BasicData.CreateErrorMsg("请选择选项");
//            }
//
//            Cart cart1 = cartMapper.queryCart(cart);
//           if(cart1==null){
//               cartMapper.addCart(cart);
//           }else{
//               Integer tradenum= cart1.getTradenum();
//               tradenum=tradenum+1;
//               cart1.setTradenum(tradenum);
//               cartMapper.updateCart(cart1);
//           }
//
//        }
//
//        if("ZH".equals(cart.getTradetype())){
//            Cart cart1 = cartMapper.queryCart(cart);
//            if(cart1==null){
//                cartMapper.addCart(cart);
//            }else{
//                Integer tradenum= cart1.getTradenum();
//                tradenum=tradenum+1;
//                cart1.setTradenum(tradenum);
//                cartMapper.updateCart(cart1);
//            }
//        }

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData adddelCart(String token,Integer id, String type) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        Cart cart =cartMapper.queryCartByid(id);
        if(cart.getUserid()!=user.getId()){
            return BasicData.CreateErrorInvalidUser();
        }

        if("JIA".equals(type)){
            cart.setTradenum(cart.getTradenum()+1);
            cartMapper.updateCart(cart);
        }
        if("JIAN".equals(type)&&cart.getTradenum()>1){
                cart.setTradenum(cart.getTradenum()-1);
                cartMapper.updateCart(cart);
        }
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delCart(String token,Integer id) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        Cart cart =cartMapper.queryCartByid(id);

        if(cart!=null&&cart.getUserid()!=user.getId()){
            return BasicData.CreateErrorInvalidUser();
        }

        cartMapper.delCart(id);
        return BasicData.CreateSucess();
    }
}

