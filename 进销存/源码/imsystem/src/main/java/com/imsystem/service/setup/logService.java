package com.imsystem.service.setup;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Log;

public interface logService {

	List<Log>  queryRiZhi();
	
	int  XinZengLog(@Param("userid")String userid,@Param("content")String content);
	
}
