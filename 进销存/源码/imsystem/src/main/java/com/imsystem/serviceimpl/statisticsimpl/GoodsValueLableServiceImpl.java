package com.imsystem.serviceimpl.statisticsimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.GoodsvaluelableExample;
import com.imsystem.mapper.GoodsvaluelableMapper;
import com.imsystem.service.statistics.GoodsValueLableService;

@Service
@Transactional
public class GoodsValueLableServiceImpl implements GoodsValueLableService{

	@Autowired
	GoodsvaluelableMapper gvalm;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return gvalm.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Goodsvaluelable record) {
		// TODO Auto-generated method stub
		return gvalm.insert(record);
	}

	@Override
	public List<Goodsvaluelable> selectByExample(GoodsvaluelableExample example) {
		// TODO Auto-generated method stub
		return gvalm.selectByExample(example);
	}

	@Override
	public Goodsvaluelable selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return gvalm.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Goodsvaluelable record) {
		// TODO Auto-generated method stub
		return gvalm.updateByPrimaryKey(record);
	}

	@Override
	public List<Goodsvaluelable> querySalesGoodsValueByLable(String cid, String season) {
		// TODO Auto-generated method stub
		return gvalm.querySalesGoodsValueByLable(cid, season);
	}

	@Override
	public List<Goodsvaluelable> queryByLid(String lid, String season) {
		// TODO Auto-generated method stub
		return gvalm.queryByLid(lid, season);
	}

}
