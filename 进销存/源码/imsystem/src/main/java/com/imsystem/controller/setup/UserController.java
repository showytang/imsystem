package com.imsystem.controller.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.domain.User;
import com.imsystem.service.setup.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("page-login")
	public String login() {
		return "czx/page-login";
	}
	
	@RequestMapping("queryByName")
	public String queryByName(String name, String pwd) {
		
	   User user= userService.queryByName(name, pwd);
		 
	   return "";
		 
	}
	
	
}
