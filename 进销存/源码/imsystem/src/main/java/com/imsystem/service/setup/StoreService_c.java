package com.imsystem.service.setup;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Store;
import com.imsystem.domain.User;

public interface StoreService_c {

	 List<Store> queryStoreAll();
	 
	 PageInfo<Store> queryByPage(Store store,Integer pageNum,Integer pageSize);
	 
	 int  deleteStoreById(@Param("state")Integer state,@Param("id") String id);
	    
	 int deleteAll(Integer [] ids);
	 
	 int insertStore(Store store);
	 
	 Store SelectZongDian();
	 
	 
	 int updateByPrimaryKey(Store record);
	 
	 
	 Store selectByPrimaryKey(String id);
}
