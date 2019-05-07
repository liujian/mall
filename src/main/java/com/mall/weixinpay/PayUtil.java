package com.mall.weixinpay;


import com.mall.common.param.BasicData;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: server
 * @description:
 * @author: liu.j
 * @create: 2019-03-12 10:06
 **/

public class PayUtil {





    /**
     * 微信统一下单接口
     * @param appid 微信开放平台审核通过的应用APPID
     * @param fee_type 货币类型
     * @param mch_id 调用接口提交的商户号
     * @param notify_url 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
     * @param key 秘钥
     * @param body 商品描述
     * @param total_fee 支付金额
     * @param out_trade_no 商户订单号
     * @return
     */
    public static BasicData doUnifiedOrder(String appid, String fee_type, String mch_id, String notify_url, String key, String body, BigDecimal total_fee, String out_trade_no) {
//        BaseResponse<Map> response = new BaseResponse<>();
        Map resultMap=new HashMap();
//        String openid = baseRequest.getRequestData().getOpenId();
        MyConfig config = null;
        WXPay wxpay =null;
        try {
            config = new MyConfig();
            config.appid=appid;
            config.key=key;
            config.mch_id=mch_id;
            wxpay= new WXPay(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //生成的随机字符串
        String nonce_str = WXPayUtil.generateNonceStr();
        //获取客户端的ip地址
        //获取本机的ip地址
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();
        //支付金额，需要转成字符串类型，否则后面的签名会失败
        //
        int money=total_fee.intValue();
        //统一下单接口参数
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("appid", appid);
        data.put("mch_id", mch_id);
        data.put("nonce_str", nonce_str);
        data.put("body", body);
        data.put("out_trade_no",out_trade_no);
        data.put("fee_type", fee_type);
        data.put("total_fee", String.valueOf(money));
        data.put("spbill_create_ip", spbill_create_ip);
        data.put("notify_url", notify_url);
        data.put("trade_type","APP");

        try {
            Map<String, String> rMap = wxpay.unifiedOrder(data);
            System.out.println("统一下单接口返回: " + rMap);
            String return_code = (String) rMap.get("return_code");
            String result_code = (String) rMap.get("result_code");
            String nonceStr = WXPayUtil.generateNonceStr();
            resultMap.put("nonceStr", nonceStr);
            Long timeStamp = System.currentTimeMillis() / 1000;
            if ("SUCCESS".equals(return_code) && return_code.equals(result_code)) {
                String prepayid = rMap.get("prepay_id");
                resultMap.put("package", "prepay_id="+prepayid);
                resultMap.put("signType", "MD5");
                //这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                resultMap.put("timeStamp", timeStamp + "");
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                resultMap.put("appId",appid);
                String sign = WXPayUtil.generateSignature(resultMap, key);
                resultMap.put("paySign", sign);
                System.out.println("生成的签名paySign : "+ sign);
                BasicData basicData = BasicData.CreateSucess(resultMap);
                return basicData;
            }else{
                return  BasicData.CreateErrorMsg(rMap.get("return_msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  BasicData.CreateErrorMsg(e.getMessage());
        }
    }

}

