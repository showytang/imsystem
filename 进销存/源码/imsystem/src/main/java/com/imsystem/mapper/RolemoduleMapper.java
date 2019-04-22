package com.imsystem.mapper;

import com.imsystem.domain.Role;
import com.imsystem.domain.Rolemodule;
import com.imsystem.domain.RolemoduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolemoduleMapper {
    int countByExample(RolemoduleExample example);

    int deleteByExample(RolemoduleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Rolemodule record);

    int insertSelective(Rolemodule record);

    List<Rolemodule> selectByExample(RolemoduleExample example);

    Rolemodule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Rolemodule record, @Param("example") RolemoduleExample example);

    int updateByExample(@Param("record") Rolemodule record, @Param("example") RolemoduleExample example);

    int updateByPrimaryKeySelective(Rolemodule record);

    int updateByPrimaryKey(Rolemodule record);
    
    int insertRoleModule(Role role);
    
    
    
    
}