package com.mall.mobile.service;

import com.mall.common.param.BasicData;
import com.mall.mobile.domen.Cart;

import java.util.List;

public interface CartService {

    BasicData getCartList(Integer userid);

    BasicData addCart(Cart cart);

    BasicData updateCart(Cart cart);

    BasicData delCart(Cart cart);

}
