package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Store;
import com.imsystem.domain.User;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.service.setup.StoreService_c;

@Service
@Transactional
public class StoreServiceImpl_c implements StoreService_c{
	
	
	@Autowired
	StoreMapper storeMapper;
	
	
	@Override
	public List<Store> queryStoreAll() {
		return storeMapper.queryStoreAll();
	}


	@Override
	public PageInfo<Store> queryByPage(Store store, Integer pageNum, Integer pageSize) {
		Page<Store> page=PageHelper.startPage(pageNum, pageSize,true);
		storeMapper.SelectStoreAll(store.getName());
		return page.toPageInfo();
	}


	@Override
	public int deleteStoreById(Integer state, String id) {
		
		return storeMapper.deleteStoreById(state, id);
	}


	@Override
	public int deleteAll(Integer[] ids) {
		
		return storeMapper.deleteAll(ids);
	}


	@Override
	public int insertStore(Store store) {
		
		return storeMapper.insertStore(store);
		
	}


	@Override
	public Store SelectZongDian() {
		return storeMapper.SelectZongDian();
	}


	@Override
	public int updateByPrimaryKey(Store record) {
		// TODO Auto-generated method stub
		return storeMapper.updateByPrimaryKey(record);
	}


	@Override
	public Store selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return storeMapper.selectByPrimaryKey(id);
	}
	
		

}
