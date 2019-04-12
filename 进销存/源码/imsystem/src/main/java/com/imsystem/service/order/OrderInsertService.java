package com.imsystem.service.order;

import java.util.List;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;

public interface OrderInsertService {

	public int insert(Stock stock);
	
	public int insertOut(Sales sales);
	
	public int insertSalesorder(Salesorder salesorder);
	
	public int updateInsertOrder(Stock stock);
	
	public int allot(Stock stock);
	
}
