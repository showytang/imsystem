package com.imsystem.service.customer.impl;

import java.util.ArrayList;
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
import com.imsystem.domain.Store;
import com.imsystem.domain.TypeLevelVO;
import com.imsystem.domain.User;
import com.imsystem.mapper.CustomerMapper;
import com.imsystem.mapper.CustomerlevelMapper;
import com.imsystem.mapper.CustomertypeMapper;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.mapper.UserMapper;
import com.imsystem.service.customer.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerMapper customerDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	StoreMapper storeDao;

	/**
	 *  查询所有客户
	 */
	@Override
	public List<Customer> queryCustomer(String uid) {
		// TODO Auto-generated method stub
		List<Customer> clist=new ArrayList<Customer>();
		User uobj=userDao.queryUserById(uid);
		String sid=uobj.getStoreid().toString();
		Store sobj=storeDao.selectByPrimaryKey(sid);
		if(sobj.getParented().equals("0")) {
			List<Customer> clist1=queryCustomerByStore(sobj.getId());
			List<Store> sList=storeDao.SelectStoreByParentId(sobj.getId());
			clist.addAll(clist1);
			if(sList.size()>0) {
				for(Store sObj1:sList) {
					List<Customer> cList2=queryCustomerByStore(sObj1.getId());
					if(cList2.size()!=0) {
						clist.addAll(cList2);
					}
				}
			}
			
		}else {
			List<Customer> clist3=queryCustomerByStore(sobj.getId());
			clist.addAll(clist3);
		}
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
		if(addr.length>4) {
			cusObj.setPname(addr[0]);
			cusObj.setCname(addr[1]);
			cusObj.setAname(addr[2]);
			String address1=addr[3]+"/"+addr[4];
			cusObj.setAddress(address1);
		}else {
			cusObj.setPname(addr[0]);
			cusObj.setCname(addr[1]);
			cusObj.setAname(addr[2]);
			cusObj.setAddress(addr[3]);
		}
		
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
		if(addr.length>4) {
			cusObj.setPname(addr[0]);
			cusObj.setCname(addr[1]);
			cusObj.setAname(addr[2]);
			String address1=addr[3]+"/"+addr[4];
			cusObj.setAddress(address1);
		}else {
			cusObj.setPname(addr[0]);
			cusObj.setCname(addr[1]);
			cusObj.setAname(addr[2]);
			cusObj.setAddress(addr[3]);
		}
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
	public List<Customer> queryCustomerList(Double zero, String content, Integer curentPage,String uid) {
		// TODO Auto-generated method stub
		
		List<Customer> clist=new ArrayList<Customer>();
		//List<Customer> cList2=customerDao.queryCustomerByPage(zero, content, "2");
		User uobj=userDao.queryUserById(uid);
		String sid=uobj.getStoreid().toString();
		Store sobj=storeDao.selectByPrimaryKey(sid);
		
		/*List<Customer> cList2=customerDao.queryCustomerByPage(zero, content, sobj.getId());
		clist.addAll(cList2);*/
		
		if(sobj.getParented().equals("0")) {
			List<Customer> cList2=customerDao.queryCustomerByPage(zero, content, sobj.getId());
			if(cList2.size()!=0) {
				clist.addAll(cList2);
			}
			List<Store> sList=storeDao.SelectStoreByParentId(sobj.getId());
			if(sList.size()>0) {
				for(Store sObj1:sList) {
					List<Customer> cList1=customerDao.queryCustomerByPage(zero, content, sObj1.getId());
					if(cList1.size()!=0) {
						clist.addAll(cList1);
					}
				}
			}
			
		}else {
			List<Customer> cList3=customerDao.queryCustomerByPage(zero, content, sobj.getId());
			
			if(cList3.size()!=0) {
				clist.addAll(cList3);
			}
		}
		
		return clist;
		//return cList2;
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

	@Override
	public TypeLevelVO queryTypeAndLevel(String uid) {
		// TODO Auto-generated method stub
		TypeLevelVO tlVO=new TypeLevelVO();
		List<Store> storeList=new ArrayList<Store>();
		
		User uobj=userDao.queryUserById(uid);
		String sid=uobj.getStoreid().toString();
		Store sobj=storeDao.selectByPrimaryKey(sid);
		
		if(sobj.getParented().equals("0")) {
			storeList.add(sobj);
			List<Store> sList=storeDao.SelectStoreByParentId(sobj.getId());
			if(sList!=null) {
				storeList.addAll(sList);
			}
		}else {
			storeList.add(sobj);
		}
		tlVO.setSlist(storeList);
		return tlVO;
	}

}
