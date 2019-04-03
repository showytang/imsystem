package com.imsystem.controller.setup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("page-login")
	public String login() {
		return "czx/page-login";

	}
	
}
