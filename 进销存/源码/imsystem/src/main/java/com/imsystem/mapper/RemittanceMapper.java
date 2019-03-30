package com.imsystem.mapper;

import com.imsystem.domain.Remittance;
import com.imsystem.domain.RemittanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemittanceMapper {
    int countByExample(RemittanceExample example);

    int deleteByExample(RemittanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Remittance record);

    int insertSelective(Remittance record);

    List<Remittance> selectByExample(RemittanceExample example);

    Remittance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Remittance record, @Param("example") RemittanceExample example);

    int updateByExample(@Param("record") Remittance record, @Param("example") RemittanceExample example);

    int updateByPrimaryKeySelective(Remittance record);

    int updateByPrimaryKey(Remittance record);
}