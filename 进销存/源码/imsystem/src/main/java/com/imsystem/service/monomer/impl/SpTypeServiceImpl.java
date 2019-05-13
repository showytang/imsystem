package com.imsystem.service.monomer.impl;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Bit;
import com.imsystem.domain.Goodstype;
import com.imsystem.mapper.GoodstypeMapper;
import com.imsystem.service.monomer.SpTypeService;
@Service
@Transactional
public class SpTypeServiceImpl implements SpTypeService{
	
	@Autowired
	GoodstypeMapper ma;
	
	@Override
	public List<Goodstype> querygoodstype(String tiaojian) {
		
		return ma.querygoodstype(tiaojian);
	}
	
	

	@Override
	public PageInfo<Goodstype> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize) {
		Page<Goodstype> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Goodstype> list=ma.querygoodstype(tiaojian);
		
		return page.toPageInfo();
	}



	@Override
	public int deleteupdate(String id) {
		
		return ma.deleteupdate(id);
	}



	@Override
	public int insertgoodstype(Goodstype good) {
		
		return ma.insertgoodstype(good);
	}



	@Override
	public Goodstype querybyid(String id) {
		
		return ma.querybyid(id);
	}



	@Override
	public int toupdate(Goodstype good) {
		
		return ma.toupdate(good);
	}

	@Override
	public List<Goodstype> querybypid(@Param("name")String name) {
		
		return ma.querybypid(name);
	}



	@Override
	public Goodstype querybyname(String name, String pid) {
		
		return ma.querybyname(name, pid);
	}



	@Override
	public List<Goodstype> querynoid() {
		
		return ma.querynoid();
	}



	@Override
	public int dele(String id) {
		
		return ma.dele(id);
	}



	
	

	



}
