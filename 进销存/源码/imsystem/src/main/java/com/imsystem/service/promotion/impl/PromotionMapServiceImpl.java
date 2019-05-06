package com.imsystem.service.promotion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Promotionmap;
import com.imsystem.mapper.PromotionmapMapper;
import com.imsystem.service.promotion.PromotionMapService;

/**
 * 促销字典服务层
 * @author Shimmer
 *
 */
@Service
@Transactional
public class PromotionMapServiceImpl implements PromotionMapService{

	
	@Autowired
	private PromotionmapMapper promotionmapMap;

	/**
	 * 促销字典查询
	 */
	@Override
	public List<Promotionmap> queryPromotionMap() {
		
		return promotionmapMap.selectByExample(null);
	}
	
	
	
	
}
