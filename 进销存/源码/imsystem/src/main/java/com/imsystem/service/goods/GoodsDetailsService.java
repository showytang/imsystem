package com.imsystem.service.goods;

import com.imsystem.domain.GoodsDetailVo;

public interface GoodsDetailsService {

	/**
	 * 查询商品实例详情
	 * @param id 实例id
	 * @return
	 */
	GoodsDetailVo queryGoodsDetail (String id);
	
}
