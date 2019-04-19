package com.imsystem.service.monomer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Paytype;


public interface paytypeService {
	public List<Paytype> queryPaytype(String tiaojian);
	public PageInfo<Paytype> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize);

    
	public int updatedelete(String id);
	    
	public int insertPaytype(Paytype paytype);
	    
	public int toupdate(Paytype paytype);
	    
	public Paytype paytypeById(String id);
}
