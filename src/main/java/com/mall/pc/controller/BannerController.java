package com.mall.pc.controller;

import com.github.pagehelper.PageHelper;
import com.mall.common.param.BasicData;
import com.mall.pc.domen.Banner;
import com.mall.pc.domen.TradeCategory;
import com.mall.pc.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 10:53
 **/
@Controller
@RequestMapping(value = "/banner")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BannerController {


    @Autowired
    private BannerService bannerService;


    /**
     * 获取轮播图列表
     * @param request
     * @return
     */
    @RequestMapping(value="/queryBannerlist",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryBannerlist(
            @RequestParam(required = true) Integer pagenum,
            @RequestParam(required = true) Integer pagesize,
            HttpServletRequest request){
        try{
            PageHelper.startPage(pagenum,pagesize);
            return bannerService.queryBannerlist();
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     *轮播图详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/queryBannerById",method = RequestMethod.GET)
    @ResponseBody
    public BasicData queryBannerById(@RequestParam(required = true) Integer  id, HttpServletRequest request){
        try{
            return bannerService.queryBannerById(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 新增轮播图
     * @param banner
     * @param request
     * @return
     */
    @RequestMapping(value="/insertBanner",method = RequestMethod.POST)
    @ResponseBody
    public BasicData insertBanner(@RequestBody(required = false) Banner banner, HttpServletRequest request){
        try{
            return bannerService.insertBanner(banner);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

    /**
     * 修改轮播图
     * @param banner
     * @param request
     * @return
     */
    @RequestMapping(value="/updateBanner",method = RequestMethod.POST)
    @ResponseBody
    public BasicData updateBanner(@RequestBody(required = false) Banner banner, HttpServletRequest request){
        try{
            return bannerService.updateBanner(banner);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }


    /**
     * 删除轮播图
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/delBanner",method = RequestMethod.GET)
    @ResponseBody
    public BasicData delBanner(@RequestParam(required = true) Integer id, HttpServletRequest request){
        try{
            return bannerService.delBanner(id);
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());
        }

    }

}

