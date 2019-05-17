package com.imsystem.mapper;

import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.GoodsvalueExample;
import com.imsystem.domain.Sales;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvalueMapper {
	
	Goodsvalue queryGoodsDetail(String id);
	
    int countByExample(GoodsvalueExample example);

    int deleteByExample(GoodsvalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsvalue record);

    int insertSelective(Goodsvalue record);

    List<Goodsvalue> selectByExample(GoodsvalueExample example);

    Goodsvalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByExample(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByPrimaryKeySelective(Goodsvalue record);

    int updateByPrimaryKey(Goodsvalue record);
    
    List<Goodsvalue> queryByCode(@Param("code") String code);
    
    List<Goodsvalue> queryGoodsByTime(@Param("time") String time,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("storeId") String storeId,@Param("gid") String gid,@Param("name") String name);
    
    List<Goodsvalue> querySalesByCid(@Param("cid") String cid,@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<Goodsvalue> queryGoodsRanking(@Param("time") String time,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("storeId") String storeId,@Param("gid") String gid,@Param("name") String name);
    
    List<Goodsvalue> queryGoodsBySid(@Param("sid") String sid,@Param("startTime") String startTime,@Param("endTime") String endTime);
    
}