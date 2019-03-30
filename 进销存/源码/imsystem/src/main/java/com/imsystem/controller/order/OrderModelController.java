package com.imsystem.controller.order;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/orderModel")
public class OrderModelController {

	@RequestMapping("/queryIndex")
	public String queryIndex() {
		return "wjh/indexDatail";
	}
	
	@RequestMapping("/orderDesc")
	public String orderDesc() {
		return "wjh/orderDescDetails";
	}
	
	@RequestMapping("/orderOver")
	public String orderOver() {
		return "wjh/orderOverDetails";
	}
	
	@RequestMapping("/yetOrder")
	public String yetOrder() {
		return "wjh/yetOrderDetails";
	}
}
