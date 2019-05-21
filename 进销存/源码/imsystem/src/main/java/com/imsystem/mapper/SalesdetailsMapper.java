package com.imsystem.mapper;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.SalesdetailsExample;
import com.imsystem.domain.Salesorder;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.annotations.Param;

public interface SalesdetailsMapper {
	
	Vector<Salesdetails> queryDetails(String sid);
	
	int addcode(Sales sales);
	
	Vector<Salesdetails> queryBySid(String id);
	
	int update(String id);
	
	int add(Sales sales);
	
	int selectCount(@Param("sid") String sid);
	
    int countByExample(SalesdetailsExample example);

    int deleteByExample(SalesdetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Salesdetails record);

    int insertSelective(Salesdetails record);

    List<Salesdetails> selectByExample(SalesdetailsExample example);

    Salesdetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Salesdetails record, @Param("example") SalesdetailsExample example);

    int updateByExample(@Param("record") Salesdetails record, @Param("example") SalesdetailsExample example);

    int updateByPrimaryKeySelective(Salesdetails record);

    int updateByPrimaryKey(Salesdetails record);
}