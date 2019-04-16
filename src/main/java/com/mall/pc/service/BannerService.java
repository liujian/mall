package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.Banner;

public interface BannerService {

    BasicData queryBannerlist();

    BasicData queryBannerById(Integer id);

    BasicData insertBanner(Banner banner);

    BasicData updateBanner(Banner banner);

    BasicData delBanner(Integer id);


}
