package com.imsystem.service.setup;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Role;
import com.imsystem.domain.User;

public interface RoleService {

		List<Role> queryRoleAll();
	    
		Role queryRoleById(String id);
	    
	    int insertRole(Role role);
	    
	    int deleteRoleById(String id);
	    
	    int updateRoleById(Role role);
	
	    PageInfo<Role> queryByPage(Role role,Integer pageNum,Integer pageSize);
	    
	    
	    int deleteRole(@Param("state") Integer state,@Param("id") String id);
	    
	    
	    
	    
	    int deleteRoleAll(Integer [] ids);
	    
	    
	    
}
