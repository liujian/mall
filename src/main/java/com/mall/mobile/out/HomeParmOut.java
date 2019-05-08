package com.mall.mobile.out;

import com.mall.pc.domen.Advertise;
import com.mall.pc.domen.Banner;
import com.mall.pc.domen.Brand;
import com.mall.pc.domen.TradeCategory;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-19 16:20
 **/

public class HomeParmOut {

    /**
     *轮播图列表
     */
    private List<Banner> banners;

    /**
     *广告列表
     */
    private List<Advertise> advertises;

    /**
     * 小图标列表
     */
    private List<TradeCategory> tradeCategories;

    /**
     * 展示区列表
     */
    private List<CateParm> cateParms;

    /**
     * 品牌列表
     */
    private List<Brand> brands;



    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<Advertise> getAdvertises() {
        return advertises;
    }

    public void setAdvertises(List<Advertise> advertises) {
        this.advertises = advertises;
    }

    public List<TradeCategory> getTradeCategories() {
        return tradeCategories;
    }

    public void setTradeCategories(List<TradeCategory> tradeCategories) {
        this.tradeCategories = tradeCategories;
    }

    public List<CateParm> getCateParms() {
        return cateParms;
    }

    public void setCateParms(List<CateParm> cateParms) {
        this.cateParms = cateParms;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
}

