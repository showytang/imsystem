package com.imsystem.mapper;

import com.imsystem.domain.Customergroup;
import com.imsystem.domain.CustomergroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomergroupMapper {
    int countByExample(CustomergroupExample example);

    int deleteByExample(CustomergroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(Customergroup record);

    int insertSelective(Customergroup record);

    List<Customergroup> selectByExample(CustomergroupExample example);

    Customergroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Customergroup record, @Param("example") CustomergroupExample example);

    int updateByExample(@Param("record") Customergroup record, @Param("example") CustomergroupExample example);

    int updateByPrimaryKeySelective(Customergroup record);

    int updateByPrimaryKey(Customergroup record);
}