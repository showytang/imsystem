package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Store;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.service.setup.StoreService_c;

@Service
@Transactional
public class StoreServiceImpl_c implements StoreService_c{
	
	
	@Autowired
	StoreMapper storeMapper;
	
	
	@Override
	public List<Store> queryStoreAll() {
		return storeMapper.queryStoreAll();
	}

	

}
