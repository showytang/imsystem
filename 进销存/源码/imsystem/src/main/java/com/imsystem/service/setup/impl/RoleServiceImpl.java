package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Role;
import com.imsystem.mapper.RoleMapper;
import com.imsystem.service.setup.RoleService;


@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleMapper roleMapper;
	
	
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
		
		return roleMapper.insertRole(role);
	}

	@Override
	public int deleteRoleById(String id) {
		
		return roleMapper.deleteRoleById(id);
	}

	@Override
	public int updateRoleById(Role role) {
		
		return roleMapper.updateRoleById(role);
	}

}
