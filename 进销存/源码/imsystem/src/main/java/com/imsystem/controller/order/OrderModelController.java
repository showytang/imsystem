package com.imsystem.controller.order;

import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.service.order.OrderModalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/orderModel")
public class OrderModelController {

	@Autowired
	OrderModalService ordermodalservice;
	
	@RequestMapping("/queryIndex")
	public String queryIndex(String code,Model model) {
		
		model.addAttribute("list",ordermodalservice.queryIndex(code));
		
		return "wjh/indexDatail";
	}
	
	@RequestMapping("/queryIndexAllot")
	public String queryIndexAllot(String code,Model model) {
		
		model.addAttribute("list",ordermodalservice.queryIndex(code));
		
		return "wjh/indexAllotDatail";
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
