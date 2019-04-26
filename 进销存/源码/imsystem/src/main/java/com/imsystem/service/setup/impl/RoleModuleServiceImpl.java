package com.imsystem.service.setup.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Rolemodule;
import com.imsystem.domain.User;
import com.imsystem.mapper.RolemoduleMapper;
import com.imsystem.service.setup.RoleModuleService;

@Service
@Transactional
public class RoleModuleServiceImpl implements RoleModuleService{

	@Autowired
	RolemoduleMapper rolemoduleMapper;

	@Override
	public int insertRoleModule_two(Rolemodule rolemodule,String rid,String uid) {
		int count = 0;
		
		for(Rolemodule rd: rolemodule.getListRM()) {
			
			synchronized(this) {
				
				String id = "" ;
				String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
				id = trandNo.toString().substring(0, 4); 
				id = id + new Date().getTime() ;
				System.out.println("同步"+id);
				rd.setId(id);
				rd.setRid(rolemodule.getRid());
				rd.setUid(rolemodule.getUid());
				
				count += rolemoduleMapper.insertRoleModule_two(rd);
			}
			
		}
		
	
		return count;
	}

	@Override
	public int deleteRoleModuleByRid(String id) {
		
		return rolemoduleMapper.deleteRoleModuleByRid(id);
	}
	
	

	
	
}
