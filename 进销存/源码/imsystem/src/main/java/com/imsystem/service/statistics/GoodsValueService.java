package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Goodsvalue;

public interface GoodsValueService {

    List<Goodsvalue> queryByCode(@Param("code") String code);
}
