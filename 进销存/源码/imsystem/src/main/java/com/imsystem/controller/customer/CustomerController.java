package com.imsystem.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Customer;
import com.imsystem.domain.Customerlevel;
import com.imsystem.domain.Customertype;
import com.imsystem.domain.Store;
import com.imsystem.domain.TypeLevelVO;
import com.imsystem.service.customer.CustomerLevelService;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.CustomerTypeService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService cService;
	@Autowired
	CustomerTypeService ctService;
	@Autowired
	CustomerLevelService clService;
	
	@RequestMapping("tocustomerlist")
	public String toCustomerList(Model model) {
		/*List<Customer> clist=cService.queryCustomer();
		model.addAttribute("clist", clist);
		for(Customer cobj:clist) {
			System.out.println(cobj.getName());
		}*/
		return "lxy/Customer";
	}
	
	@RequestMapping("toaddcustomer")
	public String toAddCustomer() {
		return "lxy/AddCustomer";
	}
	
	@RequestMapping("querytypelevel")
	@ResponseBody
	public TypeLevelVO queryTypeAndLevel() {
		TypeLevelVO tlVO=new TypeLevelVO();
		tlVO.setCtlist(ctService.queryAllCustomerType());
		tlVO.setCllist(clService.queryAllCustomerLevel());
		Store s1=new Store(); s1.setId("1"); s1.setName("门店1"); s1.setState(0);
		Store s2=new Store(); s2.setId("2"); s2.setName("门店2"); s2.setState(0);
		List list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		tlVO.setSlist(list);
		return tlVO;
	}
	
	

}
