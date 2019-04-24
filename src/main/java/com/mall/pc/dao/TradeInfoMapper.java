package com.mall.pc.dao;

import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeInfoTranslate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeInfoMapper {
    /**
     * 通过参数查找商品信息
     * @param tradeInfo 商品实体
     * @return
     */
    List<TradeInfo> Querytrades(TradeInfo tradeInfo);

    /**
     * 通过分类查找商品信息
     * @param tradeclass 分类id
     * @param search  方式（最新 、 销量 、价格）
     * @return
     */
    List<TradeInfo> queryAlltradelist(@Param("tradeclass") Integer tradeclass, @Param("search")String search);

    /**
     * 通过商品类型查找商品信息
     * @param classify 商品类型id
     * @param search 方式（最新 、 销量 、价格）
     * @return
     */
    List<TradeInfo> querytradelistByClassify(@Param("classify") Integer classify, @Param("search")String search);

    /**
     * 通过 分类查找商品
     * @param tradeclass 分类id 最外层的大类
     * @return
     */
    List<TradeInfo> queryAllisHometradelist(@Param("tradeclass") Integer tradeclass);

    /**
     * 通过搜索查找商品信息
     * @param searchname 搜索内容
     * @return
     */
    List<TradeInfo> QuerytradeBysearchname(String searchname);

    /**
     * 通过品牌查找商品信息
     * @param brandid 品牌id
     * @return
     */
    List<TradeInfo> QuerytradeByBrandid(Integer brandid);

    /**
     * 通过商品id查找商品
     * @param id
     * @return
     */
    TradeInfo QuerytradeById(Integer id);

    /**
     * 通过条形码查找商品
     * @param barcode 条形码
     * @return
     */
    TradeInfo QuerytradeByBarcode(String barcode);

    /**
     * 新增商品信息
     * @param tradeInfo 商品实体
     */
    void insertTradeInfo(TradeInfo tradeInfo);

    /**
     * 更新商品信息
     * @param tradeInfo 商品实体
     */
    void updateTradeInfo(TradeInfo tradeInfo);

    /**
     * 删除商品
     * @param id 商品id
     */
    void delTradeInfo(Integer id);


    //翻译mapper

    /**
     * 获取翻译列表
     * @param tradeid 商品id
     * @return
     */
    List<TradeInfoTranslate> QueryTradeTranslateBytrandid(Integer tradeid);

    /**
     * 查看翻译详情
     * @param tradeid 商品id
     * @param languagetype 语言类型
     * @return
     */
    TradeInfoTranslate QueryTradeTranslateBytrandidANDType(@Param("tradeid") Integer tradeid, @Param("languagetype")String languagetype);


    /**
     * 新增商品翻译模块
     * @param tradeInfoTranslate 商品翻译实体
     */
     void insertTradeTranslate(TradeInfoTranslate tradeInfoTranslate);

    /**
     * 更新指定语言的翻译
     * @param tradeInfoTranslate 商品翻译实体
     */
    void updateTradeTranslate(TradeInfoTranslate tradeInfoTranslate);

    /**
     * 删除商品指定语言的翻译
     * @param tradeid 商品id
     * @param languagetype 语言类型
     */
    void delTradeTranslate(@Param("tradeid") Integer tradeid, @Param("languagetype")String languagetype);



}
