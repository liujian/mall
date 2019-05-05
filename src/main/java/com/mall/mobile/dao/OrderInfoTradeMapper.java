package com.mall.mobile.dao;


import com.mall.mobile.domen.OrderInfoTrade;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderInfoTradeMapper {

    List<OrderInfoTrade> queryAllOrderInfoTradeByOrderid(String orderid);

    void addOrderInfoTrade(OrderInfoTrade orderInfoTrade);

    void delOrderInfoTrade(String orderid);

}
