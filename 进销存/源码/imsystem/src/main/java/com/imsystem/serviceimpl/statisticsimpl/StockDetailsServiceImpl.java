package com.imsystem.serviceimpl.statisticsimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Stockdetails;
import com.imsystem.mapper.StockdetailsMapper;
import com.imsystem.service.statistics.StockDetailsService;

@Service
@Transactional
public class StockDetailsServiceImpl implements StockDetailsService{

	@Autowired
	StockdetailsMapper sm;
	@Override
	public List<Stockdetails> queryJinHuo(String startTime, String endTime, String cid,String storeId) {
		// TODO Auto-generated method stub
		return sm.queryJinHuo(startTime, endTime, cid ,storeId);
	}
	@Override
	public List<Stockdetails> queryStockByGidAndStoreId(String gid, String storeId,String name) {
		// TODO Auto-generated method stub
		return sm.queryStockByGidAndStoreId(gid, storeId,name);
	}

}
