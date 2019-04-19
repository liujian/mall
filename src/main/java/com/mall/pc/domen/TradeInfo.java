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
     *商品名称（中文）
     */
    private String tradename_zw;

    /**
     *商品名称（英文）
     */
    private String tradename_yw;

    /**
     *商品名称（简体）
     */
    private String tradename_jt;

    /**
     *商品图片
     */
    private String tradeimage;

    /**
     * 商品视频
     */
    private String tradevideo;

    /**
     *商品介绍（中文）
     */
    private String introduce_zw;

    /**
     *商品介绍（英文）
     */
    private String introduce_yw;

    /**
     *商品介绍（简体）
     */
    private String introduce_jt;


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
     *商品亮点（中文）
     */
    private String tradebright_zw;

    /**
     *商品亮点（英文）
     */
    private String tradebright_yw;

    /**
     *商品亮点（简体）
     */
    private String tradebright_jt;

    /**
     * 更多信息（中文）
     */
    private String moreinfo_zw;

    /**
     * 更多信息（英文）
     */
    private String moreinfo_yw;

    /**
     * 更多信息（简体）
     */
    private String moreinfo_jt;

    /**
     *分类
     */
    private Integer tradeclass;

    /**
     * 商品所属分类
     */
    private Integer classify;

    /**
     * 商品价格(加拿大)
     */
    private BigDecimal cad_price;

    /**
     * 商品价格(美国)
     */
    private BigDecimal usd_price;

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
     *促销价格-加
     */
    private BigDecimal cad_promoteprice;

    /**
     *促销价格-美
     */
    private BigDecimal usd_promoteprice;

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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

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

    public String getTradename_zw() {
        return tradename_zw;
    }

    public void setTradename_zw(String tradename_zw) {
        this.tradename_zw = tradename_zw;
    }

    public String getTradename_yw() {
        return tradename_yw;
    }

    public void setTradename_yw(String tradename_yw) {
        this.tradename_yw = tradename_yw;
    }

    public String getTradename_jt() {
        return tradename_jt;
    }

    public void setTradename_jt(String tradename_jt) {
        this.tradename_jt = tradename_jt;
    }

    public String getTradeimage() {
        return tradeimage;
    }

    public void setTradeimage(String tradeimage) {
        this.tradeimage = tradeimage;
    }

    public String getIntroduce_zw() {
        return introduce_zw;
    }

    public void setIntroduce_zw(String introduce_zw) {
        this.introduce_zw = introduce_zw;
    }

    public String getIntroduce_yw() {
        return introduce_yw;
    }

    public void setIntroduce_yw(String introduce_yw) {
        this.introduce_yw = introduce_yw;
    }

    public String getIntroduce_jt() {
        return introduce_jt;
    }

    public void setIntroduce_jt(String introduce_jt) {
        this.introduce_jt = introduce_jt;
    }


    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public Integer getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Integer salesvolume) {
        this.salesvolume = salesvolume;
    }

    public String getTradebright_zw() {
        return tradebright_zw;
    }

    public void setTradebright_zw(String tradebright_zw) {
        this.tradebright_zw = tradebright_zw;
    }

    public String getTradebright_yw() {
        return tradebright_yw;
    }

    public void setTradebright_yw(String tradebright_yw) {
        this.tradebright_yw = tradebright_yw;
    }

    public String getTradebright_jt() {
        return tradebright_jt;
    }

    public void setTradebright_jt(String tradebright_jt) {
        this.tradebright_jt = tradebright_jt;
    }

    public String getMoreinfo_zw() {
        return moreinfo_zw;
    }

    public void setMoreinfo_zw(String moreinfo_zw) {
        this.moreinfo_zw = moreinfo_zw;
    }

    public String getMoreinfo_yw() {
        return moreinfo_yw;
    }

    public void setMoreinfo_yw(String moreinfo_yw) {
        this.moreinfo_yw = moreinfo_yw;
    }

    public String getMoreinfo_jt() {
        return moreinfo_jt;
    }

    public void setMoreinfo_jt(String moreinfo_jt) {
        this.moreinfo_jt = moreinfo_jt;
    }

    public Integer getTradewarnnum() {
        return tradewarnnum;
    }

    public void setTradewarnnum(Integer tradewarnnum) {
        this.tradewarnnum = tradewarnnum;
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

    public BigDecimal getCad_price() {
        return cad_price;
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

    public BigDecimal getCad_promoteprice() {
        return cad_promoteprice;
    }

    public void setCad_promoteprice(BigDecimal cad_promoteprice) {
        this.cad_promoteprice = cad_promoteprice;
    }

    public BigDecimal getUsd_promoteprice() {
        return usd_promoteprice;
    }

    public void setUsd_promoteprice(BigDecimal usd_promoteprice) {
        this.usd_promoteprice = usd_promoteprice;
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

    public void setCad_price(BigDecimal cad_price) {
        this.cad_price = cad_price;
    }

    public BigDecimal getUsd_price() {
        return usd_price;
    }

    public void setUsd_price(BigDecimal usd_price) {
        this.usd_price = usd_price;
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

    public String getTradevideo() {
        return tradevideo;
    }

    public void setTradevideo(String tradevideo) {
        this.tradevideo = tradevideo;
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
}

