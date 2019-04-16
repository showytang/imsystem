package com.imsystem.service.order;

import java.util.List;
import java.util.Vector;

import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;

public interface OrderModalService {

	Stock queryIndex(String code);
	
	Vector<Salesdetails> salesOrderDetails(String id);
	
}
