package com.imsystem.service.order;

import java.util.List;

import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;

public interface OrderModalService {

	Stock queryIndex(String code);
	
}
