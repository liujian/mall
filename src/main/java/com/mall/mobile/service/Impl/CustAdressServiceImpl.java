package com.mall.mobile.service.Impl;


import com.mall.common.param.BasicData;
import com.mall.mobile.dao.CustAdressMapper;
import com.mall.mobile.dao.UserMapper;
import com.mall.mobile.domen.CustAdress;
import com.mall.mobile.domen.User;
import com.mall.mobile.service.CustAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: server
 * @description:
 * @author: liu.j
 * @create: 2019-03-04 18:52
 **/
@Service
public class CustAdressServiceImpl implements CustAdressService {

    @Autowired
    private CustAdressMapper custAdressMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public BasicData getcustadress(String token) {
        User user = userMapper.selectByToken(token);
        if (user == null) {
            return BasicData.CreateErrorInvalidUser();
        }

        List<CustAdress> list =custAdressMapper.getCustAddressList(user.getId());
        return BasicData.CreateSucess(list);
    }

    @Override
    public BasicData getcustadressByid(Integer id) {
        CustAdress custAdress =custAdressMapper.getcustadressByid(id);
        return BasicData.CreateSucess(custAdress);
    }

    @Override
    public BasicData addcustadress(CustAdress custAdress) {
        custAdressMapper.addcustadress(custAdress);

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updatecustadress(CustAdress custAdress) {

        custAdressMapper.updatecustadress(custAdress);

        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delcustadress(Integer id) {
        custAdressMapper.delcustadress(id);

        return BasicData.CreateSucess();
    }
}

