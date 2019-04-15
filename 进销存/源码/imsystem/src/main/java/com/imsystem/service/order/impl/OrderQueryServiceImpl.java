package com.imsystem.service.order.impl;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Stockrecord;
import com.imsystem.domain.Store;
import com.imsystem.mapper.StockMapper;
import com.imsystem.mapper.StockdetailsMapper;
import com.imsystem.mapper.StockrecordMapper;
import com.imsystem.service.order.OrderQueryService;

@Service
@Transactional
public class OrderQueryServiceImpl implements OrderQueryService {

	@Autowired
	StockMapper stockMapper;
	
	@Autowired
	StockrecordMapper stockrecord;
	
	@Autowired
	StockdetailsMapper stockDetail;
	
	@Override
	public PageInfo<Stock> queryStock(String code,String time,String endTime,Integer currentPage,Integer pageSize,String order,Integer kucun) {
		// TODO Auto-generated method stub
		
		Page<Stock> page = PageHelper.startPage(currentPage, pageSize, true);
		
		stockMapper.query(code, time, endTime,order,kucun);
		
		return page.toPageInfo();
		
	}

	@Override
	public Vector<Stockrecord> queryAllot(String time,String endTime,String code,String jcode) {
		// TODO Auto-generated method stub
		return stockrecord.query(time, endTime, code, jcode);
	}

	@Override
	public Vector<Stockrecord> queryAllotDetails(String id) {
		// TODO Auto-generated method stub
		return stockrecord.queryAllotDetails(id);
	}

	@Override
	public Vector<Stockdetails> queryGoods(String name) {
		// TODO Auto-generated method stub
		return stockDetail.queryGoods(name);
	}

	@Override
	public Vector<Stockdetails> queryDetails(String gvid) {
		// TODO Auto-generated method stub
		return stockDetail.queryDetails(gvid,"1");
	}

	
}
