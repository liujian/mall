package com.mall.pc.dao;

import com.mall.pc.domen.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    List<Brand> queryBrandlist();

    List<Brand> queryisHomeBrandlist();

    Brand queryBrandrById(Integer id);

    void insertBrand(Brand brand);

    void updateBrand(Brand brand);

    void delBrand(Integer id);



}
