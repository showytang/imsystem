package com.imsystem.service.monomer;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.imsystem.domain.Standard;

public interface GoodsStandardService {
	public int updatedelete(String id);
	
	public List<Standard> queryStandard(String tiaojiann);
	public PageInfo<Standard> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize);
	public int insertStandard(Standard stan);

	public int toupdate(Standard stan);
	public Standard StandardById(String id);
	
}
