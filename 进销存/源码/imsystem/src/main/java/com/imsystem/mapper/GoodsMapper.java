package com.imsystem.mapper;

import com.imsystem.domain.Goods;
import com.imsystem.domain.GoodsExample;
import com.imsystem.domain.GoodsValueVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
	
	Goods updateGoodsLoad(String id);
	
	List<GoodsValueVo> queryAllGoods(@Param("liketext") String liketext,@Param("svid") String [] svid,@Param("tid") String tid);
	
	
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
}