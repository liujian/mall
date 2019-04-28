package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.Freight;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 10:27
 **/

public interface FreightService {

    BasicData queryFreight();

    BasicData updateFreight(Freight freight);

}

