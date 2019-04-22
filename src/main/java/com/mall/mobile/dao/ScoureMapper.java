package com.mall.mobile.dao;



import com.mall.mobile.domen.Scoure;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ScoureMapper {

    List<Scoure> getScoureList(Integer userid);

    void addScoure(Scoure scoure);


}
