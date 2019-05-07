package com.imsystem.service.order;

import java.util.List;
import java.util.Vector;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesback;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Stockrecord;

public interface OrderQueryService {

	PageInfo<Stock> queryStock(String code,String time,String endTime,Integer currentPage,Integer pageSize,String order,Integer kucun,String shappingname);
	
	Vector<Stockrecord> queryAllot(String time,String endTime,String code,String jcode);
	
	Vector<Stockrecord> queryAllotDetails(String id);
	
	Vector<Stockdetails> queryGoods(String name);
	
	Vector<Stockdetails> queryDetails(String gvid);
	
	PageInfo<Salesorder> querySalesOrder (Salesorder sales);
	
	Salesorder salesOrderById(String id);
	
	PageInfo<Sales> OrderOver(String code,String endTime,String time,Integer currentPage,String shappingname);

	PageInfo<Salesback> orderDescQuery(Salesback back);
	
	Double shappingprice(String id,String cid);
	
	List<Customer> queryCustomerByName(String name,String stoid);
	
}
