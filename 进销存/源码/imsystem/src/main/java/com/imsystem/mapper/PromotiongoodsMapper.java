package com.imsystem.mapper;

import com.imsystem.domain.Promotiongoods;
import com.imsystem.domain.PromotiongoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotiongoodsMapper {
    int countByExample(PromotiongoodsExample example);

    int deleteByExample(PromotiongoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Promotiongoods record);

    int insertSelective(Promotiongoods record);

    List<Promotiongoods> selectByExample(PromotiongoodsExample example);

    Promotiongoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Promotiongoods record, @Param("example") PromotiongoodsExample example);

    int updateByExample(@Param("record") Promotiongoods record, @Param("example") PromotiongoodsExample example);

    int updateByPrimaryKeySelective(Promotiongoods record);

    int updateByPrimaryKey(Promotiongoods record);
}