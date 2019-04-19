package com.imsystem.controller.monomer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Goodstype;
import com.imsystem.domain.Standard;
import com.imsystem.service.monomer.GoodsStandardService;
import com.imsystem.service.monomer.SpTypeService;

@Controller
@RequestMapping("standard")
public class GoodsStandardController {
	@Autowired
	GoodsStandardService service;
	@Autowired
	SpTypeService sp;
	
	@RequestMapping("/queryStandard")
	public String queryStandard(Model model) {
		List<Goodstype>list=sp.querygoodstype(null);
		model.addAttribute("list", list);
		return "xl/spguige";
	}
	
	@RequestMapping("/querypage")
	@ResponseBody
	public PageInfo<Standard> querypage(String tiaojian,Integer currentPage){
		
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		
		PageInfo<Standard> page=service.queryByLikepage(tiaojian, currentPage, 5);
		return page;
	
	}
	
	@RequestMapping("/delete")
	public String delete(String id) {
		service.updatedelete(id);
		return "redirect:/standard/queryStandard";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(Standard stan) {
		int r=service.insertStandard(stan);
		return r;
	}
	
	@RequestMapping("/byid")
	@ResponseBody
	public Standard queryStandardById(String id) {
		Standard stan=service.StandardById(id);
		return stan;
	}
	
	@RequestMapping("toupdate")
	@ResponseBody
	public int toupdate(Standard stan) {
		int r=service.toupdate(stan);
		
		return r;
	}
	
}
