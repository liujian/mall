package com.mall.mobile.dao;

import com.mall.mobile.domen.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

	User selectByEmailAddress(String EmailAddress);
	User selectByToken(String token);
    void insertUser(User user);
    void updateToken(User user);
    void updatePassword(User user);
    void updateUserInfo(User user);
    void updateFireBaseToken(User user);
    void updateEmail(User user);
}