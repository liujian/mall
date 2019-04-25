package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.out.CateParm;
import com.mall.mobile.out.HomeParmOut;
import com.mall.mobile.service.HomeinfoService;
import com.mall.pc.dao.BannerMapper;
import com.mall.pc.dao.BrandMapper;
import com.mall.pc.dao.TradeCategoryMapper;
import com.mall.pc.dao.TradeInfoMapper;
import com.mall.pc.domen.*;
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
    public BasicData gethomeinfo(String languagetype) {

        HomeParmOut homeParmOut =new HomeParmOut();

        List<Banner> banners =bannerMapper.queryBannerlist();
        List<TradeCategory> tradeCategories = new ArrayList<>();
        List<TradeCategory> tradeCategorieList = tradeCategoryMapper.QueryGoodCategorysByishomeicon();
        for(TradeCategory tradeCategory:tradeCategorieList){
            TradeCategoryTranslate tradeCategoryTranslate = tradeCategoryMapper.QueryCategorytranslateByclassidAndLanguagetype(tradeCategory.getId(),languagetype);
            if(tradeCategoryTranslate!=null&&!tradeCategoryTranslate.getClassifyname().isEmpty()){
                tradeCategory.setClassify(tradeCategoryTranslate.getClassifyname());
            }
            tradeCategories.add(tradeCategory);
        }
        List<CateParm> cateParms = new ArrayList<>();
        List<TradeCategory> tradeCategorys = tradeCategoryMapper.QueryGoodCategorysByishome();
        for(TradeCategory tradeCategory:tradeCategorys){
            CateParm cateParm =new CateParm();

            TradeCategoryTranslate tradeCategoryTranslate = tradeCategoryMapper.QueryCategorytranslateByclassidAndLanguagetype(tradeCategory.getId(),languagetype);
            if(tradeCategoryTranslate!=null&&!tradeCategoryTranslate.getClassifyname().isEmpty()){
                tradeCategory.setClassify(tradeCategoryTranslate.getClassifyname());
            }
            cateParm.setTradeCategory(tradeCategory);
            List<TradeInfo> tradeInfos = new ArrayList<>();
            List<TradeInfo> tradeInfoList = tradeInfoMapper.queryAllisHometradelist(tradeCategory.getId());
            for(TradeInfo tradeInfo:tradeInfoList){
                TradeInfoTranslate tradeInfoTranslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(tradeInfo.getId(),languagetype);
                if(tradeInfoTranslate!=null){
                    tradeInfo.setTradename(tradeInfoTranslate.getTradename());
                    tradeInfo.setIntroduce(tradeInfoTranslate.getIntroduce());
                    tradeInfo.setTradebright(tradeInfoTranslate.getTradebright());
                    tradeInfo.setMoreinfo(tradeInfoTranslate.getMoreinfo());
                }
                tradeInfos.add(tradeInfo);
            }
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

    @Override
    public BasicData gettradeByBrand(Integer brandid,String languagetype) {
        List<TradeInfo> tradeInfos = new ArrayList<>();
        List<TradeInfo> tradeInfoList = tradeInfoMapper.QuerytradeByBrandid(brandid);
        for(TradeInfo tradeInfo:tradeInfoList){
            TradeInfoTranslate tradeInfoTranslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(tradeInfo.getId(),languagetype);
            if(tradeInfoTranslate!=null){
                tradeInfo.setTradename(tradeInfoTranslate.getTradename());
                tradeInfo.setIntroduce(tradeInfoTranslate.getIntroduce());
                tradeInfo.setTradebright(tradeInfoTranslate.getTradebright());
                tradeInfo.setMoreinfo(tradeInfoTranslate.getMoreinfo());
            }
            tradeInfos.add(tradeInfo);
        }

        return BasicData.CreateSucess(tradeInfos);
    }
}

