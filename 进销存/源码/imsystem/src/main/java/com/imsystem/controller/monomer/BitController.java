package com.imsystem.controller.monomer;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Bit;
import com.imsystem.service.monomer.BitService;

import io.lettuce.core.dynamic.annotation.Param;

@Controller
@RequestMapping("/bit")
public class BitController {
	@Autowired
	BitService ser;
	
	@RequestMapping("/query")
	public String queryBit(Model model) {
		return "xl/spdanwei";
	}
	
	@RequestMapping( value= {"/toquery/{text}/{currentPage}","/toquery/{currentPage}"})
	@ResponseBody
	public PageInfo<Bit> queryByLikepage(@PathVariable(required=false) String text ,@PathVariable Integer currentPage){
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		
		PageInfo<Bit> page=ser.queryByLikepage(text, currentPage, 5);
		
		return page;
		
	}
	
	
	@RequestMapping("/updatestate")
	public String updatestate(Integer id) {
		ser.updatestate(id);
		return "redirect:/bit/query";
	}
	
	
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(String id,String name,String uid) {
		
		Bit bi=new Bit();
		bi.setId(id);
		bi.setName(name);
		bi.setUid(uid);
		System.out.println(bi);
		int r=ser.insertSelective(bi);
		return r;
	}
	
	@RequestMapping("/querybyid")
	@ResponseBody
	public Bit update(String id) {
		Bit bit=ser.querybyid(id);
		return bit;
	}
	
	@RequestMapping("/toupdate")
	@ResponseBody
	public int  toupdate(Bit bit){
		int r=ser.toupdate(bit);
		return r;
	}
	
	
	
	
	
	/*@RequestMapping("/query")
	public String queryBit(Model model) {
		List<Bit> list=ser.queryall();
		model.addAttribute("list", list);
		return "xl/spdanwei";
	}*/
	
	/*@RequestMapping("/query")
	public String queryByPage(Model model,Integer currentPage) {
		
		if(currentPage==null) {
			
			currentPage=1;
		
		}
		
		PageInfo<Bit> pageInfo=ser.querybit(currentPage, 5);
		
		model.addAttribute("pageInfo", pageInfo);
		
		return "xl/spdanwei";
	}
	@RequestMapping("queryBit")
	@ResponseBody
	public PageInfo<Bit> queryBit(Integer currentPage){

		PageInfo<Bit> pageInfo=ser.querybit(currentPage, 5);
		
		return pageInfo;
	}
	
	@RequestMapping("/queryByLike")
	@ResponseBody
	public PageInfo<Bit> queryByLikepage(String text ,Integer currentPage){
		PageInfo<Bit> pageInfo=ser.queryByLikepage(text, currentPage, 5);
		return pageInfo;
		
	}
	
	
	*/
	
	
	
	}

