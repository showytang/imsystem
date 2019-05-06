package com.imsystem.mapper;

import com.imsystem.domain.Goodsvalueandlable;
import com.imsystem.domain.GoodsvalueandlableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvalueandlableMapper {
    int countByExample(GoodsvalueandlableExample example);

    int deleteByExample(GoodsvalueandlableExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsvalueandlable record);

    int insertSelective(Goodsvalueandlable record);

    List<Goodsvalueandlable> selectByExample(GoodsvalueandlableExample example);

    Goodsvalueandlable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsvalueandlable record, @Param("example") GoodsvalueandlableExample example);

    int updateByExample(@Param("record") Goodsvalueandlable record, @Param("example") GoodsvalueandlableExample example);

    int updateByPrimaryKeySelective(Goodsvalueandlable record);

    int updateByPrimaryKey(Goodsvalueandlable record);
}