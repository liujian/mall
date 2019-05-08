package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.AdvertiseMapper;
import com.mall.pc.domen.Advertise;
import com.mall.pc.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-08 13:47
 **/
@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseMapper advertiseMapper;

    @Override
    public BasicData queryAdvertise() {
        List<Advertise> advertiseList =advertiseMapper.queryAdvertise();
        return BasicData.CreateSucess(advertiseList);
    }

    @Override
    public BasicData queryAdvertiseById(Integer id) {
        Advertise advertise = advertiseMapper.queryAdvertiseById(id);
        return BasicData.CreateSucess(advertise);
    }

    @Override
    public BasicData updateAdvertise(Advertise advertise) {
        advertiseMapper.updateAdvertise(advertise);
        return BasicData.CreateSucess();
    }
}

