package com.imsystem.serviceimpl.statisticsimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Salesorder;
import com.imsystem.mapper.BitMapper;
import com.imsystem.mapper.SalesorderMapper;
import com.imsystem.service.statistics.SalesorderService;

@Service
@Transactional
public class SalesorderServiceImpl implements SalesorderService{

	@Autowired
	SalesorderMapper sm;
	@Override
	public List<Salesorder> query(String storeid, String code, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return sm.query(storeid, code, startTime, endTime);
	}
	@Override
	public Salesorder queryFirst(String storeid, String code, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return sm.queryFirst(storeid, code, startTime, endTime);
	}
	@Override
	public List<Salesorder> queryDaysAgo(String storeid) {
		// TODO Auto-generated method stub
		return sm.queryDaysAgo(storeid);
	}
	
}
