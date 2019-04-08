package com.imsystem.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Stock;
import com.imsystem.mapper.StockMapper;
import com.imsystem.service.order.OrderQueryService;

@Service
@Transactional
public class OrderQueryServiceImpl implements OrderQueryService {

	@Autowired
	StockMapper stockMapper;
	
	@Override
	public PageInfo<Stock> queryStock(String code,String time,String endTime,Integer currentPage,Integer pageSize) {
		// TODO Auto-generated method stub
		
		Page<Stock> page = PageHelper.startPage(currentPage, pageSize, true);
		
		stockMapper.query(code, time, endTime);
		
		return page.toPageInfo();
	}

	
}
