package com.imsystem.mapper;

import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.NoticeExample;
import com.imsystem.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	List<User> queryUserBySid(NewsVo nvobj);
	
	
	
	
	
	
	
    int countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(String id);

    int insertNotice(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}