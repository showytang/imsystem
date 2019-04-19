package com.imsystem.controller.order;

import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.domain.Stock;
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
	public String orderOver(String id,Model model) {
		
		model.addAttribute("list",ordermodalservice.orderOver(id));
		
		return "wjh/orderOverDetails";
	}
	
	@RequestMapping("/yetOrder")
	public String yetOrder() {
		return "wjh/yetOrderDetails";
	}
	
	@RequestMapping("/salesOrderDetails")
	public String salesOrderDetails(Model model,String id) {
		
		model.addAttribute("list",ordermodalservice.salesOrderDetails(id));
		
		return "wjh/salesOrderDetsils";
	}
}
