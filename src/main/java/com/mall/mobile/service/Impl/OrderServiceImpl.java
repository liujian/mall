package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.*;
import com.mall.mobile.domen.*;
import com.mall.mobile.in.OrderIn;
import com.mall.mobile.out.*;
import com.mall.mobile.service.OrderService;
import com.mall.pc.dao.*;
import com.mall.pc.domen.*;
import com.mall.utils.CodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-23 15:18
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IntegralMapper integralMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private TradeInfoMapper tradeInfoMapper;

    @Autowired
    private TradeComposeMapper tradeComposeMapper;

    @Autowired
    private FreightMapper freightMapper;

    @Autowired
    private DiscountMapper discountMapper;

    @Autowired
    private IntegralRuleMapper integralRuleMapper;

    @Autowired
    private TaxRateMapper taxRateMapper;

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
    public BasicData cartorder(String token,Integer tradeclass,String discode,Integer integral,String zipcode) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }

        CartOrderOut cartOrderOut = new CartOrderOut();
        //获取我的积分
        Integral myintegral = integralMapper.getIntegralByUserid(user.getId());
        cartOrderOut.setMyintegral(myintegral.getSurpluscore());


         List<Cart> carts =cartMapper.getCartListByTradeclass(tradeclass);
        Integer tradenum = 0;

        BigDecimal total= new BigDecimal(0);

         //判断折扣码是否有效
        Boolean discodevalid =false;
        Discount discount = discountMapper.queryDiscountByCode(discode);

        for(Cart cart:carts){
             if("PT".equals(cart.getTradetype())){
                 tradenum=tradenum+cart.getTradenum();
                 TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(cart.getTradid());
                 if(tradeInfo.getPromotedate()!=null&&sameDate(tradeInfo.getPromotedate(),new Date())){
                     total=total.add(tradeInfo.getPromoteprice().multiply(new BigDecimal(cart.getTradenum())));
                 }else{
                     total=total.add(tradeInfo.getPrice().multiply(new BigDecimal(cart.getTradenum())));
                 }
             }

            if("ZH".equals(cart.getTradetype())){
                tradenum=tradenum+(cart.getTradenum()*2);
                TradeCompose tradeCompose = tradeComposeMapper.queryTradeComposeById(cart.getTradid());
                total=total.add(tradeCompose.getComposeprice().multiply(new BigDecimal(cart.getTradenum())));
            }

            if((!discodevalid)&&discount!=null&&"TY".equals(discount.getDisway())&&discount.getTradeid().equals(cart.getTradid())){
                discodevalid=true;

            }

            if((!discodevalid)&&discount!=null&&"PT".equals(discount.getDisway())&&"PT".equals(cart.getTradetype())&&discount.getTradeid().equals(cart.getTradid())){
                discodevalid=true;
            }

            if((!discodevalid)&&discount!=null&&"ZH".equals(discount.getDisway())&&"ZH".equals(cart.getTradetype())&&discount.getTradeid().equals(cart.getTradid())){
                discodevalid=true;
            }

        }
        //件数
        cartOrderOut.setTradenum(tradenum);
        cartOrderOut.setPrice(total);

        //折扣
        if(discodevalid){
            cartOrderOut.setDiscount(total.subtract(total.multiply(discount.getDisratio())));
            total=total.multiply(discount.getDisratio());
            cartOrderOut.setDiscode(discode);

        }
        cartOrderOut.setDiscodevalid(discodevalid);
        //积分抵扣
        if(integral!=null&&integral<=myintegral.getSurpluscore()){
            IntegralRule integralRule = integralRuleMapper.queryIntegralRule();
            BigDecimal integraldeduct = new BigDecimal(0);
            Integer gral = integralRule.getIntegral();
            BigDecimal deduction = integralRule.getDeduction();

            integraldeduct=deduction.multiply(new BigDecimal(integral/gral));
            cartOrderOut.setIntegral((integral/gral)*gral);
            cartOrderOut.setIntegraldeduct(integraldeduct);
            total=total.subtract(integraldeduct);
        }


        //小计
        BigDecimal subtotal =total;
        cartOrderOut.setSubtotal(subtotal);

        //税率
        if(zipcode!=null&&taxRateMapper.queryTaxRateByCode(zipcode)!=null){
            TaxRate taxRate = taxRateMapper.queryTaxRateByCode(zipcode);
            BigDecimal tax = total.multiply(taxRate.getTaxrate());
            cartOrderOut.setTax(tax);
            total=total.add(tax);
        }

        //运费
        Freight freight = freightMapper.queryFreight();
        if(total.compareTo(freight.getFreeship())==-1){
            cartOrderOut.setFreight(freight.getFreight());
            total=total.add(freight.getFreight());
        }else{
            cartOrderOut.setFreight(new BigDecimal(0));
        }

        //总计
        cartOrderOut.setTotal(total);

        return BasicData.CreateSucess(cartOrderOut);
    }

    @Override
    public BasicData payorder(OrderIn orderIn) {
        User user = userMapper.selectByToken(orderIn.getToken());
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
       String orderid = CodeFactory.getOrderIdByUUId();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderid(orderid);
        orderInfo.setUserid(user.getId());
        orderInfo.setClassid(orderIn.getClassid());
        orderInfo.setOrderstatus("10");
        orderInfo.setTradenum(orderIn.getTradenum());
        orderInfo.setTradeprice(orderIn.getTradeprice());
        orderInfo.setOrderdiscount(orderIn.getOrderdiscount());
        orderInfo.setDiscountprice(orderIn.getDiscountprice());
        orderInfo.setOrderintegral(orderIn.getOrderintegral());
        orderInfo.setIntegralprice(orderIn.getIntegralprice());
        orderInfo.setActualprice(orderIn.getActualprice());
        orderInfo.setFreight(orderIn.getFreight());
        orderInfo.setTax(orderIn.getTax());
        orderInfo.setOrdertotalprice(orderIn.getOrdertotalprice());
        orderInfo.setPayway(null);
        orderInfo.setPayflowcode(null);
        orderInfo.setCreatetime(new Date());
        orderInfo.setExpresscode(null);
        orderInfo.setName(orderIn.getName());
        orderInfo.setPhone(orderIn.getPhone());
        orderInfo.setAddress(orderIn.getAddress());
        orderInfo.setPaystatus("DZF");
        orderInfoMapper.addOrderInfo(orderInfo);
        List<Cart> cartList = orderIn.getCartList();
        for(Cart cart:cartList){
            OrderInfoTrade orderInfoTrade = new OrderInfoTrade();
            orderInfoTrade.setOrderid(orderid);
            if("PT".equals(cart.getTradetype())){
                orderInfoTrade.setTradetype("PT");
                TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(cart.getTradid());
                if(tradeInfo.getPromotedate()!=null&&sameDate(tradeInfo.getPromotedate(),new Date())){
                    orderInfoTrade.setTradeprice(tradeInfo.getPromoteprice());
                    orderInfoTrade.setTradenum(cart.getTradenum());
                    orderInfoTrade.setTradetotalprice(tradeInfo.getPromoteprice().multiply(new BigDecimal(cart.getTradenum())));

                }else{
                    orderInfoTrade.setTradeprice(tradeInfo.getPrice());
                    orderInfoTrade.setTradenum(cart.getTradenum());
                    orderInfoTrade.setTradetotalprice(tradeInfo.getPrice().multiply(new BigDecimal(cart.getTradenum())));
                }
            }

            if("ZH".equals(cart.getTradetype())){
                orderInfoTrade.setTradetype("ZH");
                orderInfoTrade.setTradenum(cart.getTradenum());
                TradeCompose tradeCompose = tradeComposeMapper.queryTradeComposeById(cart.getTradid());
                orderInfoTrade.setTradeprice(tradeCompose.getComposeprice());
                orderInfoTrade.setTradetotalprice(tradeCompose.getComposeprice().multiply(new BigDecimal(cart.getTradenum())));
            }

            orderInfoTrade.setTradeid(cart.getTradid());
            orderInfoTrade.setTradepramid(cart.getTradparmid());
            orderInfoTrade.setTradepramnameid(cart.getTradparmnameid());
            orderInfoTradeMapper.addOrderInfoTrade(orderInfoTrade);
        }





        return BasicData.CreateSucess();
    }

    @Override
    public BasicData allorder(String token,String orderstatus,String languagetype) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        List<OrderOuts> outs = new ArrayList<>();
        List<OrderInfo> orderInfos = orderInfoMapper.queryAllOrderByUserId(user.getId(),orderstatus);
        for(OrderInfo orderInfo : orderInfos){
            OrderOuts orderOuts = new OrderOuts();
            orderOuts.setOrderid(orderInfo.getOrderid());
            TradeCategory tradeCategory = tradeCategoryMapper.QueryGoodCategoryById(orderInfo.getClassid());
            TradeCategoryTranslate tradeCategoryTranslate = tradeCategoryMapper.QueryCategorytranslateByclassidAndLanguagetype(tradeCategory.getId(),languagetype);
            if(tradeCategoryTranslate!=null&&!tradeCategoryTranslate.getClassifyname().isEmpty()){
                tradeCategory.setClassify(tradeCategoryTranslate.getClassifyname());
            }
            orderOuts.setClassname(tradeCategory.getClassify());
            orderOuts.setOrderstatus(orderInfo.getOrderstatus());
            orderOuts.setTradenum(orderInfo.getTradenum());
            orderOuts.setOrdertotalprice(orderInfo.getOrdertotalprice());
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
                      TradeInfoTranslate tradeInfoTranslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(tradeInfo.getId(),languagetype);
                      if(tradeInfoTranslate!=null){
                          tradeInfo.setTradename(tradeInfoTranslate.getTradename());
                          tradeInfo.setIntroduce(tradeInfoTranslate.getIntroduce());
                          tradeInfo.setTradebright(tradeInfoTranslate.getTradebright());
                          tradeInfo.setMoreinfo(tradeInfoTranslate.getMoreinfo());
                      }
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
                     TradeInfoTranslate maintradeTranslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(maintrade.getId(),languagetype);
                     if(maintradeTranslate!=null){
                         maintrade.setTradename(maintradeTranslate.getTradename());
                         maintrade.setIntroduce(maintradeTranslate.getIntroduce());
                         maintrade.setTradebright(maintradeTranslate.getTradebright());
                         maintrade.setMoreinfo(maintradeTranslate.getMoreinfo());
                     }
                     tradeComposeout.setMaintrade(maintrade);
                     TradeInfo subtrade = tradeInfoMapper.QuerytradeById(tradeCompose.getSubtrade());
                     TradeInfoTranslate subtradeslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(subtrade.getId(),languagetype);
                     if(subtradeslate!=null){
                         maintrade.setTradename(subtradeslate.getTradename());
                         maintrade.setIntroduce(subtradeslate.getIntroduce());
                         maintrade.setTradebright(subtradeslate.getTradebright());
                         maintrade.setMoreinfo(subtradeslate.getMoreinfo());
                     }
                     tradeComposeout.setSubtrade(subtrade);
                     orderTradeOut.setTradeComposeout(tradeComposeout);
                     orderOutTradeList.add(orderTradeOut);
                 }
             }

            orderOuts.setOrderOutTradeList(orderOutTradeList);
            outs.add(orderOuts);
        }

        return BasicData.CreateSucess(outs);
    }

    @Override
    public BasicData orderinfo(String token, String orderid, String languagetype) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        Map map = new HashMap<>();
        OrderInfo orderInfo = orderInfoMapper.queryOrderByOrderId(orderid);
        map.put("orderInfo",orderInfo);
        TradeCategory tradeCategory = tradeCategoryMapper.QueryGoodCategoryById(orderInfo.getClassid());
        TradeCategoryTranslate tradeCategoryTranslate = tradeCategoryMapper.QueryCategorytranslateByclassidAndLanguagetype(tradeCategory.getId(),languagetype);
        if(tradeCategoryTranslate!=null&&!tradeCategoryTranslate.getClassifyname().isEmpty()){
            tradeCategory.setClassify(tradeCategoryTranslate.getClassifyname());
        }
        map.put("classname",tradeCategory.getClassify());
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
                TradeInfoTranslate tradeInfoTranslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(tradeInfo.getId(),languagetype);
                if(tradeInfoTranslate!=null){
                    tradeInfo.setTradename(tradeInfoTranslate.getTradename());
                    tradeInfo.setIntroduce(tradeInfoTranslate.getIntroduce());
                    tradeInfo.setTradebright(tradeInfoTranslate.getTradebright());
                    tradeInfo.setMoreinfo(tradeInfoTranslate.getMoreinfo());
                }
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
                TradeInfoTranslate maintradeTranslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(maintrade.getId(),languagetype);
                if(maintradeTranslate!=null){
                    maintrade.setTradename(maintradeTranslate.getTradename());
                    maintrade.setIntroduce(maintradeTranslate.getIntroduce());
                    maintrade.setTradebright(maintradeTranslate.getTradebright());
                    maintrade.setMoreinfo(maintradeTranslate.getMoreinfo());
                }
                tradeComposeout.setMaintrade(maintrade);
                TradeInfo subtrade = tradeInfoMapper.QuerytradeById(tradeCompose.getSubtrade());
                TradeInfoTranslate subtradeslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(subtrade.getId(),languagetype);
                if(subtradeslate!=null){
                    maintrade.setTradename(subtradeslate.getTradename());
                    maintrade.setIntroduce(subtradeslate.getIntroduce());
                    maintrade.setTradebright(subtradeslate.getTradebright());
                    maintrade.setMoreinfo(subtradeslate.getMoreinfo());
                }
                tradeComposeout.setSubtrade(subtrade);
                orderTradeOut.setTradeComposeout(tradeComposeout);
                orderOutTradeList.add(orderTradeOut);
            }
        }
        map.put("orderOutTradeList",orderOutTradeList);
        return BasicData.CreateSucess(map);
    }


    /**
     * 时间比较
     * @param d1
     * @param d2
     * @return
     */
    private static boolean sameDate(Date d1, Date d2) {
        LocalDate localDate1 = ZonedDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = ZonedDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate1.isEqual(localDate2);
    }


}

