package com.mall.mobile.service;

import com.mall.common.param.BasicData;
import com.mall.mobile.in.*;

public interface UserLoginService {

    BasicData registration(RegistrationParam param);

    BasicData login(LoginParam param);

    BasicData logout(TokenParam param);

    BasicData forgetPassword(NewPasswordParam param);

    BasicData updateEmail(UpdateEmaileParam param);

    BasicData updatePassword(NewPasswordParam param);
}
