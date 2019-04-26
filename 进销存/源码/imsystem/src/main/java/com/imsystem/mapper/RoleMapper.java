package com.imsystem.mapper;

import com.imsystem.domain.Role;
import com.imsystem.domain.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    
    List<Role> queryRoleAll();
    
    Role queryRoleById(String id);
    
    int insertRole(Role role);
    
    int deleteRoleById(String id);
    
    int updateRoleById(Role role);
    
    
    int deleteRoleAll(Integer [] ids);
    
    List<Role> queryRoleModule(@Param("name") String name);
    
    int deleteRole(@Param("state") Integer state,@Param("id") String id);
    
}