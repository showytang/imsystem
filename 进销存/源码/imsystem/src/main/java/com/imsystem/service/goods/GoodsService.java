package com.imsystem.service.goods;

import com.imsystem.domain.GoodsVO;

/**
 * 商品服务层
 * @author Shimmer
 *
 */
public interface GoodsService {

	/**
	 * 商品添加
	 * @param goods
	 * @return
	 */
	int insertGoods(GoodsVO goodsVo);
	
	
}
