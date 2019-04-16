package com.mall.pc.sys.controller;

import com.mall.common.param.BasicData;
import com.mall.pc.sys.domen.Dictionary;
import com.mall.pc.sys.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/26
 * @description:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/dictionary")
public class DictionaryController {
    @Resource
    private DictionaryService dictionaryService;

    /**
     * 根据字典编码查询字典
     * @param dictCode
     * @return
     */
    @RequestMapping(value="/getDictListByCode",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getRoleList(@RequestParam String dictCode){
        List<HashMap> list = dictionaryService.getDictListByCode(dictCode);
        return BasicData.CreateSucess(list);
    }

    /**
     * 根据字典编码及键值查询字典
     * @param dictCode
     * @param dictKey
     * @return
     */
    @RequestMapping(value="/getDictListByCodeAndKey",method = RequestMethod.GET)
    @ResponseBody
    public BasicData getDictListByCodeAndKey(@RequestParam String dictCode, @RequestParam String dictKey){
        Dictionary list = dictionaryService.getDictListByCodeAndKey(dictCode, dictKey);
        return BasicData.CreateSucess(list);
    }
}
