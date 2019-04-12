package com.imsystem.mapper;

import com.imsystem.domain.Module;
import com.imsystem.domain.ModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleMapper {
    int countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
    
    
    List<Module>  queryModuleAll();
    
    Module queryModuleById(String id);
    
    int insertModule(Module module);
    
    int deleteModuleById(String id);
    
    int updateModuleById(Module module) ;
    
    
    
    
    
}