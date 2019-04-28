package com.mall.mobile.service;

import com.mall.common.param.BasicData;

public interface OrderService {

    BasicData cartorder(String token,Integer tradeclass,String discode,Integer integral,String zipcode);
}
