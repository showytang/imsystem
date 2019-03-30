package com.imsystem.mapper;

import com.imsystem.domain.Salesback;
import com.imsystem.domain.SalesbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesbackMapper {
    int countByExample(SalesbackExample example);

    int deleteByExample(SalesbackExample example);

    int deleteByPrimaryKey(String id);

    int insert(Salesback record);

    int insertSelective(Salesback record);

    List<Salesback> selectByExample(SalesbackExample example);

    Salesback selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Salesback record, @Param("example") SalesbackExample example);

    int updateByExample(@Param("record") Salesback record, @Param("example") SalesbackExample example);

    int updateByPrimaryKeySelective(Salesback record);

    int updateByPrimaryKey(Salesback record);
}