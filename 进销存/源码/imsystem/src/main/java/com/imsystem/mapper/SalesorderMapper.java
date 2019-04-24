package com.imsystem.mapper;

import com.imsystem.domain.Salesorder;
import com.imsystem.domain.SalesorderExample;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.annotations.Param;

public interface SalesorderMapper {
	
	int updateCount(String id); 
	
	int updatePregress(@Param("id") String id,@Param("zhi") String zhi);
	
	Vector<Salesorder> querySalesOrder (Salesorder sales);
	
    int countByExample(SalesorderExample example);

    int deleteByExample(SalesorderExample example);

    int deleteByPrimaryKey(String id);

    int insert(Salesorder record);

    int insertSelective(Salesorder record);

    List<Salesorder> selectByExample(SalesorderExample example);

    Salesorder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Salesorder record, @Param("example") SalesorderExample example);

    int updateByExample(@Param("record") Salesorder record, @Param("example") SalesorderExample example);

    int updateByPrimaryKeySelective(Salesorder record);

    int updateByPrimaryKey(Salesorder record);
    
    List<Salesorder> query(@Param("storeid") String storeid,@Param("code") String code,@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    Salesorder queryFirst(@Param("storeid") String storeid,@Param("code") String code,@Param("startTime") String startTime,@Param("endTime") String endTime);

	List<Salesorder> queryDaysAgo(@Param("storeid") String storeid,@Param("startTime") String startTime, @Param("endTime") String endTime);
	
	List<Salesorder> queryRanking(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("storeId") String storeId);
	
	Integer queryTedayMoney(@Param("store") String store);
	
	List<Salesorder> queryThisYear(@Param("year") String year);
}