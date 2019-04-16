package com.mall.pc.sys.service.impl;

import com.mall.pc.sys.dao.DictionaryMapper;
import com.mall.pc.sys.domen.Dictionary;
import com.mall.pc.sys.domen.DictionaryExample;
import com.mall.pc.sys.service.DictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:mengchen
 * @date:2019/2/26
 * @description:
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryMapper dictionaryMapper;

    /**
     * 根据字典编码查询字典
     * @param dictCode
     * @return
     */
    @Override
    public List<HashMap> getDictListByCode(String dictCode) {
        DictionaryExample example = new DictionaryExample();
        DictionaryExample.Criteria cr = example.createCriteria();
        if (!StringUtils.isEmpty(dictCode)) {
            cr.andDictCodeEqualTo(dictCode);
        }
        example.setOrderByClause("sort asc");
        List<Dictionary> list = dictionaryMapper.selectByExample(example);
        ArrayList<HashMap> rsList = new ArrayList<HashMap>();
        for (Dictionary item : list) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("dictKey" ,item.getDictKey());
            map.put("dictValue",item.getDictValue());
            rsList.add(map);
        }
        return rsList;
    }

    /**
     * 根据字典编码及键值查询字典
     * @param dictCode
     * @param dictKey
     * @return
     */
    @Override
    public Dictionary getDictListByCodeAndKey(String dictCode, String dictKey) {
        DictionaryExample example = new DictionaryExample();
        DictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andDictCodeEqualTo(dictCode);
        criteria.andDictKeyEqualTo(dictKey);
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
        return dictionaries.get(0);
    }
}
