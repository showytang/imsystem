package com.imsystem.service.order;

import java.util.List;

import com.imsystem.domain.Stockdetails;

public interface OrderModalService {

	List<Stockdetails> queryIndex(String code);
	
}
