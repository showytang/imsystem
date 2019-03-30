package com.imsystem.mapper;

import com.imsystem.domain.Standard;
import com.imsystem.domain.StandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StandardMapper {
    int countByExample(StandardExample example);

    int deleteByExample(StandardExample example);

    int deleteByPrimaryKey(String id);

    int insert(Standard record);

    int insertSelective(Standard record);

    List<Standard> selectByExample(StandardExample example);

    Standard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByExample(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}