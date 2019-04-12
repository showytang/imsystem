package com.imsystem.service.setup;

import java.util.List;

import com.imsystem.domain.Module;

public interface ModuleService {

	
	    List<Module>  queryModuleAll();
	    
	    Module queryModuleById(String id);
	    
	    int insertModule(Module module);
	    
	    int deleteModuleById(String id);
	    
	    int updateModuleById(Module module) ;
	
	
}
