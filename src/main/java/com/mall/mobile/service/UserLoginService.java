package com.mall.mobile.service;

import com.mall.common.param.BasicData;
import com.mall.mobile.in.LoginParam;
import com.mall.mobile.in.NewPasswordParam;
import com.mall.mobile.in.RegistrationParam;
import com.mall.mobile.in.TokenParam;

public interface UserLoginService {

    BasicData registration(RegistrationParam param);

    BasicData login(LoginParam param);

    BasicData logout(TokenParam param);

    BasicData forgetPassword(NewPasswordParam param);
}
