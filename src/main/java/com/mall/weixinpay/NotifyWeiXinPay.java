package com.mall.weixinpay;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * @program: server
 * @description:公共响应类
 * @author: liu.j
 * @create: 2019-03-12 10:09
 **/
@Slf4j
@Controller
@RequestMapping(value = "/api/pay/")
public class NotifyWeiXinPay {


//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private PersonalService personalService;



    @RequestMapping(value = "notifyWeiXinOrderPay", produces = MediaType.APPLICATION_JSON_VALUE)
    // @RequestDescription("支付回调地址")
    @ResponseBody
    public void notifyWeiXinOrderPay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        String result = new String(outSteam.toByteArray(), "utf-8");
        outSteam.close();
        inStream.close();
        Map<String, String> map = null;
        try {
            map = WXPayUtil.xmlToMap(result);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        String result_code = "";
        String return_code = "";
        String out_trade_no = "";
        String transaction_id="";
        result_code = map.get("result_code");
        out_trade_no = map.get("out_trade_no");
        return_code = map.get("return_code");
        transaction_id =map.get("transaction_id");

        // 此处调用订单查询接口验证是否交易成功
//        WXOrderQuery wxpayResult = reqOrderQueryResult(map);
//        boolean isSucc = wxpayResult.isSuccess();
        // 支付成功，商户处理后同步返回给微信参数
        PrintWriter writer = response.getWriter();
        if (!"SUCCESS".equals(result_code) || "".equals(result_code)) {
            // 支付失败， 记录流水失败
            log.info("===============支付失败==============");
            String noticeStr = setXML("FAIL", "");
            writer.write(noticeStr);
            writer.flush();
        } else {
            String total_fee =map.get("total_fee");
            log.info("支付成功返回数据："+map);
          //  orderService.orderPayresult(out_trade_no,total_fee,transaction_id);
            log.info("===============付款成功，业务处理完毕==============");

            // 通知微信已经收到消息，不要再给我发消息了，否则微信会8连击调用本接口
            String noticeStr = setXML("SUCCESS", "");
            writer.write(noticeStr);
            writer.flush();
        }

    }








    public static String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
    }




}

