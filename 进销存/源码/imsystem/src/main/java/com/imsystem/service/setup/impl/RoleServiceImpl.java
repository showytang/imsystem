package com.imsystem.service.setup.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Role;
import com.imsystem.domain.Rolemodule;
import com.imsystem.domain.User;
import com.imsystem.mapper.RoleMapper;
import com.imsystem.mapper.RolemoduleMapper;
import com.imsystem.service.setup.RoleService;


@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	RolemoduleMapper rolemoduleMapper;
	
	
	@Override
	public List<Role> queryRoleAll() {
		
		return roleMapper.queryRoleAll();
	}

	@Override
	public Role queryRoleById(String id) {
		
		return roleMapper.queryRoleById(id);
	}

	@Override
	public int insertRole(Role role) {
		 
		 roleMapper.insertRole(role);
		 rolemoduleMapper.insertRoleModule(role);
		 
		 return 0;
	}

	@Override
	public int deleteRoleById(String id) {
		
		return roleMapper.deleteRoleById(id);
	}

	@Override
	public int updateRoleById(Role role) {
		
		roleMapper.updateRoleById(role);
		
		
		rolemoduleMapper.deleteRoleModuleByRid(role.getId());
		
		
		for (Rolemodule r : role.getRmlist()) {
			
			synchronized(this) {
				
				String id2 = "" ;
				String trandNo2 = String.valueOf((Math.random() * 9 + 1) * 1000000);
				String sdf2 = new SimpleDateFormat("yyyyMMddss").format(new Date());
				id2 = trandNo2.toString().substring(0, 4); 
				id2 = id2 + sdf2 ;
				r.setId(id2);
				r.setRid(role.getId());
				r.setUid(role.getUid());
				rolemoduleMapper.insertRoleModule_two(r);
				
			}
		}
		
		
		
		
		return 0;
	}

	@Override
	public PageInfo<Role> queryByPage(Role role, Integer pageNum, Integer pageSize) {
		Page<Role> page=PageHelper.startPage(pageNum, pageSize,true);
		roleMapper.queryRoleModule(role.getName());
		return page.toPageInfo();
	}

	@Override
	public int deleteRole(Integer state, String id) {
		
		return roleMapper.deleteRole(state, id);
	}

	@Override
	public int deleteRoleAll(Integer[] ids) {
		
		return roleMapper.deleteRoleAll(ids);
	}

}
