package com.imsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("all")
public class TestController {

	@RequestMapping("test")
	public String test() {
		return "xl/kehuleixing";
}
	@RequestMapping("page-login")
	public String login() {
		return "czx/page-login";

	}
	@RequestMapping("admin-list")
	public String XiTonglist() {
		return "czx/admin-list";
	}
	@RequestMapping("admin-add")
	public String XiTongadd() {
		return "czx/admin-add";
	}
	@RequestMapping("admin-edit")
	public String XiTongedit() {
		return "czx/admin-edit";
	}
}
