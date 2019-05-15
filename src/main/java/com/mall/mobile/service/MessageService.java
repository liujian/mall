package com.mall.mobile.service;

import com.mall.common.param.BasicData;

public interface MessageService {

    BasicData sendmessage(String type,String json,String body );
}
