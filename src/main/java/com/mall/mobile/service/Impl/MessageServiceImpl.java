package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.service.MessageService;
import com.mall.utils.FireBaseUtil;
import com.mall.utils.FireBaseUtils;
import com.mall.utils.PushDataBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-14 14:51
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private FireBaseUtils fireBaseUtils;

    @Override
    public BasicData sendmessage(String type, String json, String body) {
        //  fireBaseUtil.pushFCMNotification(type,json,body,"f52XKC2MNC8:APA91bFx188iqDGXVlQTzqdSXZb8IfJy05jgpLutUdcl8dcERJ330LsLPbmu_qKVjibSdK4IPvPF98DQxR90TDsn6limKQJsKQoQrBf_BSNcOfofImDkhmYI58zFK94D6LcBHdPE6Md-");
        PushDataBO pushData = new PushDataBO();
        pushData.setTitle("标题");
        pushData.setPushType("1");
        pushData.setBody("主题");
        pushData.setOpenData("opendata");
       // fireBaseUtils.pushSingle("f52XKC2MNC8:APA91bFx188iqDGXVlQTzqdSXZb8IfJy05jgpLutUdcl8dcERJ330LsLPbmu_qKVjibSdK4IPvPF98DQxR90TDsn6limKQJsKQoQrBf_BSNcOfofImDkhmYI58zFK94D6LcBHdPE6Md-",pushData);
       // fireBaseUtils.subTopic("f52XKC2MNC8:APA91bFx188iqDGXVlQTzqdSXZb8IfJy05jgpLutUdcl8dcERJ330LsLPbmu_qKVjibSdK4IPvPF98DQxR90TDsn6limKQJsKQoQrBf_BSNcOfofImDkhmYI58zFK94D6LcBHdPE6Md-","FT");
       // fireBaseUtils.unSubTopic("f52XKC2MNC8:APA91bFx188iqDGXVlQTzqdSXZb8IfJy05jgpLutUdcl8dcERJ330LsLPbmu_qKVjibSdK4IPvPF98DQxR90TDsn6limKQJsKQoQrBf_BSNcOfofImDkhmYI58zFK94D6LcBHdPE6Md-","YW");

        fireBaseUtils.pushTopic("FT",pushData);

        return BasicData.CreateSucess();
    }
}

