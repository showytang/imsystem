package com.imsystem.service.setup;

import com.imsystem.domain.User;

public interface UserService {

	public   User queryByName(String name,String pwd);
	
}
