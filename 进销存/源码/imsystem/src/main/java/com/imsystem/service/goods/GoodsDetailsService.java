package com.imsystem.service.goods;

import com.imsystem.domain.Goodsvalue;

public interface GoodsDetailsService {

	/**
	 * 查询商品实例详情
	 * @param id 实例id
	 * @return
	 */
	Goodsvalue queryGoodsDetail (String id);
	
}
