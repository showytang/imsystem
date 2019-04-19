package com.imsystem.mapper;

import com.imsystem.domain.Sales;
import com.imsystem.domain.SalesExample;
import com.imsystem.domain.Stock;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesMapper {
	
	List<Sales> query(@Param("code") String code,@Param("time") String time,@Param("endTime") String endTime);
	
    int countByExample(SalesExample example);

    int deleteByExample(SalesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sales record);

    int insertSelective(Sales record);

    List<Sales> selectByExample(SalesExample example);

    Sales selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByExample(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
}