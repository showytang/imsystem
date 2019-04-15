package com.imsystem.mapper;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.StockdetailsExample;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.annotations.Param;

public interface StockdetailsMapper {
	
	int selectCount(String code);
	
	Vector<Stockdetails> queryGoods(String name);
	
	int update(String id);
	
	List<Stockdetails> query(String code);
	
	Vector<Stockdetails> queryDetails(@Param("gvid") String gvid,@Param("storeid") String storeid);
	
	int del(String code);
	
	int updateCount(@Param("code") String code,@Param("count")Integer count,@Param("gvid")String gvid);
	
	int add(Stock stock);
	
	int addAllot(Sales sales);
	
    int countByExample(StockdetailsExample example);

    int deleteByExample(StockdetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Stockdetails record);

    int insertSelective(Stockdetails record);

    List<Stockdetails> selectByExample(StockdetailsExample example);

    Stockdetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Stockdetails record, @Param("example") StockdetailsExample example);

    int updateByExample(@Param("record") Stockdetails record, @Param("example") StockdetailsExample example);

    int updateByPrimaryKeySelective(Stockdetails record);

    int updateByPrimaryKey(Stockdetails record);
}