package com.imsystem.service.customer;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.TypeLevelVO;

public interface CustomerService {
	
	/**
	 *  #查询所有客户
	 * @return
	 */
	public List<Customer> queryCustomer(String uid);
	
	/**
	 *  #新增客户
	 * @param cusObj 客户对象
	 * @return
	 */
	public int insertCustomer(Customer cusObj);
	
	/**
	 *  #修改客户
	 * @param cusObj  客户对象
	 * @return
	 */
	public int updateCustomer(Customer cusObj);
	
	/**
	 *  #根据ID查询客户
	 * @param cusId  客户id
	 * @return
	 */
	public Customer queryCustomerById(String cusId);
	
	/**
	 *  #分页查询客户
	 * @param zero 是否查看0欠款
	 * @param content 模糊查内容
	 * @param curentPage 当前页
	 * @return
	 */
	public List<Customer> queryCustomerList(Double zero,String content,Integer curentPage,String uid);
	
	/**
	 *  #删除客户（改变状态）
	 * @param id
	 * @return
	 */
	public int deleteCustomer(String id);
	
	/**
	 *  #根据门店查询客户
	 * @return
	 */
	public List<Customer> queryCustomerByStore(String sid);
	
	/**
	 *  #根据客户名查询（客户报价选择客户）
	 * @param name
	 * @return
	 */
	public List<Customer> queryCustomerByName(String name);
	
	/**
	 *  #查询所有客户等级和客户类型及可选门店
	 * @param uid
	 * @return
	 */
	public TypeLevelVO queryTypeAndLevel(String uid);

}
