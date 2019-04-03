package com.imsystem.service.xl;

import java.util.List;

import com.imsystem.domain.Bit;
import com.imsystem.domain.BitExample;

public interface BitService {
	
	 public int deleteByPrimaryKey(String id);

	 public int insert(Bit record);
	 public List<Bit> selectByExample();
	 public int updateByPrimaryKey(Bit record);
}
