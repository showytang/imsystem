package com.imsystem.mapper;

import com.imsystem.domain.Khshortmessage;
import com.imsystem.domain.KhshortmessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KhshortmessageMapper {
	
	List<Khshortmessage> queryAllkh();
	
    int countByExample(KhshortmessageExample example);

    int deleteByExample(KhshortmessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Khshortmessage record);

    int insertSelective(Khshortmessage record);

    List<Khshortmessage> selectByExample(KhshortmessageExample example);

    Khshortmessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Khshortmessage record, @Param("example") KhshortmessageExample example);

    int updateByExample(@Param("record") Khshortmessage record, @Param("example") KhshortmessageExample example);

    int updateByPrimaryKeySelective(Khshortmessage record);

    int updateByPrimaryKey(Khshortmessage record);
}