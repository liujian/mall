package com.mall.pc.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.IntegralRule;
import com.mall.pc.service.IntegralRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-23 14:17
 **/
@Controller
@RequestMapping(value = "/rule")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IntegralRuleController {


    @Autowired
    private IntegralRuleService integralRuleService;

    /**
     * 积分规则信息
     * @param request
     * @return
     */
    @RequestMapping(value="/queryIntegralRule",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryIntegralRule( HttpServletRequest request){
        try{
            return integralRuleService.queryIntegralRule();
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 积分规则信息
     * @param request
     * @return
     */
    @RequestMapping(value="/updateIntegralRule",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateIntegralRule(
            @RequestBody(required = false) IntegralRule integralRule,
            HttpServletRequest request){
        try{
            return integralRuleService.updateIntegralRule(integralRule);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }
}

