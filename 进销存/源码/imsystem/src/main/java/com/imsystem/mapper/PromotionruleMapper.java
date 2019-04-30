package com.imsystem.mapper;

import com.imsystem.domain.Promotionrule;
import com.imsystem.domain.PromotionruleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionruleMapper {
    int countByExample(PromotionruleExample example);

    int deleteByExample(PromotionruleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Promotionrule record);

    int insertSelective(Promotionrule record);

    List<Promotionrule> selectByExampleWithBLOBs(PromotionruleExample example);

    List<Promotionrule> selectByExample(PromotionruleExample example);

    Promotionrule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Promotionrule record, @Param("example") PromotionruleExample example);

    int updateByExampleWithBLOBs(@Param("record") Promotionrule record, @Param("example") PromotionruleExample example);

    int updateByExample(@Param("record") Promotionrule record, @Param("example") PromotionruleExample example);

    int updateByPrimaryKeySelective(Promotionrule record);

    int updateByPrimaryKeyWithBLOBs(Promotionrule record);

    int updateByPrimaryKey(Promotionrule record);
}