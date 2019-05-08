package com.imsystem.service.goods;

import java.util.List;

import com.imsystem.domain.Bit;
import com.imsystem.domain.Customertype;
import com.imsystem.domain.Goods;
import com.imsystem.domain.GoodsVO;
import com.imsystem.domain.GoodsValueVo;

/**
 * 商品服务层
 * @author Shimmer
 *
 */
public interface GoodsService {

	/**
	 * 查询所有商品单位
	 * @return
	 */
	List<Bit> queryAllBit();
	
	/**

	 * 商品修改
	 * @param goodsVo
	 * @return
	 */
	Integer updateGoods(GoodsVO goodsVo,String url);
	
	/**
	 * 商品修改加载
	 * @param id
	 * @return
	 */
	Goods updateGoodsLoad(String id);
	
	
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
