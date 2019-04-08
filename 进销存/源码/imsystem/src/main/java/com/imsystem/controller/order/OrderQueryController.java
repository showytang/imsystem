package com.imsystem.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/OrderQueryController")
public class OrderQueryController {

	@RequestMapping("/query")
	public String query() {
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
