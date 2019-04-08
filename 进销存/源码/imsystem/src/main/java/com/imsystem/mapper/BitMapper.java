package com.imsystem.mapper;

import com.imsystem.domain.Bit;
import com.imsystem.domain.BitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BitMapper {
    int countByExample(BitExample example);

    int deleteByExample(BitExample example);

    int deleteByPrimaryKey(String id);

    int insert(Bit record);

    int insertSelective(Bit record);

    List<Bit> queryall();
    
    int updatestate(int id);

    Bit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Bit record, @Param("example") BitExample example);

    int updateByExample(@Param("record") Bit record, @Param("example") BitExample example);

    int updateByPrimaryKeySelective(Bit record);

    int updateByPrimaryKey(Bit record);
}