package com.imsystem.service.customer;

import java.util.List;

import com.imsystem.domain.Customer;

public interface CustomerService {
	
	/**
	 * 查询所有客户
	 * @return
	 */
	public List<Customer> queryCustomer();
	
	/**
	 * 新增客户
	 * @param cusObj 客户对象
	 * @return
	 */
	public int insertCustomer(Customer cusObj);
	
	/**
	 * 修改客户
	 * @param cusObj  客户对象
	 * @return
	 */
	public int updateCustomer(Customer cusObj);
	
	/**
	 * 根据ID查询客户
	 * @param cusId  客户id
	 * @return
	 */
	public Customer queryCustomerById(int cusId);

}
