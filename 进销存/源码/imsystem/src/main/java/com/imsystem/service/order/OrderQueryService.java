package com.imsystem.service.order;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Stock;

public interface OrderQueryService {

	PageInfo<Stock> queryStock(String code,String time,String endTime,Integer currentPage,Integer pageSize,String order);
	
}
