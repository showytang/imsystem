package com.imsystem.service.monomer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Paytype;
import com.imsystem.domain.Standard;
import com.imsystem.mapper.PaytypeMapper;
import com.imsystem.service.monomer.paytypeService;

@Service
@Transactional
public class paytypeServiceImpl implements paytypeService{
	@Autowired
	PaytypeMapper mapper;

	@Override
	public List<Paytype> queryPaytype(String tiaojian) {
		
		return mapper.queryPaytype(tiaojian);
	}

	@Override
	public PageInfo<Paytype> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize) {
		Page<Paytype> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Paytype> list=mapper.queryPaytype(tiaojian);
		return page.toPageInfo();
	}

	@Override
	public int updatedelete(String id) {
		
		return mapper.updatedelete(id);
	}

	@Override
	public int insertPaytype(Paytype paytype) {
		
		return mapper.insertPaytype(paytype);
	}

	@Override
	public int toupdate(Paytype paytype) {
		
		return mapper.toupdate(paytype);
	}

	@Override
	public Paytype paytypeById(String id) {
		
		return mapper.paytypeById(id);
	}
}
