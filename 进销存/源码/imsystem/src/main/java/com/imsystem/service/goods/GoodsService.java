package com.imsystem.service.goods;

import java.util.List;

import com.imsystem.domain.Customertype;
import com.imsystem.domain.GoodsVO;
import com.imsystem.domain.GoodsValueVo;

/**
 * 商品服务层
 * @author Shimmer
 *
 */
public interface GoodsService {

	
	List<Customertype> queryCustomerType();
	
	/**
	 * 商品添加
	 * @param goods
	 * @return
	 */
	int insertGoods(GoodsVO goodsVo,String url);
	
	/**
	 * 商品查询
	 * @return
	 */
	List<GoodsValueVo> queryAllGoods(String liketext,String [] svid,String tid);
	
}
