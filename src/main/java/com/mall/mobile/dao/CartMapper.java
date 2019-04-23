package com.mall.mobile.dao;



import com.mall.mobile.domen.Cart;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CartMapper {

    List<Cart> getCartList(Integer userid);

    Cart queryCart(Cart cart);
    Cart queryCartByid(Integer id);

    void addCart(Cart cart);

    void updateCart(Cart cart);

    void delCart(Integer id);

}
