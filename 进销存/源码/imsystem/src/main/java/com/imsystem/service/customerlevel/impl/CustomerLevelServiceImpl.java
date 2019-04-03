package com.imsystem.service.customerlevel.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Customerlevel;
import com.imsystem.service.customerlevel.CustomerLevelService;

@Service
@Transactional
public class CustomerLevelServiceImpl implements CustomerLevelService{

	/**
	 * 查询所有客户等级
	 */
	@Override
	public List<Customerlevel> queryCustomerLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增客户等级
	 */
	@Override
	public int insertCustomerLevel(Customerlevel clObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 删除客户等级（修改状态）
	 */
	@Override
	public int deleteCustomerLevel(int clId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改客户等级
	 */
	@Override
	public int updateCustomerLevel(Customerlevel clObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据ID查询客户等级
	 */
	@Override
	public Customerlevel queryCustomerLevelById(int clId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
