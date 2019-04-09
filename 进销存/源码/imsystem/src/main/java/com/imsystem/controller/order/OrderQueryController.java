package com.imsystem.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Stock;
import com.imsystem.service.order.OrderQueryService;

@Controller
@RequestMapping("/orderQueryController")
public class OrderQueryController {

	@Autowired
	OrderQueryService orderquery;
	
	@RequestMapping("/toQuery")
	public String toQuery() {
		
		return "wjh/index";
	}
	

	@RequestMapping("/query")
	@ResponseBody
	public PageInfo<Stock> query(String code,String time,String endTime,Integer currentPage,Integer pageSize,String order) {
		
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		
		PageInfo<Stock> page = orderquery.queryStock(code, time, endTime, currentPage, pageSize,order);
		
		return page;
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
