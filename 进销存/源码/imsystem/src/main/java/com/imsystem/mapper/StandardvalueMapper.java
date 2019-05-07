package com.imsystem.mapper;

import com.imsystem.domain.Standard;
import com.imsystem.domain.Standardvalue;
import com.imsystem.domain.StandardvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.thymeleaf.standard.processor.StandardInliningCDATASectionProcessor;

public interface StandardvalueMapper {
	
	List<Standardvalue> queryStandardvalueByid(Integer id);
	
    int countByExample(StandardvalueExample example);

    int deleteByExample(StandardvalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Standardvalue record);

    int insertSelective(Standardvalue record);

    List<Standardvalue> selectByExample(StandardvalueExample example);

    Standardvalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Standardvalue record, @Param("example") StandardvalueExample example);

    int updateByExample(@Param("record") Standardvalue record, @Param("example") StandardvalueExample example);

    int updateByPrimaryKeySelective(Standardvalue record);

    int updateByPrimaryKey(Standardvalue record);
    
    
    List<Standardvalue> queryStandardvalue(@Param("tiaojian") String tiaojian);
    
    int updatedelete(String id);
    
    int insertStandardvalue(Standardvalue stan);
    
    int toupdate(Standardvalue stan);
    
    Standardvalue StandardvalueById(String id);
    
    Standardvalue queryByname(String name,String sid);
    
    List<Standard> querytid(String tid);
    
}