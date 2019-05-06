package com.imsystem.service.monomer;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Bit;


public interface BitService {
	
	 public int deleteByPrimaryKey(String id);
	 public int updatestate(String id);
	 public int insert(Bit record);
	 public List<Bit> queryall();
	 public int updateByPrimaryKey(Bit record);
	 public int insertSelective(Bit bi);
	 public List<Bit> queryByLike(String tiaojian);
	 public PageInfo<Bit> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize);
	 public PageInfo <Bit> querybit(Integer currentPage,Integer pageSize);
	 public Bit querybyid(String id);
	 public Bit querybyname(String name);
	 public int toupdate(Bit bit);
}
