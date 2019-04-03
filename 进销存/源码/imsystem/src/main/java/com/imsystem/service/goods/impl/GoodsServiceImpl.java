package com.imsystem.service.goods.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.GoodsVO;
import com.imsystem.mapper.GoodsMapper;
import com.imsystem.mapper.GoodspriceMapper;
import com.imsystem.mapper.GoodsvalueMapper;
import com.imsystem.mapper.ImgMapper;
import com.imsystem.service.goods.GoodsService;
/**
 * 商品服务层实现
 * @author dws
 *
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService{

	/**
	 * 商品Mapper
	 */
	@Autowired
	private GoodsMapper goodsMap;
	
	/**
	 * 商品实例Mapper
	 */
	@Autowired
	private GoodsvalueMapper goodsValueMap;
	
	/**
	 * 商品价格Mapper
	 */
	@Autowired
	private GoodspriceMapper goodsPriceMapper;
	
	
	/**
	 * 图片Mapper
	 */
	@Autowired
	private ImgMapper imgMapper;
	
	/**
	 * 
	 */
	@Override
	public int insertGoods(GoodsVO goodsVo) {
		
		
		
		return 0;
	}
	

}















