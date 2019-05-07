package com.imsystem.service.setup;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.User;

public interface UserService {

	public User queryUserByName(String name,String pwd);
	
	public User queryUserById(String id);
	
	public List<User> queryUserAll();
    
	public int insertUser(User user);
    
	public int  deleteUserById(Integer state,String id);
    
	public int updateUserById(User user);
	
	PageInfo<User> queryByPage(User user,Integer pageNum,Integer pageSize);
	
	
	 int deleteAll(Integer [] ids);
	
	String queryUserMaxId();
	
	 User queryUserRoleById(String id);
	 
	 int XiuGaiZhangHu(@Param("name") String name,@Param("pwd") String pwd,@Param("id") String id);
	    
	
}
