package com.imsystem.service.order.impl;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesback;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.SalesorderExample;
import com.imsystem.domain.SalesorderExample.Criteria;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Stockrecord;
import com.imsystem.domain.Store;
import com.imsystem.mapper.SalesMapper;
import com.imsystem.mapper.SalesbackMapper;
import com.imsystem.mapper.SalesorderMapper;
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
	
	@Autowired
	SalesorderMapper salesorderMapper;
	
	@Autowired
	SalesMapper salesMapper;
	
	@Autowired
	SalesbackMapper backMap;
	
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
		return stockDetail.queryGoods(name,"1");
	}

	@Override
	public Vector<Stockdetails> queryDetails(String gvid) {
		// TODO Auto-generated method stub
		return stockDetail.queryDetails(gvid,"1");
	}

	@Override
	public PageInfo<Salesorder> querySalesOrder(Salesorder sales) {
		// TODO Auto-generated method stub
		
		if(sales.getColumn5() == null || sales.getColumn5() == "") {
			
			sales.setColumn5("1");
			
		}
		
		Page<Salesorder> page = PageHelper.startPage(Integer.parseInt(sales.getColumn5()),10, true);
		
		salesorderMapper.querySalesOrder(sales);
		
		return page.toPageInfo();
	}

	@Override
	public Salesorder salesOrderById(String id) {
		// TODO Auto-generated method stub
		/*SalesorderExample example = new SalesorderExample();
		
		Criteria cir = example.createCriteria();
		
		cir.andIdEqualTo(id);*/
		
		return salesorderMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Sales> OrderOver(String code, String endTime, String time, Integer currentPage) {
		// TODO Auto-generated method stub
		if(currentPage == null || currentPage <= 0 ) {
			currentPage = 1;
		}
		
		Page<Sales> page = PageHelper.startPage(currentPage, 10, true);
		
		salesMapper.query(code, time, endTime);
		
		return page.toPageInfo();
	}

	@Override
	public PageInfo<Salesback> orderDescQuery(Salesback back) {
		// TODO Auto-generated method stub
		
		if(back.getColumn1() == null || back.getColumn1() == "" ) {
			back.setColumn1("1");
		}
		
		Page<Salesback> page = PageHelper.startPage(Integer.parseInt(back.getColumn1()), 10, true);

		backMap.orderDescQuery(back);
		
		return page.toPageInfo();
	}

	
}
