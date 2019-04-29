package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.domen.CustAdress;
import com.mall.mobile.in.CardIn;
import com.mall.mobile.service.CardService;
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
public class CardController {

    @Autowired
    private CardService cardService;


    /**
     * 获取我的所有银行卡
     * @param token
     * @param request
     * @return
     */
    @RequestMapping(value="/getCardList",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getCardList(
            @RequestParam(required = false) String token,
            HttpServletRequest request){

        try{
            return cardService.getCardList(token);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

    /**
     * 我的银行卡信息
     * @param token
     * @param cardno
     * @param request
     * @return
     */
    @RequestMapping(value="/queryCardByCardNo",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryCardByCardNo(
            @RequestParam(required = false) String token,
            @RequestParam(required = false) String cardno,
            HttpServletRequest request){

        try{
            return cardService.queryCardByCardNo(token,cardno);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 新增我的银行卡
     * @param cardIn
     * @param request
     * @return
     */
    @RequestMapping(value="/addCard",method = RequestMethod.POST)
    @ResponseBody
    public BasicData addCard(
            @RequestBody(required = false) CardIn cardIn,
            HttpServletRequest request){

        try{
            return cardService.addCard(cardIn);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 删除我的银行卡
     * @param token
     * @param cardno
     * @param request
     * @return
     */
    @RequestMapping(value="/delCard",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delCard(
            @RequestParam(required = false) String token,
            @RequestParam(required = false) String cardno,
            HttpServletRequest request){

        try{
            return cardService.delCard(token,cardno);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }
}

