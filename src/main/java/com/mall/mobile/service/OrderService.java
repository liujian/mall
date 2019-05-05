package com.mall.mobile.service;

import com.mall.common.param.BasicData;
import com.mall.mobile.in.OrderIn;

public interface OrderService {

    BasicData cartorder(String token,Integer tradeclass,String discode,Integer integral,String zipcode);

    BasicData payorder(OrderIn orderIn);

    BasicData allorder(String token,String orderstatus,String languagetype);

    BasicData orderinfo(String token,String orderid,String languagetype);
}
