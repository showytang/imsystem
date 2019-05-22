package com.imsystem.controller.promotion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Goods;
import com.imsystem.domain.GoodsVO;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Promotion;
import com.imsystem.domain.PromotionCondition;
import com.imsystem.domain.Promotionrulevalue;
import com.imsystem.service.promotion.PromotionMapService;

/**
 * 促销控制器
 * @author dws
 *
 */
@Controller
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	private PromotionMapService promapSer;
	
	/**
	 * 促销管理页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toPromotion")
	public String toPromotion(Model model) {
		
		model.addAttribute("promaplist",promapSer.queryPromotionMap());
		model.addAttribute("prorulevalue",promapSer.queryPromotionRuleValue());
		
		return "dws/promotion";
	}
	
	
	/**
	 * 促销新增
	 * @param proLis
	 * @param list
	 * @return
	 */
	@RequestMapping("/inertPromotion")
	@ResponseBody
	public int inertPromotion(@RequestBody Promotionrulevalue promotionrulevalue) {
		return promapSer.addPromotion(promotionrulevalue);
		
	}
	
	/**
	 *商品促销判断
	 * @param pc
	 * @return
	 */
	@RequestMapping("/getPromotion")
	@ResponseBody
	public List<PromotionCondition> getPromotion(@RequestBody PromotionCondition pc){
		
		//所有开始的促销
		List<Promotionrulevalue> prvlist = promapSer.queryPromotionRuleValue();
		
		StringFormula sf = new StringFormula();
		
		// 返回的促销集合
		List<PromotionCondition> prmctlist = sf.main(pc, prvlist);
		
		return prmctlist;
		
	}
	
	
	
	
	
	
	
	
	
}
