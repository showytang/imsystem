package com.imsystem.controller.setup;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("queryUserByName")
	@ResponseBody
	public String queryByName(String name, String pwd,HttpSession session) {
		
		
		 User user= userService.queryUserByName(name, pwd);
		
		 if (user!=null) {
			   session.setAttribute("user", user);
			   return "1";
		  }else {	  
			  return "";
		  }
	   
		 
	}
	
	
}
