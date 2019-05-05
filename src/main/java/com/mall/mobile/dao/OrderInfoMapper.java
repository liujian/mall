package com.mall.mobile.dao;


import com.mall.mobile.domen.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderInfoMapper {

    List<OrderInfo> queryAllOrderByUserId(@Param(value = "userid") Integer userid, @Param(value = "orderstatus") String orderstatus);

    OrderInfo queryOrderByOrderId(String orderid);

    void addOrderInfo(OrderInfo orderInfo);

    void delOrderInfo(String orderid);


    //pc端
    List<OrderInfo> queryOrderInfolist(OrderInfo orderInfo);

    List<OrderInfo> queryRBZYOrderInfolist(OrderInfo orderInfo);

    List<OrderInfo> queryTHOrderInfolist(OrderInfo orderInfo);


}
