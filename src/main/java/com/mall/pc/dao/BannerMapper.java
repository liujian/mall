package com.mall.pc.dao;

import com.mall.pc.domen.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    List<Banner> queryBannerlist();

    Banner queryBannerById(Integer id);

    void insertBanner(Banner banner);

    void updateBanner(Banner banner);

    void delBanner(Integer id);



}
