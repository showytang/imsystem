package com.imsystem.controller.customer;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("querycustomertypebyid")
	@ResponseBody
	public Customertype queryCustomerTypeByid(String ctid) {
		return ctService.queryCustomerTypeById(ctid);
	}
	
	@RequestMapping("updatecustomertype")
	public String updateCustomertype(Customertype cusTypeObj) {
		int row=ctService.updateCustomerType(cusTypeObj);
		return "redirect:tocustomertypelist";
	}
	
	public Customertype queryCustomertTypeById(String ctId) {
		Customertype ctObj=ctService.queryCustomerTypeById(ctId);
		return ctObj;
	}
	
	/*@RequestMapping("updatecustomertype")
	public String updateCustomertype(Customertype cusTypeObj) {
		int row=ctService.updateCustomerType(cusTypeObj);
		return "redirect:tocustomertypelist";
	}*/
	
	@RequestMapping("deletecustomertypebyid")
	@ResponseBody
	public int deleteCustomertTypeById(String ctId) {
		int row=ctService.deleteCustomerType(ctId);
		return row;
	}
	
	@RequestMapping("querylikecustomertypelist")
	public String queryLikeCustomerType(String content,Model model) {
		List<QueryCustomerTypeVO> ctListVO=ctService.queryLikeCustomerType(content);
		model.addAttribute("ctList", ctListVO);
		return "lxy/kehuleixing";
	}

}
