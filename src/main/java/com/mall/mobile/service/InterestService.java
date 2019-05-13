package com.mall.mobile.service;

import com.mall.common.param.BasicData;

public interface InterestService {

    BasicData getInterestList(String token,String languagetype);

    BasicData lovetrade(String token,Integer trandid,String languagetype);


}
