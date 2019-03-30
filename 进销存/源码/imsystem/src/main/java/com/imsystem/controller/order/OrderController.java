package com.imsystem.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
@Controller
public class OrderController {

	@RequestMapping("/show")
	public String show() {
		return "wjh/allot";
	}
	
}
