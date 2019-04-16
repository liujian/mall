package com.mall.mobile.dao;



import com.mall.mobile.domen.CustAdress;
import com.mall.mobile.domen.Interest;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface InterestMapper {

    List<Interest> getInterestList(Integer custid);

    Interest getInterest(Interest interest);

    void addInterest(Interest interest);

    void delInterest(Interest interest);

}
