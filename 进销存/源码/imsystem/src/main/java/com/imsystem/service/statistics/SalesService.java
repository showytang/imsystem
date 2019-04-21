package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Sales;

public interface SalesService {
    List<Sales> queryShouZhang(@Param("cid") String cid, @Param("startTime") String startTime , @Param("endTime") String endTime,String storeid);
}
