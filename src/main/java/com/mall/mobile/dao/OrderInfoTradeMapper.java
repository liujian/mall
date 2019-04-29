package com.mall.mobile.dao;


import com.mall.mobile.domen.OrderInfoTrade;

@org.apache.ibatis.annotations.Mapper
public interface OrderInfoTradeMapper {


    void addOrderInfoTrade(OrderInfoTrade orderInfoTrade);

    void delOrderInfoTrade(String orderid);

}
