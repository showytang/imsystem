package com.imsystem.service.xl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Bit;
import com.imsystem.domain.BitExample;
import com.imsystem.mapper.BitMapper;
import com.imsystem.service.xl.BitService;

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
	public int updatestate(int id) {
		
		return ma.updatestate(id);
	}
}
