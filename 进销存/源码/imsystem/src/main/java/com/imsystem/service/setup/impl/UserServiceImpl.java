package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public int deleteUserById(String id) {
		
		return userMapper.deleteUserById(id);
	}


	@Override
	public int updateUserById(User user) {
		
		return userMapper.updateUserById(user);
	}

	
}
