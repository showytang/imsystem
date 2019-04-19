package com.imsystem.service.setup;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Module;

public interface ModuleService {
		
	    List<Module>  queryModuleAll();
	    
	    Module queryModuleById(String id);
	    
	    int insertModule(Module module);
	    
	    int deleteModuleById(String id);
	    
	    int updateModuleById(Module module) ;
	    
	   
	    
	    List<Module> queryMuLu(String uid,Integer id);
	    
	    Map<String, Module>queryMap(String uid);
}
