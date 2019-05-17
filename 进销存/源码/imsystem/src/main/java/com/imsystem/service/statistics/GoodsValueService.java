package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Sales;

public interface GoodsValueService {
	/***
	 * 根据销售但id查询订单详情及商品
	 * @param code
	 * @return
	 */
    List<Goodsvalue> queryByCode(@Param("code") String code);
    
    List<Goodsvalue> queryGoodsByTime(@Param("time") String time,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("storeId") String storeId,@Param("gid") String gid,@Param("name") String name);
    
    List<Goodsvalue> querySalesByCid(@Param("cid") String cid,@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<Goodsvalue> queryGoodsRanking(@Param("time") String time,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("storeId") String storeId,@Param("gid") String gid,@Param("name") String name);
    
    List<Goodsvalue> queryGoodsBySid(@Param("sid") String sid,@Param("startTime") String startTime,@Param("endTime") String endTime);
    
}
