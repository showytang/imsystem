package com.imsystem.service.monomer;

import java.util.List;



import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Standard;
import com.imsystem.domain.Standardvalue;

public interface StandardvalueService {

	
	public List<Standardvalue> queryStandardvalue(String tiaojian);
	
	public PageInfo<Standardvalue> queryByLikepage(String tiaojian, Integer currentPage, Integer pageSize);
	
	public int updatedelete(String id);
    
	public int insertStandardvalue(Standardvalue stan);
    
	public int toupdate(Standardvalue stan);
    
	public Standardvalue StandardvalueById(String id);
	
	public Standardvalue queryByname(String name,String sid);
	
}
