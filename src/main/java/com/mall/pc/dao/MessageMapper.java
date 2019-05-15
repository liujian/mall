package com.mall.pc.dao;

import com.mall.pc.domen.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MessageMapper {

    List<Message> queryMessages();

    Message queryMessageById(String messageid);

    void addMessage(Message message);

}
