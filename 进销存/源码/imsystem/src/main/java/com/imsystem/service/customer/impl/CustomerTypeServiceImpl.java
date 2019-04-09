package com.imsystem.service.customer.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Customertype;
import com.imsystem.service.customer.CustomerTypeService;

@Service
@Transactional
public class CustomerTypeServiceImpl implements CustomerTypeService{

	/**
	 * 查询所有客户类型
	 */
	@Override
	public List<Customertype> queryCustomerType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增客户类型
	 */
	@Override
	public int insertCustomerType(Customertype ctObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 删除客户类型(修改状态)
	 */
	@Override
	public int deleteCustomerType(int ctId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改客户类型
	 */
	@Override
	public int updateCustomerType(Customertype ctObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据ID查询客户类型
	 */
	@Override
	public Customertype queryCustomerTypeById(int ctId) {
		// TODO Auto-generated method stub
		return null;
	}

}
