package com.mall.mobile.dao;


import com.mall.mobile.domen.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderInfoMapper {

    List<OrderInfo> queryAllOrderByUserId(@Param(value = "userid") Integer userid, @Param(value = "orderstatus") String orderstatus);

    void addOrderInfo(OrderInfo orderInfo);

    void delOrderInfo(String orderid);


}
