package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Rolemodule;
import com.imsystem.mapper.RolemoduleMapper;
import com.imsystem.service.setup.RoleModuleService;

@Service
@Transactional
public class RoleModuleServiceImpl implements RoleModuleService{

	@Autowired
	RolemoduleMapper rolemoduleMapper;
	
	

	
	
}
