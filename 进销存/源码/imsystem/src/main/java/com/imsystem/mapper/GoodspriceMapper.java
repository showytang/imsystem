package com.imsystem.mapper;

import com.imsystem.domain.Goodsprice;
import com.imsystem.domain.GoodspriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodspriceMapper {
    int countByExample(GoodspriceExample example);

    int deleteByExample(GoodspriceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsprice record);

    int insertSelective(Goodsprice record);

    List<Goodsprice> selectByExample(GoodspriceExample example);

    Goodsprice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsprice record, @Param("example") GoodspriceExample example);

    int updateByExample(@Param("record") Goodsprice record, @Param("example") GoodspriceExample example);

    int updateByPrimaryKeySelective(Goodsprice record);

    int updateByPrimaryKey(Goodsprice record);
}