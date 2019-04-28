package com.mall.pc.dao;

import com.mall.pc.domen.Banner;
import com.mall.pc.domen.Freight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FreightMapper {


    Freight queryFreight();

    void updateFreight(Freight freight);




}
