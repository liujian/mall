package com.mall.mobile.dao;



import com.mall.mobile.domen.Integral;

@org.apache.ibatis.annotations.Mapper
public interface IntegralMapper {

    Integral getIntegralByUserid(Integer userid);

    void addIntegral(Integral integral);

    void updateIntegral(Integral integral);

}
