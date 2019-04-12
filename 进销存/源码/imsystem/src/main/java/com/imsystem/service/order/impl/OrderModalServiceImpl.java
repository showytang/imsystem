package com.imsystem.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.mapper.StockMapper;
import com.imsystem.mapper.StockdetailsMapper;
import com.imsystem.service.order.OrderModalService;

@Service
@Transactional
public class OrderModalServiceImpl implements OrderModalService {

	@Autowired
	StockdetailsMapper stockdetailsmapper;
	
	@Autowired
	StockMapper stockmapper;
	
	@Override
	public Stock queryIndex(String code) {
		
		return stockmapper.querydetails(code);
	}

}
