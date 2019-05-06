package com.imsystem.mapper;

import com.imsystem.domain.Promotionmap;
import com.imsystem.domain.PromotionmapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionmapMapper {
    int countByExample(PromotionmapExample example);

    int deleteByExample(PromotionmapExample example);

    int deleteByPrimaryKey(String id);

    int insert(Promotionmap record);

    int insertSelective(Promotionmap record);

    List<Promotionmap> selectByExample(PromotionmapExample example);

    Promotionmap selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Promotionmap record, @Param("example") PromotionmapExample example);

    int updateByExample(@Param("record") Promotionmap record, @Param("example") PromotionmapExample example);

    int updateByPrimaryKeySelective(Promotionmap record);

    int updateByPrimaryKey(Promotionmap record);
}