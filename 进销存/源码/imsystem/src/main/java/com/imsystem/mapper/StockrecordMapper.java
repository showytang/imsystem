package com.imsystem.mapper;

import com.imsystem.domain.Stockrecord;
import com.imsystem.domain.StockrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockrecordMapper {
    int countByExample(StockrecordExample example);

    int deleteByExample(StockrecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(Stockrecord record);

    int insertSelective(Stockrecord record);

    List<Stockrecord> selectByExample(StockrecordExample example);

    Stockrecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Stockrecord record, @Param("example") StockrecordExample example);

    int updateByExample(@Param("record") Stockrecord record, @Param("example") StockrecordExample example);

    int updateByPrimaryKeySelective(Stockrecord record);

    int updateByPrimaryKey(Stockrecord record);
}