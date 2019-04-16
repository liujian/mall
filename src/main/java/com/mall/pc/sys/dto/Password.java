package com.mall.pc.sys.dto;

import com.mall.pc.sys.domen.SysUser;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author:mengchen
 * @date:2019/3/25
 * @description:
 */
public class Password {
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public String encryptPassword(String password) {
        String newPassword = new SimpleHash(algorithmName, password, null, hashIterations).toHex();
        return newPassword;
    }

    public void encryptPassword(SysUser user) {
        String newPassword = new SimpleHash(algorithmName, user.getPassword(), null, hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
