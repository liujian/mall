package com.mall.mobile.service;

import com.mall.common.param.BasicData;

public interface InterestService {

    BasicData getInterestList(String token);

    BasicData lovetrade(String token,Integer trandid);


}
