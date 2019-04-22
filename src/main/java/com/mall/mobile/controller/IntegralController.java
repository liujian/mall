package com.mall.mobile.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-22 14:53
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IntegralController {

    @Autowired
    private IntegralService integralService;


    /**
     * 查看我的积分明细
     * @param userid
     * @param request
     * @return
     */
    @RequestMapping(value="/getIntegralScoure",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getIntegralScoure(
            @RequestParam(required = true) Integer userid,
            HttpServletRequest request){

        try{
            return integralService.getIntegralScoure(userid);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


}

