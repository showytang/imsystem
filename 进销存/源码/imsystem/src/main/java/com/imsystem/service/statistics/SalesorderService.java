package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.imsystem.domain.Salesorder;
import com.imsystem.mapper.BitMapper;

public interface SalesorderService{

	List<Salesorder> query( String storeid,String code, String startTime, String endTime);
	
	Salesorder queryFirst(@Param("storeid") String storeid,@Param("code") String code,@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	List<Salesorder> queryDaysAgo(@Param("storeid") String storeid);
	
	List<Salesorder> queryRanking(@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	Integer queryTedayMoney(@Param("store") String store);
	
	List<Salesorder> queryThisYear(@Param("year") String year);
}
