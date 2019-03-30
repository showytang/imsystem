package com.imsystem.mapper;

import com.imsystem.domain.Salesorderdetails;
import com.imsystem.domain.SalesorderdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesorderdetailsMapper {
    int countByExample(SalesorderdetailsExample example);

    int deleteByExample(SalesorderdetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Salesorderdetails record);

    int insertSelective(Salesorderdetails record);

    List<Salesorderdetails> selectByExample(SalesorderdetailsExample example);

    Salesorderdetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Salesorderdetails record, @Param("example") SalesorderdetailsExample example);

    int updateByExample(@Param("record") Salesorderdetails record, @Param("example") SalesorderdetailsExample example);

    int updateByPrimaryKeySelective(Salesorderdetails record);

    int updateByPrimaryKey(Salesorderdetails record);
}