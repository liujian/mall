package com.mall.mobile.service;

import com.mall.common.param.BasicData;

public interface HomeinfoService {

    BasicData gethomeinfo(String languagetype);

    BasicData gettradeByBrand(Integer brandid,String languagetype);
}
