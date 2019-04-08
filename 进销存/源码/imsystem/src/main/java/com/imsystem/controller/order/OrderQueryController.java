package com.imsystem.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.service.order.OrderQueryService;

@Controller
@RequestMapping("/orderQueryController")
public class OrderQueryController {

	@Autowired
	OrderQueryService orderquery;
	
	@RequestMapping("/query")
	public String query(Model model,String code,String time,String endTime,Integer currentPage,Integer pageSize) {
		
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		
		if(pageSize == null) {
			pageSize = 10;
		}
		
		model.addAttribute("pageif",orderquery.queryStock(code, time, endTime, currentPage, pageSize));
		
		return "wjh/index";
	}
	
	@RequestMapping("/yetQuery")
	public String yetQuery() {
		return "wjh/yetOrder";
	}
	
	@RequestMapping("/orderOver")
	public String orderOver(){
		return "wjh/orderOver.html";
	}
	
	@RequestMapping("/orderDesc")
	public String orderDesc() {
		return "wjh/orderDesc";
	}
	
}
