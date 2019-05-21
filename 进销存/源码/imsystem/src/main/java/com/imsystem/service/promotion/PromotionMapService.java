package com.imsystem.service.promotion;

import java.util.List;

import com.imsystem.domain.Promotionmap;
import com.imsystem.domain.Promotionrulevalue;

/**
 * 促销字典接口
 * @author Shimmer
 *
 */
public interface PromotionMapService {

	/**
	 * 促销字典查询
	 * @return
	 */
	List<Promotionmap> queryPromotionMap();
	
	int addPromotion(Promotionrulevalue promotionrulevalue);
	
	
	List<Promotionrulevalue> queryPromotionRuleValue();
}
