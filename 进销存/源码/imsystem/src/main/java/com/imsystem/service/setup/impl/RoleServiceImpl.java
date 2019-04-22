package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Role;
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
		
		return roleMapper.updateRoleById(role);
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
