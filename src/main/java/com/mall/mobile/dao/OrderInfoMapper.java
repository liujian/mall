package com.mall.mobile.dao;


import com.mall.mobile.domen.OrderInfo;

@org.apache.ibatis.annotations.Mapper
public interface OrderInfoMapper {

    void addOrderInfo(OrderInfo orderInfo);

    void delOrderInfo(String orderid);


}
