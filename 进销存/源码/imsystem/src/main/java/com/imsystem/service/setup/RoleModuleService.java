package com.imsystem.service.setup;

import java.util.List;

import com.imsystem.domain.Rolemodule;


public interface RoleModuleService {

	 int insertRoleModule_two(Rolemodule rolemodule,String rid,String uid);
	 int deleteRoleModuleByRid(String id);
	 
	 
}
