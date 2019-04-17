package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Stockdetails;

public interface StockDetailsService {
    List<Stockdetails> queryJinHuo(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("cid") String cid);
    
    List<Stockdetails> queryStockByGidAndStoreId(@Param("gid") String gid,@Param("storeId") String storeId);
}
