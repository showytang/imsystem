package com.imsystem.controller.monomer;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Standard;
import com.imsystem.domain.Standardvalue;
import com.imsystem.service.monomer.GoodsStandardService;
import com.imsystem.service.monomer.StandardvalueService;

@Controller
@RequestMapping("/StandardValue")
public class GoodsStandardValueController {
	@Autowired
	StandardvalueService service;
	
	@Autowired
	GoodsStandardService ser;
	
	@RequestMapping("/queryStandarvalue")
	public String querystandarvalue(Model model) {
		List<Standard> list=ser.queryStandard(null);
		model.addAttribute("list", list);
		return "xl/guigezhi";
	}
	
	@RequestMapping("/querypage")
	@ResponseBody
	public PageInfo<Standardvalue> querypage(String tiaojian,Integer currentPage){
		
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		
		PageInfo<Standardvalue> page=service.queryByLikepage(tiaojian, currentPage, 5);
		return page;
	
	}
	
	@RequestMapping("/delete")
	public String delete(String id) {
		service.updatedelete(id);
		return "redirect:/StandardValue/queryStandarvalue";
		
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(Standardvalue stan) {
		Standardvalue standard=service.queryByname(stan.getName(), stan.getSid());
		if(standard==null) {
			String id=UUID.randomUUID().toString();
			stan.setId(id);
			int r=service.insertStandardvalue(stan);
			return r;
		}else {
			return 0;
		}
		
	}
	
	@RequestMapping("/byid")
	@ResponseBody
	public Standardvalue byid(String id) {
		Standardvalue stan=service.StandardvalueById(id);
		
		return stan;
	}
	
	@RequestMapping("/toupdate")
	@ResponseBody
	public int toupdate(Standardvalue stan) {
		Standardvalue standard=service.queryByname(stan.getName(), stan.getSid());
		if(standard==null) {
			String id=UUID.randomUUID().toString();
			stan.setId(id);
			int r=service.toupdate(stan);
			return r;
		}else {
			return 0;
		}
		
		
	}

}
