package com.imsystem.service.customer.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.mapper.CustomerMapper;
import com.imsystem.service.customer.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerMapper customerDao;

	/**
	 *  查询所有客户
	 */
	@Override
	public List<Customer> queryCustomer() {
		// TODO Auto-generated method stub
		List<Customer> clist=customerDao.selectAllCustomer();
		return clist;
	}

	/**
	 * 新增客户
	 */
	@Override
	public int insertCustomer(Customer cusObj) {
		// TODO Auto-generated method stub
		String rand=UUID.randomUUID().toString();
		Date time=new Date();
		String address=cusObj.getAddress();
		String[] addr=address.split("/");
		cusObj.setId(rand);
		cusObj.setTime(time);
		cusObj.setUpdatetime(time);
		cusObj.setPname(addr[0]);
		cusObj.setCname(addr[1]);
		cusObj.setAname(addr[2]);
		cusObj.setAddress(addr[3]);
		cusObj.setState(0);
		int row=customerDao.insert(cusObj);
		return row;
	}

	/**
	 * 修改客户
	 */
	@Override
	public int updateCustomer(Customer cusObj) {
		// TODO Auto-generated method stub
		Date time=new Date();
		String address=cusObj.getAddress();
		String[] addr=address.split("/");
		cusObj.setUpdatetime(time);
		cusObj.setPname(addr[0]);
		cusObj.setCname(addr[1]);
		cusObj.setAname(addr[2]);
		cusObj.setAddress(addr[3]);
		int row=customerDao.updateCustomer(cusObj);
		return row;
	}

	/**
	 * 根据ID查询客户
	 */
	@Override
	public Customer queryCustomerById(String cusId) {
		// TODO Auto-generated method stub
		return customerDao.selectByPrimaryKey(cusId);
	}

	/**
	 * 分页查询客户
	 */
	@Override
	public PageInfo<Customer> queryCustomerList(Double zero, String content, Integer curentPage) {
		// TODO Auto-generated method stub
		Page<Customer> page=PageHelper.startPage(curentPage, 1, true);
		customerDao.queryCustomerByPage(zero, content);
		PageInfo<Customer> pages=page.toPageInfo();
		return pages;
	}

	/**
	 * 删除客户
	 */
	@Override
	public int deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return customerDao.deleteCustomer(id);
	}

	/**
	 * 根据门店查询客户
	 */
	@Override
	public List<Customer> queryCustomerByStore(String sid) {
		// TODO Auto-generated method stub
		return customerDao.selectCustomerByStore(sid);
	}

	/**
	 * 客户报价选择客户的客户查询
	 */
	@Override
	public List<Customer> queryCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerDao.queryByName(name);
	}

}
