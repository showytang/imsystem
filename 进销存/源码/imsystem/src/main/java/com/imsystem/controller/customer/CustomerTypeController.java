package com.imsystem.controller.customer;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("customertype")
public class CustomerTypeController {
	
	@RequestMapping("tocustomertypelist")
	public String toCustomerList() {
		/*String rand=UUID.randomUUID().toString();
		System.out.println(rand);*/
		return "xl/kehuleixing";
	}

}
