package com.mall.pc.controller;

import com.mall.common.param.BasicData;
import com.mall.mobile.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 15:05
 **/
@Controller
@RequestMapping(value = "/message")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     *
     * @param type
     * @param json
     * @param body
     * @param request
     * @return
     */
    @RequestMapping(value="/sendmessage",method = RequestMethod.GET)
    @ResponseBody
    public BasicData sendmessage(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String json,
            @RequestParam(required = false) String body,
            HttpServletRequest request){

        try{
            return messageService.sendmessage(type,json,body);
        }catch(Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }
    }


}

