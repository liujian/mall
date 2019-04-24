package com.mall.pc.domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 10:51
 **/

public class TradeInfo  implements Serializable {

    /**
     *id
     */
    private Integer id;

    /**
     *商品条形码
     */
    private String barcode;

    /**
     *商品名称（默认）
     */
    private String tradename;


    /**
     *商品图片
     */
    private String tradeimage;

    /**
     * 商品视频
     */
    private String tradevideo;

    /**
     *商品介绍（默认）
     */
    private String introduce;


    /**
     *商品数量
     */
    private Integer tradenum;

    /**
     *商品警告数量
     */
    private Integer tradewarnnum;

    /**
     *商品销量
     */
    private Integer salesvolume;

    /**
     *商品亮点（默认）
     */
    private String tradebright;


    /**
     * 更多信息（默认）
     */
    private String moreinfo;

    /**
     *分类
     */
    private Integer tradeclass;

    /**
     * 商品所属分类
     */
    private Integer classify;

    /**
     * 商品价格
     */
    private BigDecimal price;


    /**
     * 赠送积分
     */
    private Integer giveintegral;

    /**
     * 是否首页推荐展示
     */
    private String ishome;

    /**
     *所属品牌id
     */
    private Integer brandid;

    /**
     * 是否有效
     */
    private String invalid;

    /**
     * 创建时间
     */
    private Date createdate;

    /**
     *商品编码
     */
    private String tradecode;

    /**
     *商品重量
     */
    private BigDecimal tradeweight;

    /**
     *促销价格
     */
    private BigDecimal promoteprice;


    /**
     * 促销日期
     */
    private Date promotedate;

    /**
     * 是否精品
     */
    private String boutique;

    /**
     * 是否新品
     */
    private String newin;


    /**
     *热销
     */
    private String well;

    /**
     *优惠方式
     */
    private String coupway;

    /**
     *满件条件
     */
    private Integer fullpiece;

    /**
     *满金额条件
     */
    private BigDecimal fullprice;

    /**
     * 折扣比
     */
    private BigDecimal ratio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public String getTradeimage() {
        return tradeimage;
    }

    public void setTradeimage(String tradeimage) {
        this.tradeimage = tradeimage;
    }

    public String getTradevideo() {
        return tradevideo;
    }

    public void setTradevideo(String tradevideo) {
        this.tradevideo = tradevideo;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public Integer getTradewarnnum() {
        return tradewarnnum;
    }

    public void setTradewarnnum(Integer tradewarnnum) {
        this.tradewarnnum = tradewarnnum;
    }

    public Integer getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Integer salesvolume) {
        this.salesvolume = salesvolume;
    }

    public String getTradebright() {
        return tradebright;
    }

    public void setTradebright(String tradebright) {
        this.tradebright = tradebright;
    }

    public String getMoreinfo() {
        return moreinfo;
    }

    public void setMoreinfo(String moreinfo) {
        this.moreinfo = moreinfo;
    }

    public Integer getTradeclass() {
        return tradeclass;
    }

    public void setTradeclass(Integer tradeclass) {
        this.tradeclass = tradeclass;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getGiveintegral() {
        return giveintegral;
    }

    public void setGiveintegral(Integer giveintegral) {
        this.giveintegral = giveintegral;
    }

    public String getIshome() {
        return ishome;
    }

    public void setIshome(String ishome) {
        this.ishome = ishome;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getTradecode() {
        return tradecode;
    }

    public void setTradecode(String tradecode) {
        this.tradecode = tradecode;
    }

    public BigDecimal getTradeweight() {
        return tradeweight;
    }

    public void setTradeweight(BigDecimal tradeweight) {
        this.tradeweight = tradeweight;
    }

    public BigDecimal getPromoteprice() {
        return promoteprice;
    }

    public void setPromoteprice(BigDecimal promoteprice) {
        this.promoteprice = promoteprice;
    }

    public Date getPromotedate() {
        return promotedate;
    }

    public void setPromotedate(Date promotedate) {
        this.promotedate = promotedate;
    }

    public String getBoutique() {
        return boutique;
    }

    public void setBoutique(String boutique) {
        this.boutique = boutique;
    }

    public String getNewin() {
        return newin;
    }

    public void setNewin(String newin) {
        this.newin = newin;
    }

    public String getWell() {
        return well;
    }

    public void setWell(String well) {
        this.well = well;
    }

    public String getCoupway() {
        return coupway;
    }

    public void setCoupway(String coupway) {
        this.coupway = coupway;
    }

    public Integer getFullpiece() {
        return fullpiece;
    }

    public void setFullpiece(Integer fullpiece) {
        this.fullpiece = fullpiece;
    }

    public BigDecimal getFullprice() {
        return fullprice;
    }

    public void setFullprice(BigDecimal fullprice) {
        this.fullprice = fullprice;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}

