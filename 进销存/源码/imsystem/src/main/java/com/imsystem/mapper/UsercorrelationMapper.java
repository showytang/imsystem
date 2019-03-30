package com.imsystem.mapper;

import com.imsystem.domain.Usercorrelation;
import com.imsystem.domain.UsercorrelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsercorrelationMapper {
    int countByExample(UsercorrelationExample example);

    int deleteByExample(UsercorrelationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Usercorrelation record);

    int insertSelective(Usercorrelation record);

    List<Usercorrelation> selectByExample(UsercorrelationExample example);

    Usercorrelation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Usercorrelation record, @Param("example") UsercorrelationExample example);

    int updateByExample(@Param("record") Usercorrelation record, @Param("example") UsercorrelationExample example);

    int updateByPrimaryKeySelective(Usercorrelation record);

    int updateByPrimaryKey(Usercorrelation record);
}