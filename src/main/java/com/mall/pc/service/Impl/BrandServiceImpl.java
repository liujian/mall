package com.mall.pc.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.pc.dao.BrandMapper;
import com.mall.pc.domen.Brand;
import com.mall.pc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 13:49
 **/
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public BasicData queryBrandlist() {

        List<Brand> list = brandMapper.queryBrandlist();
        return BasicData.CreateSucess(list);
    }

    @Override
    public BasicData queryBrandrById(Integer id) {

        Brand brand = brandMapper.queryBrandrById(id);

        return BasicData.CreateSucess(brand);
    }

    @Override
    public BasicData insertBrand(Brand brand) {

        brandMapper.insertBrand(brand);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
        return BasicData.CreateSucess();
    }

    @Override
    public BasicData delBrand(Integer id) {
        brandMapper.delBrand(id);
        return BasicData.CreateSucess();
    }
}

