package com.imsystem.service.setup.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Log;
import com.imsystem.domain.Rolemodule;
import com.imsystem.mapper.LogMapper;
import com.imsystem.service.setup.logService;


@Service
@Transactional
public class logServiceImpl implements logService{

	@Autowired
	LogMapper logMapper;
		
	@Override
	public List<Log> queryRiZhi() {
		
		return logMapper.queryRiZhi();
		
	}

	@Override
	public int XinZengLog(String userid, String content) {
		return logMapper.XinZengLog(userid, content);
	}

	

	
	
}
