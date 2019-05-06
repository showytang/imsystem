package com.imsystem.controller.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/toPromotion")
	public String toPromotion(Model model) {
		
		model.addAttribute("promaplist",promapSer.queryPromotionMap());
		
		return "dws/promotion";
	}
	
	
}
