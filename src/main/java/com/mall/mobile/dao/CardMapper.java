package com.mall.mobile.dao;




import com.mall.mobile.domen.Card;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CardMapper {

    List<Card> getCardList(Integer userid);

    Card queryCardByCardNo(@Param("userid") Integer userid, @Param("cardno")String cardno);

    void addCard(Card card);

    void delCard(@Param("userid") Integer userid, @Param("cardno")String cardno);

}
