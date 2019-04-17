package com.imsystem.serviceimpl.statisticsimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Stock;
import com.imsystem.mapper.StockMapper;
import com.imsystem.service.statistics.StockService;

@Service
@Transactional
public class StockServiceImpl implements StockService{

	@Autowired
	StockMapper sm;
	@Override
	public List<Stock> queryQianKuan(String startTime, String endTime, String sid) {
		// TODO Auto-generated method stub
		return sm.queryQianKuan(startTime, endTime, sid);
	}
	
}
