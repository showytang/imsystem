package com.imsystem.mapper;

import com.imsystem.domain.Customerrecharge;
import com.imsystem.domain.CustomerrechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerrechargeMapper {
    int countByExample(CustomerrechargeExample example);

    int deleteByExample(CustomerrechargeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Customerrecharge record);

    int insertSelective(Customerrecharge record);

    List<Customerrecharge> selectByExample(CustomerrechargeExample example);

    Customerrecharge selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Customerrecharge record, @Param("example") CustomerrechargeExample example);

    int updateByExample(@Param("record") Customerrecharge record, @Param("example") CustomerrechargeExample example);

    int updateByPrimaryKeySelective(Customerrecharge record);

    int updateByPrimaryKey(Customerrecharge record);
}