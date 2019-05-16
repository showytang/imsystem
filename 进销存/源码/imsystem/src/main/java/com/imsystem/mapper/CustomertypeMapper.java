package com.imsystem.mapper;

import com.imsystem.domain.Customertype;
import com.imsystem.domain.CustomertypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomertypeMapper {

	int updateDefaultType(String ctId);
	
	List<Customertype> queryCustomerType();
	
	int updateCustomerType(Customertype ctObj);

	int queryCustomerByCTid(String id);
	
	int deleteCustomerType(String ctId);
	
	List<Customertype> queryLikeCustomerType(String content);

	
    int countByExample(CustomertypeExample example);

    int deleteByExample(CustomertypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Customertype record);

    int insertSelective(Customertype record);

    List<Customertype> selectByExample(CustomertypeExample example);

    Customertype selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Customertype record, @Param("example") CustomertypeExample example);

    int updateByExample(@Param("record") Customertype record, @Param("example") CustomertypeExample example);

    int updateByPrimaryKeySelective(Customertype record);

    int updateByPrimaryKey(Customertype record);
}