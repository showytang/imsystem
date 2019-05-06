package com.imsystem.service.monomer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Goodstype;
import com.imsystem.domain.Standard;
import com.imsystem.mapper.StandardMapper;
import com.imsystem.service.monomer.GoodsStandardService;
@Service
@Transactional
public class GoodsStandardServiceImpl implements GoodsStandardService{
	@Autowired
	StandardMapper mapper;

	@Override
	public List<Standard> queryStandard(String tiaojian) {
		
		return mapper.queryStandard(tiaojian);
	}

	@Override
	public PageInfo<Standard> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize) {
		Page<Standard> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Standard> list=mapper.queryStandard(tiaojian);
		return page.toPageInfo();
		
	}

	@Override
	public int updatedelete(String id) {
		
		return mapper.updatedelete(id);
	}

	@Override
	public int insertStandard(Standard stan) {
		
		return mapper.insertStandard(stan);
	}

	

	@Override
	public int toupdate(Standard stan) {
		
		return mapper.toupdate(stan);
	}

	@Override
	public Standard StandardById(String id) {
		
		return mapper.StandardById(id);
	}

	@Override
	public Standard StandardByname(String name, String tid) {
		
		return mapper.StandardByname(name, tid);
	}
}
