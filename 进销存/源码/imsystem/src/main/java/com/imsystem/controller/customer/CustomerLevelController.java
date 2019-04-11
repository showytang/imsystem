package com.imsystem.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Customerlevel;
import com.imsystem.domain.Customertype;
import com.imsystem.domain.QueryCustomerLevelVO;
import com.imsystem.domain.QueryCustomerTypeVO;
import com.imsystem.service.customer.CustomerLevelService;

@Controller
@RequestMapping("customerlevel")
public class CustomerLevelController {
	
	@Autowired
	CustomerLevelService clService;
	
	@RequestMapping("tocustomerlevellist")
	public String toCustomerLevelList(Model model) {
		List<QueryCustomerLevelVO> clListVO=clService.queryAllCustomerLevel();
		model.addAttribute("clList", clListVO);
		return "lxy/kehujibie";
	}
	
	@RequestMapping("addcustomerlevel")
	public String addCustomertype(Customerlevel cusLevelObj) {
		int row=clService.insertCustomerLevel(cusLevelObj);
		return "redirect:tocustomerlevellist";
	}
	
	@RequestMapping("querycustomerlevelbyid")
	@ResponseBody
	public Customerlevel queryCustomertLevelById(String clId) {
		Customerlevel clObj=clService.queryCustomerLevelById(clId);
		return clObj;
	}
	
	@RequestMapping("updatecustomerlevel")
	public String updateCustomerLevel(Customerlevel cusLevelObj) {
		int row=clService.updateCustomerLevel(cusLevelObj);
		return "redirect:tocustomerlevellist";
	}
	
	@RequestMapping("deletecustomerlevelbyid")
	@ResponseBody
	public int deleteCustomertLevelById(String clId) {
		int row=clService.deleteCustomerLevel(clId);
		return row;
	}
	
	@RequestMapping("querylikecustomerlevellist")
	public String queryLikeCustomerLevel(String content,Model model) {
		List<QueryCustomerLevelVO> clListVO=clService.queryLikeCustomerLevel(content);
		model.addAttribute("clList", clListVO);
		return "lxy/kehujibie";
	}

}
