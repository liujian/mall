package com.mall.weixinpay;

import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @program: server
 * @description:微信支付配置类
 * @author: liu.j
 * @create: 2019-03-12 10:03
 **/

public class MyConfig extends WXPayConfig {

    @Value("${weixin.appid}")
    protected String appid;

    @Value("${weixin.mch_id}")
    protected String mch_id;


    @Value("${weixin.key}")
    protected String key;

    private byte[] certData;
    public MyConfig() throws Exception {
//        String certPath = "classpath:apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }

    @Override
    public String getAppID() {
        return appid;
    }

    @Override
    public String getMchID() {
        return mch_id;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo("api.mch.weixin.qq.com", false);
            }
        };
    }
}