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
import com.imsystem.util_y.Sending;

@Controller
@RequestMapping("/shortmessage")
public class ShortMessageController {

	
	@Autowired
	private ShortMessageService smSer;
	
	/**
	 * 跳转客户群页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toshortMessage")
	public String toshortMessage(Model model) {
		
		model.addAttribute("customerlist",smSer.queryAllCustomer());
		model.addAttribute("khlist",smSer.queryAllkh());
		
		return "dws/shortmessage";
	}
	
	/**
	 * 新增客户群
	 */
	@RequestMapping("/inertshortMessage")
	@ResponseBody
	public int inertshortMessage(@RequestBody Khshortmessage shortmessage) {
		
		return smSer.inertshortMessage(shortmessage);
		
	}
	
	/**
	 * 查询历史短信
	 * @param khid 客户群id
	 * @return
	 */
	@RequestMapping("/queryMessage")
	@ResponseBody
	public List<Message> queryMessage(String khid) {
		
		return smSer.queryMessage(khid);
		
	}
	
	/**
	 * 新增短信
	 * @param message
	 * @return
	 */
	@RequestMapping("/inertMessage")
	@ResponseBody
	public int inertMessage(@RequestBody List<Message> message) {
		//mobileQuery
		
		for(Message m:message) {
			for(String phone:m.getPhones()) {
				Sending.mobileQuery(phone, "160070");
			}
		}
		
		
		return smSer.inertMessage(message);
	}
	
	
	
}
