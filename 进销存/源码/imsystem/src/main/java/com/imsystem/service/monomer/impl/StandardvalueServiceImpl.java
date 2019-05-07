package com.imsystem.service.monomer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Standard;
import com.imsystem.domain.Standardvalue;
import com.imsystem.mapper.StandardvalueMapper;
import com.imsystem.service.monomer.StandardvalueService;

@Service
@Transactional
public class StandardvalueServiceImpl implements StandardvalueService{
	@Autowired
	StandardvalueMapper mapper;
	@Override
	public List<Standardvalue> queryStandardvalue(String tiaojian) {
		
		return mapper.queryStandardvalue(tiaojian);
	}

	@Override
	public PageInfo<Standardvalue> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize) {
		Page<Standardvalue> page=PageHelper.startPage(currentPage, pageSize, true);
		List<Standardvalue> list=mapper.queryStandardvalue(tiaojian);
		
		return page.toPageInfo();
	}

	@Override
	public int updatedelete(String id) {
		
		return mapper.updatedelete(id);
	}

	@Override
	public int insertStandardvalue(Standardvalue stan) {
		
		return mapper.insertStandardvalue(stan);
	}

	@Override
	public int toupdate(Standardvalue stan) {
		
		return mapper.toupdate(stan);
	}

	@Override
	public Standardvalue StandardvalueById(String id) {
		
		return mapper.StandardvalueById(id);
	}

	@Override
	public Standardvalue queryByname(String name, String sid) {
		
		return mapper.queryByname(name, sid);
	}

	@Override
	public List<Standard> querytid(String tid) {
		
		return mapper.querytid(tid);
	}

	

}
