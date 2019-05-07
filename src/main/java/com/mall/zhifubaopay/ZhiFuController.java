package com.mall.zhifubaopay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.github.pagehelper.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-06 09:04
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class ZhiFuController {


    @Value("${alipayconfig.appid}")
    private String appid; // 商户appid
    @Value("${alipayconfig.rsa_private_key}")
    private String rsa_private_key; // 私钥 pkcs8格式的
    @Value("${alipayconfig.notify_url}")
    private String notify_url; // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    @Value("${alipayconfig.return_url}")
    private String return_url; // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    @Value("${alipayconfig.url}")
    private String url; // 请求网关地址
    @Value("${alipayconfig.charset}")
    private String charset; // 编码
    @Value("${alipayconfig.format}")
    private String format; // 返回格式
    @Value("${alipayconfig.alipay_public_key}")
    private String alipay_public_key; // 支付宝公钥
    @Value("${alipayconfig.signtype}")
    private String signtype;

    /**
     * 支付请求
     * @param orderNo 订单号
     * @param totalAmount 订单总价
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws Exception
     */
    @RequestMapping(value="/alipay",method = RequestMethod.GET)
    @ResponseBody
    public R pay(@RequestParam(required = false)String orderNo,
                 @RequestParam(required = false)BigDecimal totalAmount,
                 HttpServletRequest request,
                 HttpServletResponse response)
            throws ServletException, Exception {
        double price = totalAmount.doubleValue();
        System.out.println("price:" + price);
        String form = ""; // 生成支付表单
        // 封装请求客户端 // 实例化客户端
        AlipayClient client = new DefaultAlipayClient(url, appid,
                rsa_private_key, format, charset,
                alipay_public_key,signtype);

        // 支付请求
        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
        // SDK已经封装掉了公共参数，这里只需要传入业务参数。
        // 以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradePayModel model = new AlipayTradePayModel();
        // 描述信息 添加附加数据
        model.setProductCode("QUICK_MSECURITY_PAY"); // 设置销售产品码
        model.setOutTradeNo(orderNo); // 设置订单号
        model.setSubject("--小口袋订单支付--"); // 订单名称
        model.setTotalAmount("" + price + ""); // 支付总金额
        model.setBody("body"); // 设置商品描述
        model.setTimeoutExpress("30m"); // 超时关闭该订单时间
        // model.setSellerId("416032133@qq.com"); // 商家id
        alipayRequest.setBizModel(model);
        // 异步回调地址
        alipayRequest.setNotifyUrl(notify_url);
        /* AlipayTradeAppPayResponse responses = */
        AlipayTradeAppPayResponse responses = client.sdkExecute(alipayRequest);
        form = responses.getBody();// 生成支付表单
        System.out.println(form); // 就是orderString 可以直接给客户端请求，无需再做处理
        return R.ok().put("form", form);

    }


    /**
     * 支付宝服务器异步通知
     *
     * @param request
     * @return
     */
    @RequestMapping("/alinotifyUrl")
    public R notifyUrl(HttpServletRequest request) throws Exception {
        BigDecimal platfor = null;
        log.info("notifyUrl");
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            /* valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8"); */

            params.put(name, valueStr);
            System.out.println("name:" + name + ",valueStr:" + valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipay_public_key,
                charset, signtype); // 调用SDK验证签名

        // 商户订单号
        String out_trade_no = request.getParameter("out_trade_no");
        // 交易状态
        String trade_status = request.getParameter("trade_status");
        String trade_no = request.getParameter("trade_no");// 交易流水号
        if (signVerified) { // 验证成功 更新订单信息
            if (trade_status.equals("TRADE_FINISHED")) {
                log.info("TRADE_FINISHED");
            }
            if (trade_status.equals("TRADE_SUCCESS")) {
                log.info("TRADE_SUCCESS");
            }

            if (StringUtil.isNotEmpty(out_trade_no)) {
                // 获取订单
                String orderid = out_trade_no;
                //处理逻辑

                return R.ok("SUCCESS");
            }
        } else {
            return R.error("支付失败");
        }
        return R.error("支付失败");

    }


}

