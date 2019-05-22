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
import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.Noticefiles;
import com.imsystem.domain.Noticestore;
import com.imsystem.domain.Store;
import com.imsystem.domain.Supplier;
import com.imsystem.domain.SupplierExample;
import com.imsystem.domain.User;
import com.imsystem.domain.UserLableVO;
import com.imsystem.domain.Userandlable;
import com.imsystem.domain.Userlable;
import com.imsystem.domain.SupplierExample.Criteria;
import com.imsystem.mapper.NoticeMapper;
import com.imsystem.mapper.NoticefilesMapper;
import com.imsystem.mapper.NoticestoreMapper;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.mapper.SupplierMapper;
import com.imsystem.mapper.UserMapper;
import com.imsystem.mapper.UserandlableMapper;
import com.imsystem.mapper.UserlableMapper;
import com.imsystem.service.customer.LableService;
import com.imsystem.service.customer.NewsService;
import com.imsystem.service.customer.SupplierService;

@Service
@Transactional
public class LableServiceImpl implements LableService{
	
	@Autowired
	UserlableMapper ulDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	UserandlableMapper ualDao;

	@Override
	public List<Userlable> queryLableList() {
		// TODO Auto-generated method stub
		return ulDao.queryAllLable();
	}

	@Override
	public int addLabel(Userlable ulobj) {
		// TODO Auto-generated method stub
		String rand=UUID.randomUUID().toString();
		Date time=new Date();
		ulobj.setId(rand);
		ulobj.setTime(time);
		ulobj.setState(0);
		return ulDao.insert(ulobj);
	}

	@Override
	public Userlable queryLableById(String lid) {
		// TODO Auto-generated method stub
		return ulDao.selectByPrimaryKey(lid);
	}

	@Override
	public int updateLabel(Userlable ulobj) {
		// TODO Auto-generated method stub
		return ulDao.updateLable(ulobj);
	}

	@Override
	public int deleteLabel(String id) {
		// TODO Auto-generated method stub
		return ulDao.deleteLabel(id);
	}

	@Override
	public List<Customer> queryCustomer(String uid) {
		// TODO Auto-generated method stub
		User uobj=userDao.queryUserById(uid);
		List<Customer> clist=ualDao.queryCustomer(uobj.getStoreid().toString());
		return clist;
	}

	@Override
	public List<UserLableVO> queryCustomerLable(String cid, String name) {
		// TODO Auto-generated method stub
		return ualDao.queryCustomerLabel(cid, name);
	}

	@Override
	public int addUserLable(UserLableVO ulvo) {
		// TODO Auto-generated method stub
		
		
		if(ulvo.getUllist()!=null) {
			for(Userlable ulobj:ulvo.getUllist()) {
				Userandlable ualobj=new Userandlable();
				ualobj=ulvo.getUalobj();
				String rand=UUID.randomUUID().toString();
				Date time=new Date();
				ualobj.setId(rand);
				ualobj.setTime(time);
				ualobj.setState(0);
				ualobj.setUlid(ulobj.getId());
				int row=ualDao.addUserLabel(ualobj);
			}
		}
		return 0;
	}
	
	

}
