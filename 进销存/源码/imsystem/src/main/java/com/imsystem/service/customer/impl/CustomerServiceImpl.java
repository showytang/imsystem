package com.imsystem.service.customer.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Customer;
import com.imsystem.service.customer.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	/**
	 *  查询所有客户
	 */
	@Override
	public List<Customer> queryCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增客户
	 */
	@Override
	public int insertCustomer(Customer cusObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改客户
	 */
	@Override
	public int updateCustomer(Customer cusObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据ID查询客户
	 */
	@Override
	public Customer queryCustomerById(int cusId) {
		// TODO Auto-generated method stub
		return null;
	}

}
