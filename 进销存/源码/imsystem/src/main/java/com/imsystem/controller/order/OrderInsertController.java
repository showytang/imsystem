package com.imsystem.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/insertOrder")
@Controller
public class OrderInsertController {

	@RequestMapping("/query")
	public String query() {
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/insertOrder")
	public String insertOrder() {
		return "wjh/yetOrder";
	}
	
	@RequestMapping("/insertOrderOut")
	public String insertOrderOut() {
		return "wjh/index";
	}
	
	@RequestMapping("/toInsertOrder")
	public String toInsertOrder() {
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/uploadInsertOrder")
	public String uploadInsertOrder() {
		return "wjh/yetOrder";
	}
	
	@RequestMapping("/toInsertOrderOut")
	public String toInsertOrderOut() {
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/uploadInsertOrderOut")
	public String uploadInsertOrderOut() {
		return "wjh/yetOrder";
	}
	
	
	
	
	
}
