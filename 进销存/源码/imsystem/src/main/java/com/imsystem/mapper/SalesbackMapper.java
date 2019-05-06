package com.imsystem.mapper;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Salesback;
import com.imsystem.domain.SalesbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesbackMapper {
	
	double shappingprice(@Param("id")String id,@Param("cid")String cid);
	
	List<Salesback> orderDescQuery(Salesback back);
	
	int add(Salesback sales);
	
    int countByExample(SalesbackExample example);

    int deleteByExample(SalesbackExample example);

    int deleteByPrimaryKey(String id);

    int insert(Salesback record);

    int insertSelective(Salesback record);

    List<Salesback> selectByExample(SalesbackExample example);

    Salesback selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Salesback record, @Param("example") SalesbackExample example);

    int updateByExample(@Param("record") Salesback record, @Param("example") SalesbackExample example);

    int updateByPrimaryKeySelective(Salesback record);

    int updateByPrimaryKey(Salesback record);
}