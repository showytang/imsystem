package com.imsystem.mapper;

import com.imsystem.domain.Stockrecord;
import com.imsystem.domain.StockrecordExample;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.annotations.Param;

public interface StockrecordMapper {
	
	Vector<Stockrecord> queryAllotDetails(String id);
	
	Vector<Stockrecord> query(@Param("time")String time,@Param("endTime")String endTime,@Param("code")String code,@Param("jcode")String jcode);
	
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