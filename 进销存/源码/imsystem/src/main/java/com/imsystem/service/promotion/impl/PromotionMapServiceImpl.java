package com.imsystem.service.promotion.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Promotiongoods;
import com.imsystem.domain.Promotionmap;
import com.imsystem.domain.Promotionrule;
import com.imsystem.domain.Promotionrulevalue;
import com.imsystem.mapper.PromotionMapper;
import com.imsystem.mapper.PromotiongoodsMapper;
import com.imsystem.mapper.PromotionmapMapper;
import com.imsystem.mapper.PromotionruleMapper;
import com.imsystem.mapper.PromotionrulevalueMapper;
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
	
	@Autowired
	private PromotionMapper proMap;

	@Autowired
	private PromotionruleMapper proRuleMap;
	
	@Autowired
	private PromotiongoodsMapper proGoodsMap;
	
	@Autowired
	private PromotionrulevalueMapper proValueMap;
	
	
	/**
	 * 促销字典查询
	 */
	@Override
	public List<Promotionmap> queryPromotionMap() {
		
		return promotionmapMap.selectByExample(null);
	}

	@Override
	public synchronized int addPromotion(Promotionrulevalue promotionrulevalue) {
		
		String pid = new Date().getTime()+"";
		//活动新增
		promotionrulevalue.getPromotion().setId(pid);
		promotionrulevalue.getPromotion().setState("0");
		proMap.insertSelective(promotionrulevalue.getPromotion());
		//活动商品新增
		for(Promotiongoods pg:promotionrulevalue.getPromotion().getPromotiongoods()) {
			
			pg.setHdid(pid);
			pg.setState("0");
			pg.setId(new Date().getTime()+"");
			proGoodsMap.insertSelective(pg);
			
		}
		
		//规则新增
		String prid = new Date().getTime()+"";
		promotionrulevalue.getPromotionrule().setId(prid);
		promotionrulevalue.getPromotionrule().setState("0");
		proRuleMap.insertSelective(promotionrulevalue.getPromotionrule());
		
		
		//活动规则新增
		promotionrulevalue.setPid(pid);
		promotionrulevalue.setPrid(prid);
		promotionrulevalue.setState("0");
		promotionrulevalue.setId(new Date().getTime()+"");
		return proValueMap.insertSelective(promotionrulevalue);
	}

	@Override
	public List<Promotionrulevalue> queryPromotionRuleValue() {
		// TODO Auto-generated method stub
		return proValueMap.queryPromotionRuleValue();
	}
	
	
	
	
}
