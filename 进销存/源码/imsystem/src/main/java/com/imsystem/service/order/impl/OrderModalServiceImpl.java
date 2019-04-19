package com.imsystem.service.order.impl;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.mapper.SalesdetailsMapper;
import com.imsystem.mapper.SalesorderdetailsMapper;
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
	
	@Autowired
	SalesorderdetailsMapper salesdetailsmap;
	
	@Override
	public Stock queryIndex(String code) {
		
		return stockmapper.querydetails(code);
	}

	@Override
	public Vector<Salesdetails> salesOrderDetails(String id) {
		// TODO Auto-generated method stub
		
		return salesdetailsmap.salesOrderDetails(id);
	}

}
