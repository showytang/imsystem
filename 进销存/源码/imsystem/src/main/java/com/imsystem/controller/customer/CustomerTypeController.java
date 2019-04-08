package com.imsystem.controller.customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.domain.Customertype;
import com.imsystem.domain.QueryCustomerTypeVO;
import com.imsystem.service.customer.CustomerTypeService;


@Controller
@RequestMapping("customertype")
public class CustomerTypeController {
	
	@Autowired
	CustomerTypeService ctService;
	
	@RequestMapping("tocustomertypelist")
	public String toCustomerList(Model model) {
		List<QueryCustomerTypeVO> ctListVO=ctService.queryAllCustomerType();
		model.addAttribute("ctList", ctListVO);
		return "lxy/kehuleixing";
	}
	
	@RequestMapping("addcustomertype")
	public String addCustomertype(Customertype cusTypeObj) {
		int row=ctService.insertCustomerType(cusTypeObj);
		return "redirect:tocustomertypelist";
	}

}
