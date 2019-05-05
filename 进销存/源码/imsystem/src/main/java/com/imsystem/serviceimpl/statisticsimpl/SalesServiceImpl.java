package com.imsystem.serviceimpl.statisticsimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Sales;
import com.imsystem.mapper.SalesMapper;
import com.imsystem.service.statistics.SalesService;

@Service
@Transactional
public class SalesServiceImpl implements SalesService{

	
	@Autowired
	SalesMapper sm;
	
	@Override
	public List<Sales> queryShouZhang(String cid, String startTime, String endTime ,String storeid) {
		// TODO Auto-generated method stub
		return sm.queryShouZhang(cid, startTime, endTime,storeid);
	}

	@Override
	public List<Sales> queryXf(String sid, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return sm.queryXf(sid, startTime, endTime);
	}

}
