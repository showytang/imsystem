package com.imsystem.mapper;

import com.imsystem.domain.User;
import com.imsystem.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
    
    User queryUserByName(@Param("name") String name,@Param("pwd") String pwd);
    
    User queryUserById(@Param("id") String id);
    
    List<User> queryUserAll();
    
    int insertUser(User user);
    
    int  deleteUserById(@Param("state") Integer state,@Param("id") String id);
    
    int updateUserById(User user);
    
    
    List<User> queryUserRole(@Param("name") String name);
    
    
    String queryUserMaxId();
    
    
    int deleteAll(Integer [] ids);
    
    
    User queryUserRoleById(String id);
    
    int XiuGaiZhangHu(@Param("name") String name,@Param("pwd") String pwd,@Param("id") String id);
    
    
    User ChaXunMenDianDianZhang(@Param("storeid") Integer storeid,@Param("rid") String rid);
    
}