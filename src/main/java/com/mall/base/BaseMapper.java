package com.mall.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<Entity,Example> {

	/**
	 * 根据示范案例获取实体数量
	 * */
	int countByExample(Example example);
	/**
	 * 根据示范案例删除实体
	 * */
	int deleteByExample(Example example);
	/**
	 * 根据主键删除实体
	 * */
	int deleteByPrimaryKey(Integer id);
	/**
	 * 添加实体(空的字段在数据库中置为NULL)
	 * */
	int insert(Entity record);
	/**
	 * 添加实体(只是添加M中不为空的字段)
	 * */
	int insertSelective(Entity record);
	/**
	 * 根据示范案例获取实体列表
	 * */
	List<Entity> selectByExample(Example example);
	/**
	 * 根据主键获取实体(空的字段在数据库中置为NULL)
	 * */
	Entity selectByPrimaryKey(Integer id);
	/**
	 * 根据示范案例更新实体(只是更新新的M中不为空的字段)
	 * */
	int updateByExampleSelective(@Param("record") Entity record, @Param("example") Example example);
	/**
	 * 根据示范案例更新实体
	 * */
	int updateByExample(@Param("record") Entity record, @Param("example") Example example);
	/**
	 * 根据主键更新实体(只更新不为NULL的字段)
	 * */
	int updateByPrimaryKeySelective(Entity record);
	/**
	 * 根据主键更新实体
	 * */
	int updateByPrimaryKey(Entity record);
}
