package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.Advertise;

import java.util.List;

public interface AdvertiseService {

    BasicData queryAdvertise();

    BasicData queryAdvertiseById(Integer id);

    BasicData updateAdvertise(Advertise advertise);
}
