package com.imsystem.mapper;

import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.SalesdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesdetailsMapper {
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