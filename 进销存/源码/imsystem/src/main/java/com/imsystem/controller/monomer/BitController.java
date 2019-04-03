package com.imsystem.controller.monomer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.domain.Bit;
import com.imsystem.service.xl.BitService;

@Controller
@RequestMapping("/bit")
public class BitController {
	@Autowired
	BitService ser;
	
	
	@RequestMapping("/query")
	public String queryBit(Model model) {
		List<Bit> list=ser.selectByExample();
		model.addAttribute("list", list);
		return "xl/spdanwei";
	}
	
	@RequestMapping("/insert")
	public String insert(Bit bi) {
		bi.setUpdatetime(new Date());
		bi.setTime(new Date());
		ser.insert(bi);
		return "redirect:query";
	}
	
	@RequestMapping("/bbb")
	public String AAA() {
		
		return "lxy/Customer";
	}
	
	
	
	

}
