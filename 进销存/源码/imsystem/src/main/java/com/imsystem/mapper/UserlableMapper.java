package com.imsystem.mapper;

import com.imsystem.domain.Userlable;
import com.imsystem.domain.UserlableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserlableMapper {
	List<Userlable> queryAllLable();
	
	int updateLable(Userlable ulobj);
	
	int deleteLabel(String id);
	
    int countByExample(UserlableExample example);

    int deleteByExample(UserlableExample example);

    int deleteByPrimaryKey(String id);

    int insert(Userlable record);

    int insertSelective(Userlable record);

    List<Userlable> selectByExample(UserlableExample example);

    Userlable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Userlable record, @Param("example") UserlableExample example);

    int updateByExample(@Param("record") Userlable record, @Param("example") UserlableExample example);

    int updateByPrimaryKeySelective(Userlable record);

    int updateByPrimaryKey(Userlable record);
}