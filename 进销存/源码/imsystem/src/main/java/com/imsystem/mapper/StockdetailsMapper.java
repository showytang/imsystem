package com.imsystem.mapper;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.StockdetailsExample;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.annotations.Param;

public interface StockdetailsMapper {
	
	double querydetailsSumPrice(String id);
	
	int updateDetails(Stockdetails stock);
	
	int updateScount(@Param("id")String id,@Param("count")Integer count);
	
	Stockdetails queryCount(@Param("gvid") String gvid,@Param("sid") String sid);
	
	int selectCount(@Param("code")String code,@Param("sid")String id);
	
	Vector<Stockdetails> queryGoods(@Param("name") String name, @Param("storeid")String storeid);
	
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
    
    List<Stockdetails> queryJinHuo(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("cid") String cid,@Param("storeId") String storeId);
    
    List<Stockdetails> queryStockByGidAndStoreId(@Param("gid") String gid,@Param("storeId") String storeId,@Param("name") String name);
}