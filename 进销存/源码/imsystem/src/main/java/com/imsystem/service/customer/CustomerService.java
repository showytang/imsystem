package com.imsystem.service.customer;

import java.util.List;

import com.github.pagehelper.PageInfo;
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
	public Customer queryCustomerById(String cusId);
	
	/**
	 * 分页查询客户
	 * @param zero 是否查看0欠款
	 * @param content 模糊查内容
	 * @param curentPage 当前页
	 * @return
	 */
	public PageInfo<Customer> queryCustomerList(Double zero,String content,Integer curentPage);
	
	/**
	 * 删除客户（改变状态）
	 * @param id
	 * @return
	 */
	public int deleteCustomer(String id);

}
