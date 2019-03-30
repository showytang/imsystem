package com.imsystem.mapper;

import com.imsystem.domain.Standardvalue;
import com.imsystem.domain.StandardvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StandardvalueMapper {
    int countByExample(StandardvalueExample example);

    int deleteByExample(StandardvalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Standardvalue record);

    int insertSelective(Standardvalue record);

    List<Standardvalue> selectByExample(StandardvalueExample example);

    Standardvalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Standardvalue record, @Param("example") StandardvalueExample example);

    int updateByExample(@Param("record") Standardvalue record, @Param("example") StandardvalueExample example);

    int updateByPrimaryKeySelective(Standardvalue record);

    int updateByPrimaryKey(Standardvalue record);
}