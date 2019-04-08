package com.imsystem.mapper;

import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.GoodsvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvalueMapper {
    int countByExample(GoodsvalueExample example);

    int deleteByExample(GoodsvalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsvalue record);

    int insertSelective(Goodsvalue record);

    List<Goodsvalue> selectByExample(GoodsvalueExample example);

    Goodsvalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByExample(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByPrimaryKeySelective(Goodsvalue record);

    int updateByPrimaryKey(Goodsvalue record);
    
    List<Goodsvalue> queryByCode(@Param("code") String code);
}