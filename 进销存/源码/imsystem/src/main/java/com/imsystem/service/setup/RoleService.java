package com.imsystem.service.setup;

import java.util.List;

import com.imsystem.domain.Role;

public interface RoleService {

		List<Role> queryRoleAll();
	    
		Role queryRoleById(String id);
	    
	    int insertRole(Role role);
	    
	    int deleteRoleById(String id);
	    
	    int updateRoleById(Role role);
	
}
