package com.imsystem.service.order.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.mapper.SalesMapper;
import com.imsystem.mapper.SalesdetailsMapper;
import com.imsystem.mapper.SalesorderMapper;
import com.imsystem.mapper.SalesorderdetailsMapper;
import com.imsystem.mapper.StockMapper;
import com.imsystem.mapper.StockdetailsMapper;
import com.imsystem.service.order.OrderInsertService;

@Service
@Transactional
public class OrderInsertServiceImpl implements OrderInsertService{

	@Autowired
	StockMapper stockM;
	
	@Autowired
	StockdetailsMapper stockdetail;
	
	@Autowired
	SalesMapper salesMapper;
	
	@Autowired
	SalesdetailsMapper salesdetailsMapper;
	
	@Autowired
	SalesorderMapper salesorderMapper;
	
	@Autowired
	SalesorderdetailsMapper salesorderdetailsMapper;
	
	@Override
	public int insert(Stock stock) {
		
		stock.setId("");
		
		int count = stockM.insertSelective(stock);
		
		count += stockdetail.add(stock);
		
		return count;
	}



	@Override
	public int insertOut(Sales sales) {

		sales.setId(UUID.randomUUID().toString());
		
		int count = salesMapper.insertSelective(sales);
		
		count += salesdetailsMapper.add(sales);
		
		return count;
	}



	@Override
	public int insertSalesorder(Salesorder salesorder) {
		// TODO Auto-generated method stub
		salesorder.setId(UUID.randomUUID().toString());
		
		int count = salesorderMapper.insertSelective(salesorder);
		
		count += salesorderdetailsMapper.add(salesorder);
		
		return count;
	}



	@Override
	public int updateInsertOrder(Stock stock) {
		// TODO Auto-generated method stub
		
		int count = stockdetail.del(stock.getCode());
		
		count += stockdetail.add(stock);
		
		return count;
	}



	@Override
	public int allot(Stock stock) {
		// TODO Auto-generated method stub
		
		
		return 0;
	}
	
}
