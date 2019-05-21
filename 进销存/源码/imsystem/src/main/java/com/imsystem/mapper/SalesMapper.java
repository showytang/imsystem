package com.imsystem.mapper;

import com.imsystem.domain.Sales;
import com.imsystem.domain.SalesExample;
import com.imsystem.domain.Stock;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesMapper {
	
	List<Sales> query(@Param("code") String code,@Param("time") String time,@Param("endTime") String endTime,@Param("shappingname")String shappingname,@Param("storeid") String storeid);
	
    int countByExample(SalesExample example);

    int deleteByExample(SalesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sales record);

    int insertSelective(Sales record);

    List<Sales> selectByExample(SalesExample example);

    Sales selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByExample(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
    
    List<Sales> queryShouZhang(@Param("cid") String cid, @Param("startTime") String startTime , @Param("endTime") String endTime,@Param("storeid") String storeid);
    
    List<Sales> queryXf(@Param("sid") String sid,@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<Sales> querySalesByCid(@Param("cid") String cid,@Param("startTime") String startTime,@Param("endTime") String endTime);

    
    
   Sales ChaXunJinRiZongE(String id);
    
   Sales ChaXunBenYueZongE(String id);
    
}