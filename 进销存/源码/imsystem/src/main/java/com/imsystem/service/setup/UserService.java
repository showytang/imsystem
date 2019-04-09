package com.imsystem.service.setup;

import com.imsystem.domain.User;

public interface UserService {

	public   User queryUserByName(String name,String pwd);
	
	public User queryUserById(String id);
	
}
