package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 15:24
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InterestController {

    @Autowired
    private InterestService interestService;

    /**
     * 获取我的最爱列表
     * @param token
     * @param request
     * @return
     */
    @RequestMapping(value="/getInterestList",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getInterestList(
            @RequestParam(required = true) String token,
            HttpServletRequest request){

        try{
            return interestService.getInterestList(token);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


    /**
     * 关注/取消商品
     * @param token
     * @param request
     * @return
     */
    @RequestMapping(value="/lovetrade",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getInterestList(
            @RequestParam(required = true) String token,
            @RequestParam(required = true) Integer trandid,
            HttpServletRequest request){

        try{
            return interestService.lovetrade(token,trandid);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }

}

