package com.imsystem.mapper;

import com.imsystem.domain.Userlableandgoodsvalue;
import com.imsystem.domain.UserlableandgoodsvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserlableandgoodsvalueMapper {
    int countByExample(UserlableandgoodsvalueExample example);

    int deleteByExample(UserlableandgoodsvalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Userlableandgoodsvalue record);

    int insertSelective(Userlableandgoodsvalue record);

    List<Userlableandgoodsvalue> selectByExample(UserlableandgoodsvalueExample example);

    Userlableandgoodsvalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Userlableandgoodsvalue record, @Param("example") UserlableandgoodsvalueExample example);

    int updateByExample(@Param("record") Userlableandgoodsvalue record, @Param("example") UserlableandgoodsvalueExample example);

    int updateByPrimaryKeySelective(Userlableandgoodsvalue record);

    int updateByPrimaryKey(Userlableandgoodsvalue record);
}