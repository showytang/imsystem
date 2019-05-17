package com.imsystem.service.order;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.RequestBody;

import com.imsystem.domain.Paytype;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;

public interface OrderInsertService {

	public int insert(Stock stock);
	
	public int insertOut(Sales sales);
	
	public int insertSalesorder(Salesorder salesorder);
	
	public int updateInsertOrder(Stock stock);
	
	public int allot(Vector<Stockdetails> stockdetail);
	
	Boolean insertOrderOut(Salesorder sales);
	
	int inserorderDesc(Vector<Salesdetails> salesdetails);
	
	int UpdateSalesOrder(@RequestBody Salesorder sales);
	
	List<Paytype> queryPaytype();
	
	int salesorderDel(String id,String cid,Double Moeny);
	
}
