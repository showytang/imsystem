package com.imsystem.mapper;

import com.imsystem.domain.Salesbackdetails;
import com.imsystem.domain.SalesbackdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesbackdetailsMapper {
    int countByExample(SalesbackdetailsExample example);

    int deleteByExample(SalesbackdetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Salesbackdetails record);

    int insertSelective(Salesbackdetails record);

    List<Salesbackdetails> selectByExample(SalesbackdetailsExample example);

    Salesbackdetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Salesbackdetails record, @Param("example") SalesbackdetailsExample example);

    int updateByExample(@Param("record") Salesbackdetails record, @Param("example") SalesbackdetailsExample example);

    int updateByPrimaryKeySelective(Salesbackdetails record);

    int updateByPrimaryKey(Salesbackdetails record);
}