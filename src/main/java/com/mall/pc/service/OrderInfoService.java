package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.mobile.domen.OrderInfo;

public interface OrderInfoService {

    BasicData queryOrderInfolist( OrderInfo orderInfo);

    BasicData queryRBZYOrderInfolist( OrderInfo orderInfo);

    BasicData queryTHOrderInfolist( OrderInfo orderInfo);

    BasicData queryOrderInfo(String orderid);
}
