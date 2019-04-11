package com.imsystem.mapper;

import com.imsystem.domain.Goodstype;
import com.imsystem.domain.GoodstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstypeMapper {
    int countByExample(GoodstypeExample example);

    int deleteByExample(GoodstypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);
    
    List<Goodstype> queryall();

    List<Goodstype> selectByExample(GoodstypeExample example);

    Goodstype selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);
}