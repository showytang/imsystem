package com.imsystem.controller.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.domain.Goods;
import com.imsystem.domain.Paytype;
import com.imsystem.domain.Salesstockrecord;
import com.imsystem.domain.Supplier;
import com.imsystem.service.order.OrderInsertService;

@RequestMapping("/insertOrder")
@Controller
public class OrderInsertController {

	@Autowired
	OrderInsertService orderInsert;
	
	public List<Paytype> paytypeList(){
		List<Paytype> list = new Vector<Paytype>();
		
		Paytype pay = new Paytype();
		
		pay.setName("微信");
		
		list.add(pay);
		
		return list;
	}
	
	public List<Supplier> supplierlist(){
		List<Supplier> list = new Vector<Supplier>();
		
		Supplier pay = new Supplier();
		
		pay.setName("老王");
		
		list.add(pay);
		
		return list;
	}
	
	public List<Goods> shappinglist(){
		List<Goods> list = new Vector<Goods>();
		
		Goods pay = new Goods();
		
		pay.setName("老王");
		
		list.add(pay);
		
		return list;
	}
	
	@RequestMapping("/query")
	public String query(Model model) {
		
		model.addAttribute("paytypeList", paytypeList());
		
		model.addAttribute("supplierlist", supplierlist());
		
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/insertOrder")
	public String insertOrder(Salesstockrecord sales) {
		
		orderInsert.insert(sales);
		
		return "wjh/yetOrder";
	}
	
	@RequestMapping("/insertOrderOut")
	public String insertOrderOut() {
		return "wjh/index";
	}
	
	@RequestMapping("/toInsertOrder")
	public String toInsertOrder() {
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/uploadInsertOrder")
	public String uploadInsertOrder() {
		return "wjh/yetOrder";
	}
	
	@RequestMapping("/toInsertOrderOut")
	public String toInsertOrderOut() {
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/uploadInsertOrderOut")
	public String uploadInsertOrderOut() {
		return "wjh/yetOrder";
	}
	
	
	
	
	
}
