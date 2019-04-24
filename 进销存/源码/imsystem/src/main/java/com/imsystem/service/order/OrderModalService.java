package com.imsystem.service.order;

import java.util.List;
import java.util.Vector;

import com.imsystem.domain.Salesback;
import com.imsystem.domain.Salesbackdetails;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Salesorderdetails;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;

public interface OrderModalService {

	Stock queryIndex(String code);
	
	Vector<Salesorderdetails> salesOrderDetails(String id);
	
	Vector<Salesdetails> orderOver(String id);
	
	List<Salesbackdetails> orderDescQuery(String id);
	
}
