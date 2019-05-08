package com.mall.pc.dao;

import com.mall.pc.domen.Advertise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdvertiseMapper {

    List<Advertise> queryAdvertise();

    Advertise queryAdvertiseById(Integer id);

    void updateAdvertise(Advertise advertise);

}
