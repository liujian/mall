package com.mall.mobile.service;

import com.mall.common.param.BasicData;
import com.mall.mobile.in.CardIn;

public interface CardService {


    BasicData getCardList(String token);

    BasicData queryCardByCardNo(String token,String cardno);

    BasicData addCard(CardIn cardIn);

    BasicData delCard(String token,String cardno);
}
