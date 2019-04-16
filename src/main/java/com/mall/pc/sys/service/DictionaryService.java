package com.mall.pc.sys.service;

import com.mall.pc.sys.domen.Dictionary;

import java.util.HashMap;
import java.util.List;

public interface DictionaryService {
    /**
     * 根据字典编码查询字典
     * @param dictCode
     * @return
     */
    List<HashMap> getDictListByCode(String dictCode);

    /**
     * 根据字典编码及键值查询字典
     * @param dictCode
     * @param dictKey
     * @return
     */
    Dictionary getDictListByCodeAndKey(String dictCode, String dictKey);
}
