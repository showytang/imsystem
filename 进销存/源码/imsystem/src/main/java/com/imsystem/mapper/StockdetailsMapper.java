package com.imsystem.mapper;

import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.StockdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockdetailsMapper {
	
	List<Stockdetails> query(String code);
	
	int del(String code);
	
	int add(Stock stock);
	
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
    
    List<Stockdetails> queryJinHuo(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("cid") String cid);
    
    List<Stockdetails> queryStockByGidAndStoreId(@Param("gid") String gid,@Param("storeId") String storeId);
}