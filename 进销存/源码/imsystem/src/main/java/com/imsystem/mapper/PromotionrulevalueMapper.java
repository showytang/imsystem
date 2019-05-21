package com.imsystem.mapper;

import com.imsystem.domain.Promotionrulevalue;
import com.imsystem.domain.PromotionrulevalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionrulevalueMapper {
	
	List<Promotionrulevalue> queryPromotionRuleValue();
	
    int countByExample(PromotionrulevalueExample example);

    int deleteByExample(PromotionrulevalueExample example);

    int deleteByPrimaryKey(String id);

    int insert(Promotionrulevalue record);

    int insertSelective(Promotionrulevalue record);

    List<Promotionrulevalue> selectByExample(PromotionrulevalueExample example);

    Promotionrulevalue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Promotionrulevalue record, @Param("example") PromotionrulevalueExample example);

    int updateByExample(@Param("record") Promotionrulevalue record, @Param("example") PromotionrulevalueExample example);

    int updateByPrimaryKeySelective(Promotionrulevalue record);

    int updateByPrimaryKey(Promotionrulevalue record);
}