package com.imsystem.mapper;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Stock;
import com.imsystem.domain.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockMapper {
	
	int updateState(String code);
	
	Stock querydetails(String code);
	
	int add(Sales sales);
	
	List<Stock> query(@Param("code") String code,@Param("time") String time,@Param("endTime") String endTime,@Param("order")String order,@Param("kucun")Integer kucun);
	
    int countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(String id);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
    
    List<Stock> queryQianKuan(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("sid") String sid);
}