package com.imsystem.service.order.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Salesstockrecord;
import com.imsystem.service.order.OrderInsertService;

@Service
@Transactional
public class OrderInsertServiceImpl implements OrderInsertService{

	@Override
	public int insert(Salesstockrecord salesstockrecord) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
