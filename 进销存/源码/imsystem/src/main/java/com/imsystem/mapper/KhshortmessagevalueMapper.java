package com.imsystem.mapper;

import com.imsystem.domain.Khshortmessagevalue;
import com.imsystem.domain.KhshortmessagevalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KhshortmessagevalueMapper {
    int countByExample(KhshortmessagevalueExample example);

    int deleteByExample(KhshortmessagevalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Khshortmessagevalue record);

    int insertSelective(Khshortmessagevalue record);

    List<Khshortmessagevalue> selectByExample(KhshortmessagevalueExample example);

    Khshortmessagevalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Khshortmessagevalue record, @Param("example") KhshortmessagevalueExample example);

    int updateByExample(@Param("record") Khshortmessagevalue record, @Param("example") KhshortmessagevalueExample example);

    int updateByPrimaryKeySelective(Khshortmessagevalue record);

    int updateByPrimaryKey(Khshortmessagevalue record);
}