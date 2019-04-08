package com.imsystem.serviceimpl.statisticsimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Store;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.service.statistics.StoreService;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	@Autowired
	StoreMapper sm;
	
	@Override
	public Store selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(id);
	}

}
