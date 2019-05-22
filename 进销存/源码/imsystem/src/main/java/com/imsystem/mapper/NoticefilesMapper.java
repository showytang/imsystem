package com.imsystem.mapper;

import com.imsystem.domain.Noticefiles;
import com.imsystem.domain.NoticefilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticefilesMapper {
	List<Noticefiles> queryFilesByNid(String nid);
	
	
    int countByExample(NoticefilesExample example);

    int deleteByExample(NoticefilesExample example);

    int deleteByPrimaryKey(String id);

    int insertnf(Noticefiles record);

    int insertSelective(Noticefiles record);

    List<Noticefiles> selectByExample(NoticefilesExample example);

    Noticefiles selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Noticefiles record, @Param("example") NoticefilesExample example);

    int updateByExample(@Param("record") Noticefiles record, @Param("example") NoticefilesExample example);

    int updateByPrimaryKeySelective(Noticefiles record);

    int updateByPrimaryKey(Noticefiles record);
}