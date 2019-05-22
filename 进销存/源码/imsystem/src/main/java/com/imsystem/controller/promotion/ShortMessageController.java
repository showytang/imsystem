package com.imsystem.controller.promotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Khshortmessage;
import com.imsystem.domain.Message;
import com.imsystem.service.promotion.ShortMessageService;

@Controller
@RequestMapping("/shortmessage")
public class ShortMessageController {

	
	@Autowired
	private ShortMessageService smSer;
	
	@RequestMapping("/toshortMessage")
	public String toshortMessage(Model model) {
		
		model.addAttribute("customerlist",smSer.queryAllCustomer());
		model.addAttribute("khlist",smSer.queryAllkh());
		
		return "dws/shortmessage";
	}
	
	@RequestMapping("/inertshortMessage")
	@ResponseBody
	public int inertshortMessage(@RequestBody Khshortmessage shortmessage) {
		
		return smSer.inertshortMessage(shortmessage);
		
	}
	
	@RequestMapping("/queryMessage")
	@ResponseBody
	public List<Message> queryMessage(String khid) {
		
		return smSer.queryMessage(khid);
		
	}
	
	public int inertMessage() {
		return 0;
	}
	
	
	
}
