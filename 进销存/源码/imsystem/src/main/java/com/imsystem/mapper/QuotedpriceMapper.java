package com.imsystem.mapper;

import com.imsystem.domain.Quotedprice;
import com.imsystem.domain.QuotedpriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuotedpriceMapper {
    int countByExample(QuotedpriceExample example);

    int deleteByExample(QuotedpriceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Quotedprice record);

    int insertSelective(Quotedprice record);

    List<Quotedprice> selectByExample(QuotedpriceExample example);

    Quotedprice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Quotedprice record, @Param("example") QuotedpriceExample example);

    int updateByExample(@Param("record") Quotedprice record, @Param("example") QuotedpriceExample example);

    int updateByPrimaryKeySelective(Quotedprice record);

    int updateByPrimaryKey(Quotedprice record);
}