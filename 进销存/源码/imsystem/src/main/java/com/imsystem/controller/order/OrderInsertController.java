package com.imsystem.controller.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Goods;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Paytype;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Supplier;
import com.imsystem.service.customer.SupplierService;
import com.imsystem.service.monomer.paytypeService;
import com.imsystem.service.order.OrderInsertService;

@RequestMapping("/insertOrder")
@Controller
public class OrderInsertController {

	@Autowired
	OrderInsertService orderInsert;
	
	@Autowired
	paytypeService paytype;
	
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("/query")
	public String query(Model model) {
		
		model.addAttribute("paytypeList", paytype.queryPaytype(null));
		
		model.addAttribute("supplierlist", supplierService.queryDealOrderSupplier("1"));
		
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/insertOrder")
	@ResponseBody
	public String insertOrder(@RequestBody Stock stock) {
		
		return orderInsert.insert(stock)+"";
	}
	
	@RequestMapping("/insertOrderOut")
	@ResponseBody
	public String insertOrderOut(@RequestBody Salesorder sales) {
		
		return orderInsert.insertOrderOut(sales)+"";
	}
	
	@RequestMapping("/uploadInsertOrder")
	@ResponseBody
	public String uploadInsertOrder(@RequestBody Stock stock) {
		
		return orderInsert.updateInsertOrder(stock)+"";
	}
	
	@RequestMapping("/toInsertOrderOut")
	public String toInsertOrderOut(Model model) {
		
		model.addAttribute("paytypeList", paytype.queryPaytype(null));
		
		model.addAttribute("supplierlist", supplierService.queryDealOrderSupplier("1"));
		
		return "wjh/insertOrderOut";
	}
	
	@RequestMapping("/insertSalesorder")
	@ResponseBody
	public String insertSalesorder(@RequestBody Salesorder salesorder) {
		
		return orderInsert.insertSalesorder(salesorder)+"";
	}
	
	@RequestMapping("/allot")
	@ResponseBody
	public String allot(@RequestBody Vector<Stockdetails> stockdetail) {
				
		return orderInsert.allot(stockdetail)+"";
	}
	
	
	@RequestMapping("/inserorderDesc")
	@ResponseBody
	public String inserorderDesc(@RequestBody Vector<Salesdetails> salesdetails) {
				
		return orderInsert.inserorderDesc(salesdetails)+"";
	}
	
	@RequestMapping("/updateSalesOrder")
	@ResponseBody
	public String UpdateSalesOrder(@RequestBody Salesorder sales) {
		
		return orderInsert.UpdateSalesOrder(sales)+"";
	}
	@RequestMapping("/test")
	public void test(HttpServletRequest request) {

		Cookie [] cookie =  request.getCookies();
		
		for (Cookie item : cookie) {
			
			if(item.getName().equals("list")) {
				
				System.out.println(item.getValue());
			
			}
			
		}
		
	}
	
}
