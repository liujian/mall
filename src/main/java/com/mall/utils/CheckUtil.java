package com.mall.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-15 09:39
 **/

public class CheckUtil {


    //判断Email合法性
    public static boolean isEmail(String email) {
        if (email == null)
            return false;
        String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(rule);
        matcher = pattern.matcher(email);
        if (matcher.matches())
            return true;
        else
            return false;
    }

}

