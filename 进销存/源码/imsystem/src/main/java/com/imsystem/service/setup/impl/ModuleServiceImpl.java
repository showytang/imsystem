package com.imsystem.service.setup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Module;
import com.imsystem.mapper.ModuleMapper;
import com.imsystem.service.setup.ModuleService;


@Service
@Transactional
public class ModuleServiceImpl implements ModuleService{

	
	
	@Autowired
	ModuleMapper moduleMapper;
	
	
	
	@Override
	public List<Module> queryModuleAll() {
		
		return moduleMapper.queryModuleAll();
	}

	@Override
	public Module queryModuleById(String id) {
		
		return moduleMapper.queryModuleById(id);
	}

	@Override
	public int insertModule(Module module) {
		
		return moduleMapper.insertModule(module);
	}

	@Override
	public int deleteModuleById(String id) {
		
		return moduleMapper.deleteModuleById(id);
	}

	@Override
	public int updateModuleById(Module module) {
		
		return moduleMapper.updateModuleById(module);
	}

}
