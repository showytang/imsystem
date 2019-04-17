package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Stock;

public interface StockService {
    
    List<Stock> queryQianKuan(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("sid") String sid);
}
