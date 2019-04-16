package com.mall.mobile.dao;



import com.mall.mobile.domen.CustAdress;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CustAdressMapper {

    List<CustAdress> getCustAddressList(Integer custid);

    CustAdress getcustadressByid(Integer id);

    void addcustadress(CustAdress custAdress);

    void updatecustadress(CustAdress custAdress);

    void delcustadress(Integer id);

}
