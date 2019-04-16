package com.mall.pc.domen;

import java.io.Serializable;
import java.math.BigDecimal;

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
     *是否含有参数
     */
    private String isparam;

    /**
     *商品参数名称（中文）
     */
    private String param_zw;

    /**
     *商品参数名称（英文）
     */
    private String param_yw;

    /**
     *商品参数名称（简体）
     */
    private String param_jt;

    /**
     *商品数量
     */
    private Integer tradenum;

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
     * 商品所属分类
     */
    private String classify;

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

    public String getIsparam() {
        return isparam;
    }

    public void setIsparam(String isparam) {
        this.isparam = isparam;
    }

    public String getParam_zw() {
        return param_zw;
    }

    public void setParam_zw(String param_zw) {
        this.param_zw = param_zw;
    }

    public String getParam_yw() {
        return param_yw;
    }

    public void setParam_yw(String param_yw) {
        this.param_yw = param_yw;
    }

    public String getParam_jt() {
        return param_jt;
    }

    public void setParam_jt(String param_jt) {
        this.param_jt = param_jt;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public BigDecimal getCad_price() {
        return cad_price;
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

