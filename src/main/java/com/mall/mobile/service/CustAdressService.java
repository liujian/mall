package com.mall.mobile.service;


import com.mall.common.param.BasicData;
import com.mall.mobile.domen.CustAdress;

public interface CustAdressService {


    BasicData getcustadress(String token,String languagetype);

    BasicData getcustadressByid(Integer id);

    BasicData addcustadress(CustAdress custAdress);

    BasicData updatecustadress(CustAdress custAdress);

    BasicData delcustadress(Integer id);

}
