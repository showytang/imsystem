package com.imsystem.controller.promotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Goods;
import com.imsystem.domain.Promotion;
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
	public int inertPromotion(List<Promotion> proLis,List<Goods> list) {
		
		return 0;
		
	}
	
	
	
	
}
