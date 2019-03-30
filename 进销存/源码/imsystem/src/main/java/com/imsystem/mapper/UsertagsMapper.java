package com.imsystem.mapper;

import com.imsystem.domain.Usertags;
import com.imsystem.domain.UsertagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsertagsMapper {
    int countByExample(UsertagsExample example);

    int deleteByExample(UsertagsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Usertags record);

    int insertSelective(Usertags record);

    List<Usertags> selectByExample(UsertagsExample example);

    Usertags selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Usertags record, @Param("example") UsertagsExample example);

    int updateByExample(@Param("record") Usertags record, @Param("example") UsertagsExample example);

    int updateByPrimaryKeySelective(Usertags record);

    int updateByPrimaryKey(Usertags record);
}