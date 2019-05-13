package com.imsystem.service.monomer;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.imsystem.domain.Goodstype;

public interface SpTypeService {
	
	public List<Goodstype> querygoodstype(String tiaojian);
	
	public PageInfo<Goodstype> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize);
	
	public  int deleteupdate(String id);
	
	public int insertgoodstype(Goodstype good);
	
	public Goodstype querybyid(String id);
	    
	public int toupdate(Goodstype good);
	
	public List<Goodstype> querybypid();
	
	public Goodstype querybyname(String name,String pid);
	
	public List<Goodstype> querynoid();
}
