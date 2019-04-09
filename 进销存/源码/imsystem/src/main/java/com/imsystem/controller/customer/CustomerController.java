package com.imsystem.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.domain.Customer;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.impl.CustomerServiceImpl;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@RequestMapping("tocustomerlist")
	public String toCustomerList(Model model) {
		System.out.println("aaaaaa");
		List<Customer> clist=customerService.queryCustomer();
		model.addAttribute("clist", clist);
		for(Customer cobj:clist) {
			System.out.println(cobj.getName());
//			System.out.println("sss");
		}
		return "xl/kehuleixing";
	}
	
	

}
