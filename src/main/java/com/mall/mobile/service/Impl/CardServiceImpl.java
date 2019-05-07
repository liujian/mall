package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.CardMapper;
import com.mall.mobile.dao.UserMapper;
import com.mall.mobile.domen.Card;
import com.mall.mobile.domen.User;
import com.mall.mobile.in.CardIn;
import com.mall.mobile.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-29 09:28
 **/
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public BasicData getCardList(String token) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        List<Card> cardList = cardMapper.getCardList(user.getId());
        return BasicData.CreateSucess(cardList);
    }

    @Override
    public BasicData queryCardByCardNo(String token, String cardno) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        Card card = cardMapper.queryCardByCardNo(user.getId(),cardno);
        return BasicData.CreateSucess(card);
    }

    @Override
    public BasicData addCard(CardIn cardIn) {
        User user = userMapper.selectByToken(cardIn.getToken());
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        Card card1= cardMapper.queryCardByCardNo(user.getId(),cardIn.getCardno());
        if(card1!=null){
            return BasicData.CreateErrorCardExists();
        }

        Card card = new Card();
        card.setUserid(user.getId());
        card.setCardname(cardIn.getCardname());
        card.setCardno(cardIn.getCardno());
        card.setExpirydate(cardIn.getExpirydate());
        card.setCvc(cardIn.getCvc());
        cardMapper.addCard(card);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delCard(String token, String cardno) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        cardMapper.delCard(user.getId(),cardno);
        return BasicData.CreateSucess();
    }
}

