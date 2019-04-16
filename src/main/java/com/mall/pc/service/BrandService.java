package com.mall.pc.service;

import com.mall.common.param.BasicData;
import com.mall.pc.domen.Brand;

public interface BrandService {

    BasicData queryBrandlist();

    BasicData queryBrandrById(Integer id);

    BasicData insertBrand(Brand brand);

    BasicData updateBrand(Brand brand);

    BasicData delBrand(Integer id);


}
