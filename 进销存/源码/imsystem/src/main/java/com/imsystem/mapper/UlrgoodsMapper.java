package com.imsystem.mapper;

import com.imsystem.domain.Ulrgoods;
import com.imsystem.domain.UlrgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UlrgoodsMapper {
    int countByExample(UlrgoodsExample example);

    int deleteByExample(UlrgoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Ulrgoods record);

    int insertSelective(Ulrgoods record);

    List<Ulrgoods> selectByExample(UlrgoodsExample example);

    Ulrgoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Ulrgoods record, @Param("example") UlrgoodsExample example);

    int updateByExample(@Param("record") Ulrgoods record, @Param("example") UlrgoodsExample example);

    int updateByPrimaryKeySelective(Ulrgoods record);

    int updateByPrimaryKey(Ulrgoods record);
}