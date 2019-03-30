package com.imsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("all")
public class TestController {
	@RequestMapping("test")
	public String test() {
		return "lxy/AddCustomer";
	}
}

//goods/customePickGoods
