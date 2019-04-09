package com.imsystem.service.monomer;

import java.util.List;

import com.imsystem.domain.Bit;
import com.imsystem.domain.BitExample;

public interface BitService {
	
	 public int deleteByPrimaryKey(String id);
	 public int updatestate(int id);
	 public int insert(Bit record);
	 public List<Bit> queryall();
	 public int updateByPrimaryKey(Bit record);
	 
	 public int insertSelective(Bit bi);
}
