package com.imsystem.service.order;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;

public interface OrderInsertService {

	public int insert(Stock stock);
	
	public int insertOut(Sales sales);
	
	public int insertSalesorder(Salesorder salesorder);
	
}
