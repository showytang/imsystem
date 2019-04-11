package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Goodsvalue;

public interface GoodsValueService {
	/***
	 * 根据销售但id查询订单详情及商品
	 * @param code
	 * @return
	 */
    List<Goodsvalue> queryByCode(@Param("code") String code);
}
