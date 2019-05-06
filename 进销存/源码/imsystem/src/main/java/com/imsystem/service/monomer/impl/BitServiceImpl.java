package com.imsystem.service.monomer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Bit;
import com.imsystem.domain.BitExample;
import com.imsystem.domain.Stock;
import com.imsystem.mapper.BitMapper;
import com.imsystem.service.monomer.BitService;

@Service
@Transactional
public class BitServiceImpl implements BitService {
	
	@Autowired
	BitMapper ma;

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return ma.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Bit record) {
		
		return ma.insert(record);
	}

	@Override
	public List<Bit> queryall() {
		return ma.queryall();
	}

	@Override
	public int updateByPrimaryKey(Bit record) {
		
		return ma.updateByPrimaryKey(record);
	}

	@Override
	public int updatestate(String id) {
		
		return ma.updatestate(id);
	}

	@Override
	public int insertSelective(Bit bi) {
		
		return ma.insertSelective(bi);
	}

	@Override
	public PageInfo<Bit> querybit(Integer currentPage, Integer pageSize) {
		
		Page<Bit> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Bit> list=ma.queryall();
		return page.toPageInfo();
	}
	
	@Override
	public PageInfo<Bit> queryByLikepage(String text,Integer currentPage, Integer pageSize) {
		
		PageHelper.startPage(currentPage,pageSize);
		
		List<Bit> list=ma.queryByLike(text);
		return new PageInfo<>(list);
	}

	@Override
	public List<Bit> queryByLike(String text) {
		
		return ma.queryByLike(text);
	}

	@Override
	public Bit querybyid(String id) {
		
		return ma.querybyid(id);
	}

	@Override
	public int toupdate(Bit bit) {
		
		return ma.toupdate(bit);
	}

	@Override
	public Bit querybyname(String name) {
		
		return ma.querybyname(name);
	}

	
	
}
