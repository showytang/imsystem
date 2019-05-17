package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.User;
import com.imsystem.mapper.UserMapper;
import com.imsystem.service.setup.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public User queryUserByName(String name, String pwd) {
		
		return userMapper.queryUserByName(name, pwd);
	}


	@Override
	public User queryUserById(String id) {
		
		return userMapper.queryUserById(id);
	}


	@Override
	public List<User> queryUserAll() {
		
		return userMapper.queryUserAll();
	}


	@Override
	public int insertUser(User user) {
		
		return userMapper.insertUser(user);
	}




	@Override
	public int updateUserById(User user) {
		
		return userMapper.updateUserById(user);
	}


	


	@Override
	public String queryUserMaxId() {
		
		return userMapper.queryUserMaxId();
	}


	@Override
	public int deleteUserById(Integer state, String id) {
		
		return userMapper.deleteUserById(state, id);
	}


	@Override
	public PageInfo<User> queryByPage(User user, Integer pageNum, Integer pageSize) {
		Page<User> page=PageHelper.startPage(pageNum, pageSize,true);
		System.out.println(user.getName());
		userMapper.queryUserRole(user.getName());
		return page.toPageInfo();
	}


	@Override
	public int deleteAll(Integer[] ids) {
		
		return userMapper.deleteAll(ids);
	}


	@Override
	public User queryUserRoleById(String id) {
		
		return userMapper.queryUserRoleById(id);
	}


	@Override
	public int XiuGaiZhangHu(String name, String pwd, String id) {
		
		return userMapper.XiuGaiZhangHu(name, pwd, id);
	}


	@Override
	public User ChaXunMenDianDianZhang(Integer storeid, String rid) {
		return userMapper.ChaXunMenDianDianZhang(storeid, rid);
	}


	

	
}
