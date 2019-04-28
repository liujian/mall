package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.FreightMapper;
import com.mall.pc.domen.Freight;
import com.mall.pc.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 10:27
 **/
@Service
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightMapper freightMapper;

    @Override
    public BasicData queryFreight() {
        Freight freight = freightMapper.queryFreight();
        return BasicData.CreateSucess(freight);
    }

    @Override
    public BasicData updateFreight(Freight freight) {
        freightMapper.updateFreight(freight);
        return BasicData.CreateSucess();
    }
}

