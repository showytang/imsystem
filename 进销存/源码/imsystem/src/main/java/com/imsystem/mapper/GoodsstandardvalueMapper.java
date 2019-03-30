package com.imsystem.mapper;

import com.imsystem.domain.Goodsstandardvalue;
import com.imsystem.domain.GoodsstandardvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsstandardvalueMapper {
    int countByExample(GoodsstandardvalueExample example);

    int deleteByExample(GoodsstandardvalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsstandardvalue record);

    int insertSelective(Goodsstandardvalue record);

    List<Goodsstandardvalue> selectByExample(GoodsstandardvalueExample example);

    Goodsstandardvalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsstandardvalue record, @Param("example") GoodsstandardvalueExample example);

    int updateByExample(@Param("record") Goodsstandardvalue record, @Param("example") GoodsstandardvalueExample example);

    int updateByPrimaryKeySelective(Goodsstandardvalue record);

    int updateByPrimaryKey(Goodsstandardvalue record);
}