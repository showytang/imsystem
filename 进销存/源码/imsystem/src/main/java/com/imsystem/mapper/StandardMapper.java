package com.imsystem.mapper;

import com.imsystem.domain.Standard;
import com.imsystem.domain.StandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StandardMapper {
	
	List<Standard> queryStandardById(String id);
	/**
	 * 戴文诗引用
	 * @param id
	 * @return
	 */
	List<Standard> dwsqueryStandardById(String id);
	
    int countByExample(StandardExample example);

    int deleteByExample(StandardExample example);

    int deleteByPrimaryKey(String id);

    int insert(Standard record);

    int insertSelective(Standard record);

    List<Standard> selectByExample(StandardExample example);

    Standard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByExample(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
    
    List<Standard> queryStandard(@Param("tiaojian")String tiaojian);
    
    int updatedelete(String id);
    
    int insertStandard(Standard stan);
    
    int toupdate(Standard stan);
    
    Standard StandardById(String id);
}