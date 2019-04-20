package com.imsystem.mapper;

import com.imsystem.domain.Salesstockrecord;
import com.imsystem.domain.SalesstockrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesstockrecordMapper {
	
	List<Salesstockrecord> querystockdetails(String id);
	
    int countByExample(SalesstockrecordExample example);

    int deleteByExample(SalesstockrecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(Salesstockrecord record);

    int insertSelective(Salesstockrecord record);

    List<Salesstockrecord> selectByExample(SalesstockrecordExample example);

    Salesstockrecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Salesstockrecord record, @Param("example") SalesstockrecordExample example);

    int updateByExample(@Param("record") Salesstockrecord record, @Param("example") SalesstockrecordExample example);

    int updateByPrimaryKeySelective(Salesstockrecord record);

    int updateByPrimaryKey(Salesstockrecord record);
}