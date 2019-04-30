package com.imsystem.mapper;

import com.imsystem.domain.Userandlable;
import com.imsystem.domain.UserandlableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserandlableMapper {
    int countByExample(UserandlableExample example);

    int deleteByExample(UserandlableExample example);

    int deleteByPrimaryKey(String id);

    int insert(Userandlable record);

    int insertSelective(Userandlable record);

    List<Userandlable> selectByExample(UserandlableExample example);

    Userandlable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Userandlable record, @Param("example") UserandlableExample example);

    int updateByExample(@Param("record") Userandlable record, @Param("example") UserandlableExample example);

    int updateByPrimaryKeySelective(Userandlable record);

    int updateByPrimaryKey(Userandlable record);
}