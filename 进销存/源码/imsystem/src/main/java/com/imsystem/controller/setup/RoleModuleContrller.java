package com.imsystem.controller.setup;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.imsystem.domain.Module;
import com.imsystem.domain.Role;
import com.imsystem.domain.Rolemodule;
import com.imsystem.domain.User;
import com.imsystem.service.setup.ModuleService;
import com.imsystem.service.setup.RoleModuleService;

@Controller
@RequestMapping("/rolemodule")
public class RoleModuleContrller {

	@Autowired
	RoleModuleService rolemoduleService;
	
	
	@Autowired
	ModuleService moduleService;
	
	
	
	
		
}
