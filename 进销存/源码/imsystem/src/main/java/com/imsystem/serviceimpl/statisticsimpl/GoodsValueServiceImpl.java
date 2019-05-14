package com.imsystem.serviceimpl.statisticsimpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Sales;
import com.imsystem.mapper.GoodsvalueMapper;
import com.imsystem.service.statistics.GoodsValueService;
@Service
@Transactional
public class GoodsValueServiceImpl implements GoodsValueService{

	@Autowired
	GoodsvalueMapper gvm;
	
	@Override
	public List<Goodsvalue> queryByCode(String code) {
		// TODO Auto-generated method stub
		return gvm.queryByCode(code);
	}

	@Override
	public List<Goodsvalue> queryGoodsByTime(String time,String startTime,String endTime,String storeId,String gid,String name) {
		// TODO Auto-generated method stub
		return gvm.queryGoodsByTime(time,startTime,endTime,storeId,gid,name);
	}

	@Override
	public List<Goodsvalue> querySalesByCid(String cid, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return gvm.querySalesByCid(cid, startTime, endTime);
	}

}
