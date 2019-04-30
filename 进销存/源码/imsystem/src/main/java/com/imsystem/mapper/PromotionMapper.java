package com.imsystem.mapper;

import com.imsystem.domain.Promotion;
import com.imsystem.domain.PromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionMapper {
    int countByExample(PromotionExample example);

    int deleteByExample(PromotionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Promotion record);

    int insertSelective(Promotion record);

    List<Promotion> selectByExample(PromotionExample example);

    Promotion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Promotion record, @Param("example") PromotionExample example);

    int updateByExample(@Param("record") Promotion record, @Param("example") PromotionExample example);

    int updateByPrimaryKeySelective(Promotion record);

    int updateByPrimaryKey(Promotion record);
}