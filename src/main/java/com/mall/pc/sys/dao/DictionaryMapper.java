package com.mall.pc.sys.dao;

import com.mall.base.BaseMapper;
import com.mall.pc.sys.domen.Dictionary;
import com.mall.pc.sys.domen.DictionaryExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary, DictionaryExample> {
}
