package com.imsystem.mapper;

import com.imsystem.domain.Paytype;
import com.imsystem.domain.PaytypeExample;
import com.imsystem.domain.Paytype;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaytypeMapper {
    int countByExample(PaytypeExample example);

    int deleteByExample(PaytypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Paytype record);

    int insertSelective(Paytype record);

    List<Paytype> selectByExample(PaytypeExample example);

    Paytype selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Paytype record, @Param("example") PaytypeExample example);

    int updateByExample(@Param("record") Paytype record, @Param("example") PaytypeExample example);

    int updateByPrimaryKeySelective(Paytype record);

    int updateByPrimaryKey(Paytype record);
    
    
    
    List<Paytype> queryPaytype(@Param("tiaojian")String tiaojian);
    
    int updatedelete(String id);
    
    int insertPaytype(Paytype paytype);
    
    int toupdate(Paytype paytype);
    
    Paytype paytypeById(String id);
    
    Paytype queryPaytypeByname(String name);
    
}