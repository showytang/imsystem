package com.imsystem.mapper;

import com.imsystem.domain.Store;
import com.imsystem.domain.StoreExample;
import com.imsystem.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    int countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int deleteByPrimaryKey(String id);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreExample example);

    Store selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
    
    int  deleteStoreById(@Param("state")Integer state,@Param("id") String id);
    
    
    List<Store> queryStoreAll();
    
    List<Store>  SelectStoreAll(@Param("name") String name);
    
    int deleteAll(Integer [] ids);
    
    int insertStore(Store store);
    
    
    Store SelectZongDian();
    
    
    
    
}