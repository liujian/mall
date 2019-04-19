package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.out.CateParm;
import com.mall.mobile.out.HomeParmOut;
import com.mall.mobile.service.HomeinfoService;
import com.mall.pc.dao.BannerMapper;
import com.mall.pc.dao.BrandMapper;
import com.mall.pc.dao.TradeCategoryMapper;
import com.mall.pc.dao.TradeInfoMapper;
import com.mall.pc.domen.Banner;
import com.mall.pc.domen.Brand;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.domen.TradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 16:17
 **/
@Service
public class HomeinfoServiceImpl implements HomeinfoService {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private TradeCategoryMapper tradeCategoryMapper;

    @Autowired
    private TradeInfoMapper tradeInfoMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public BasicData gethomeinfo() {

        HomeParmOut homeParmOut =new HomeParmOut();

        List<Banner> banners =bannerMapper.queryBannerlist();

        List<TradeCategory> tradeCategories = tradeCategoryMapper.QueryGoodCategorysByishomeicon();

        List<CateParm> cateParms = new ArrayList<>();
        List<TradeCategory> tradeCategorys = tradeCategoryMapper.QueryGoodCategorysByishome();
        for(TradeCategory tradeCategory:tradeCategorys){
            CateParm cateParm =new CateParm();
            cateParm.setTradeCategory(tradeCategory);
            List<TradeInfo> tradeInfos = tradeInfoMapper.queryAllisHometradelist(tradeCategory.getId());
            cateParm.setTradeInfoList(tradeInfos);
            cateParms.add(cateParm);
        }

        List<Brand> brands =brandMapper.queryisHomeBrandlist();

        homeParmOut.setBanners(banners);
        homeParmOut.setTradeCategories(tradeCategories);
        homeParmOut.setCateParms(cateParms);
        homeParmOut.setBrands(brands);

        return BasicData.CreateSucess(homeParmOut);
    }
}

