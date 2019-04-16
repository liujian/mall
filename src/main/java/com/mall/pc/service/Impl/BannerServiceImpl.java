package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.BannerMapper;
import com.mall.pc.domen.Banner;
import com.mall.pc.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 10:52
 **/
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;


    @Override
    public BasicData queryBannerlist() {

        List<Banner> list = bannerMapper.queryBannerlist();

        return BasicData.CreateSucess(list);
    }

    @Override
    public BasicData queryBannerById(Integer id) {
        Banner banner = bannerMapper.queryBannerById(id);
        return BasicData.CreateSucess(banner);
    }

    @Override
    public BasicData insertBanner(Banner banner) {
        banner.setCreatetime(new Date());
        bannerMapper.insertBanner(banner);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateBanner(Banner banner) {
        bannerMapper.updateBanner(banner);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delBanner(Integer id) {
        bannerMapper.delBanner(id);
        return BasicData.CreateSucess();
    }
}

