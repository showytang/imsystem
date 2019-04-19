package com.imsystem.controller.monomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Paytype;
import com.imsystem.domain.Standard;
import com.imsystem.service.monomer.paytypeService;

@Controller
@RequestMapping("/paytype")
public class paytypeController {
	@Autowired
	paytypeService service;
	
	@RequestMapping("/querypaytype")
	public String querypaytype() {
		return "xl/zhifuleixing";
	}
	
	@RequestMapping("/querypage")
	@ResponseBody
	public PageInfo<Paytype> querypage(String tiaojian,Integer currentPage){
		
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		PageInfo<Paytype> page=service.queryByLikepage(tiaojian, currentPage, 5);
		return page;
	
	}
	
	@RequestMapping("/delete")
	public String delete(String id) {
		service.updatedelete(id);
		return "redirect:/paytype/querypaytype";
	}
	
	@RequestMapping("/byid")
	@ResponseBody
	public Paytype queryPaytypeById(String id) {
		Paytype paytype=service.paytypeById(id);
		return paytype;
	}
	
	@RequestMapping("/toupdate")
	@ResponseBody
	public int toupdate(Paytype paytype) {
		int r=service.toupdate(paytype);
		return r;
		
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(Paytype paytype) {
		int r=service.insertPaytype(paytype);
		return r;
	}

}
