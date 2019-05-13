package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.domen.CustAdress;
import com.mall.mobile.service.CustAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: server
 * @description:
 * @author: liu.j
 * @create: 2019-03-04 18:42
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustAdressController {

    @Autowired
    private CustAdressService custAdressService;


    /**
     * 获取收货地址列表
     * @param token
     * @param request
     * @return
     */
    @RequestMapping(value="/getcustadress",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getcustadress(
            @RequestParam(required = false) String token,
            @RequestParam(required = false) String languagetype,
            HttpServletRequest request){

        try{
            return custAdressService.getcustadress(token,languagetype);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    /**
     * 获取收货地址
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/getcustadressByid",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getcustadressByid(
            @RequestParam(required = false) Integer id,
            HttpServletRequest request){

        try{
            return custAdressService.getcustadressByid(id);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 新增收获地址
     * @param custAdress
     * @param request
     * @return
     */
    @RequestMapping(value="/addcustadress",method = RequestMethod.POST)
    @ResponseBody
    public BasicData addcustadress(
            @RequestBody(required = false) CustAdress custAdress,
            HttpServletRequest request){

        try{
            return custAdressService.addcustadress(custAdress);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 修改收获地址
     * @param custAdress
     * @param request
     * @return
     */
    @RequestMapping(value="/updatecustadress",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updatecustadress(
            @RequestBody(required = false) CustAdress custAdress,
            HttpServletRequest request){

        try{
            return custAdressService.updatecustadress(custAdress);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 删除收获地址
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delcustadress",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delcustadress(
            @RequestParam(required = false) Integer id,
            HttpServletRequest request){

        try{
            return custAdressService.delcustadress(id);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }
}

