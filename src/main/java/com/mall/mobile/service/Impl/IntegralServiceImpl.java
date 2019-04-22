package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.ScoureMapper;
import com.mall.mobile.domen.Scoure;
import com.mall.mobile.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 14:55
 **/
@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private ScoureMapper scoureMapper;


    @Override
    public BasicData getIntegralScoure(Integer userid) {
        List<Scoure> scoureList = scoureMapper.getScoureList(userid);
        return BasicData.CreateSucess(scoureList);
    }



}

