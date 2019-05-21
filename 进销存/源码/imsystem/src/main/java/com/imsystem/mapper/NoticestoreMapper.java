package com.imsystem.mapper;

import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.Noticestore;
import com.imsystem.domain.NoticestoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticestoreMapper {
	List<Noticestore> queryMyNotice(@Param("content") String content, @Param("uid") String uid);
	
	int updateState(String id);
	
	int queryNotReadNewsNum(String uid);
	
	
    int countByExample(NoticestoreExample example);

    int deleteByExample(NoticestoreExample example);

    int deleteByPrimaryKey(String id);

    int insertns(Noticestore record);

    int insertSelective(Noticestore record);

    List<Noticestore> selectByExample(NoticestoreExample example);

    Noticestore selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Noticestore record, @Param("example") NoticestoreExample example);

    int updateByExample(@Param("record") Noticestore record, @Param("example") NoticestoreExample example);

    int updateByPrimaryKeySelective(Noticestore record);

    int updateByPrimaryKey(Noticestore record);
}