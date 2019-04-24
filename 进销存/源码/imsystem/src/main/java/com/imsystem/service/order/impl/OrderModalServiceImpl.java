package com.imsystem.service.order.impl;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Salesback;
import com.imsystem.domain.Salesbackdetails;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Salesorderdetails;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.mapper.SalesbackdetailsMapper;
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
	
	@Autowired
	SalesdetailsMapper salesMap;
	
	@Autowired
	SalesbackdetailsMapper salesbackMap;
	
	@Override
	public Stock queryIndex(String code) {
		
		return stockmapper.querydetails(code);
	}

	@Override
	public Vector<Salesorderdetails> salesOrderDetails(String id) {
		// TODO Auto-generated method stub
		
		return salesdetailsmap.salesOrderDetails(id);
	}

	@Override
	public Vector<Salesdetails> orderOver(String id) {
		// TODO Auto-generated method stub
		return salesMap.queryDetails(id);
	}

	@Override
	public List<Salesbackdetails> orderDescQuery(String id) {
		// TODO Auto-generated method stub
		return salesbackMap.query(id);
	}

}
