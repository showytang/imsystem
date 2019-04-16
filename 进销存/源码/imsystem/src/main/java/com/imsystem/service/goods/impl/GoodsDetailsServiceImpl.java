package com.imsystem.service.goods.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.GoodspriceExample;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.ImgExample;
import com.imsystem.domain.ImgExample.Criteria;
import com.imsystem.mapper.GoodspriceMapper;
import com.imsystem.mapper.GoodsvalueMapper;
import com.imsystem.mapper.ImgMapper;
import com.imsystem.service.goods.GoodsDetailsService;

@Service
@Transactional
public class GoodsDetailsServiceImpl implements GoodsDetailsService{

	/**
	 * 商品实例
	 */
	@Autowired
	private GoodsvalueMapper goodsvalueMap;
	
	/**
	 * 图片
	 */
	@Autowired
	private ImgMapper imgMap;
	
	/**
	 * 商品实例价格
	 */
	@Autowired
	private GoodspriceMapper goodspriceMap;
	
	
	@Override
	public Goodsvalue queryGoodsDetail(String id) {
		// TODO Auto-generated method stub
		
		Goodsvalue goodsvalue = goodsvalueMap.queryGoodsDetail(id);
		
	/*	//商品图片查询
		ImgExample imgExample = new ImgExample();
		
		Criteria imgCriteria = imgExample.createCriteria();
		
		imgCriteria.andGidEqualTo(goodsDetailVo.getGoods().getId());
		
		goodsDetailVo.setImg(imgMap.selectByExample(imgExample));
		
		//商品实例价格查询
		GoodspriceExample goodspriceExample = new GoodspriceExample();
		
		goodspriceExample.createCriteria().andGvidEqualTo(goodsDetailVo.getGoodsvalue().getId());
		
		goodsDetailVo.setGoodsprice(goodspriceMap.selectByExample(goodspriceExample));
*/
		return goodsvalue;
	}

}
