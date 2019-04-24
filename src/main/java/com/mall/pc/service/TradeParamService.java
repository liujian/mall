package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeParam;
import com.mall.pc.domen.TradeParamName;

public interface TradeParamService {

    /**
     * 获取商品属性名称列表
     * @param tradeid
     * @return
     */
    BasicData querytradeparmnameList(Integer tradeid);

    /**
     * 新增商品属性名称
     * @param tradeParamName
     * @return
     */
    BasicData addtradeparmname(TradeParamName tradeParamName);

    /**
     * 新增商品属性名称
     * @param tradeParamName
     * @return
     */
    BasicData updatetradeparmname(TradeParamName tradeParamName);

    /**
     * 删除商品属性名称
     * @param id 商品属性名称id
     * @return
     */
    BasicData deltradeparmname(Integer id);

    /**
     * 通过商品id和属性名称id查询对应参数
     * @param tradeid
     * @return
     */
    BasicData querytradeparam(Integer tradeid,Integer paramnameid);

    /**
     * 新增商品参数
     * @param tradeParam
     * @return
     */
    BasicData insertradeparam(TradeParam tradeParam);

    /**
     * 修改商品参数
     * @param tradeParam
     * @return
     */
    BasicData updatetradeparam(TradeParam tradeParam);

    /**
     * 删除商品参数
     * @param id
     * @return
     */
    BasicData deltradeparam(Integer id);
}
