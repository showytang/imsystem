package com.imsystem.service.setup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Sales;
import com.imsystem.mapper.SalesMapper;
import com.imsystem.service.setup.c_SalesService;

@Service
@Transactional
public class c_SalesServiceImpl implements c_SalesService{

	@Autowired
	SalesMapper salesMapper;
	
	@Override
	public Sales ChaXunJinRiZongE(String id) {
		
		return salesMapper.ChaXunJinRiZongE(id);
	}

}
