package com.imsystem.controller.monomer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Bit;
import com.imsystem.service.monomer.BitService;

@Controller
@RequestMapping("/bit")
public class BitController {
	@Autowired
	BitService ser;
	
	
	@RequestMapping("/query")
	public String queryBit(Model model) {
		List<Bit> list=ser.queryall();
		model.addAttribute("list", list);
		return "xl/spdanwei";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(String id,String name,String uid) {
		System.out.println("aaaaa");
		Bit bi=new Bit();
		bi.setId(id);
		bi.setName(name);
		bi.setUid(uid);
		
		int r=ser.insertSelective(bi);
		return r;
	}
	
	@RequestMapping("/updatestate")
	public String updatestate(Integer id) {
		ser.updatestate(id);
		return "redirect:query";
	}
	
	
	
	

}
