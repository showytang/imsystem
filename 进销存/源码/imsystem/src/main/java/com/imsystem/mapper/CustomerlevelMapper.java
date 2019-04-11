package com.imsystem.mapper;

import com.imsystem.domain.Customerlevel;
import com.imsystem.domain.CustomerlevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerlevelMapper {
	List<Customerlevel> queryCustomerLevel();
	
	int updateCustomerLevel(Customerlevel clObj);
	
	int deleteCustomerLevel(String id);
	
	List<Customerlevel> queryLikeCustomerLevel(String content);
	
    int countByExample(CustomerlevelExample example);

    int deleteByExample(CustomerlevelExample example);

    int deleteByPrimaryKey(String id);

    int insert(Customerlevel record);

    int insertSelective(Customerlevel record);

    List<Customerlevel> selectByExample(CustomerlevelExample example);

    Customerlevel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Customerlevel record, @Param("example") CustomerlevelExample example);

    int updateByExample(@Param("record") Customerlevel record, @Param("example") CustomerlevelExample example);

    int updateByPrimaryKeySelective(Customerlevel record);

    int updateByPrimaryKey(Customerlevel record);
}