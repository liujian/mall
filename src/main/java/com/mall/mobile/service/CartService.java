package com.mall.mobile.service;

import com.mall.common.param.BasicData;
import com.mall.mobile.domen.Cart;
import com.mall.mobile.in.CartIn;

import java.util.List;

public interface CartService {

    BasicData getCartList(String token,String languagetype);

    BasicData addCart(CartIn cartIn);

    BasicData adddelCart(String token,Integer id,String type);

    BasicData delCart(String token,Integer id);

}
