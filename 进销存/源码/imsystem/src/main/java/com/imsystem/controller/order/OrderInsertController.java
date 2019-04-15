package com.imsystem.controller.order;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Goods;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Paytype;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
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
		
		pay.setId("1");
		
		list.add(pay);
		
		return list;
	}
	
	public List<Supplier> supplierlist(){
		
		List<Supplier> list = new Vector<Supplier>();
		
		Supplier pay = new Supplier();
		
		pay.setName("老王");
		
		pay.setId("1");
		
		list.add(pay);
		
		return list;
	}
	
	public List<Goods> shappinglist(){
		
		List<Goods> list = new Vector<Goods>();
		
		Goods pay = new Goods();
		
		List<Goodsvalue> goodsList =  new Vector<Goodsvalue>();
		
		Goodsvalue goods = new Goodsvalue();
		
		goods.setColumn1("assetc/img/one.jpg");
		
		goods.setColumn2("2");
		
		goods.setDefaultvalue(199);
		
		goods.setId("1");
		
		goods.setName("红色，L");
		
		goods.setJprice(199.99);
		
		goods.setColumn3("399.98");
		
		goodsList.add(goods);
		
		pay.setGoodsValues(goodsList);
		
		pay.setName("老王");
		
		Goods pay1 = new Goods();
		
		List<Goodsvalue> goodsList1 =  new Vector<Goodsvalue>();
		
		Goodsvalue goods1 = new Goodsvalue();
		
		goods1.setColumn1("assetc/img/one.jpg");
		
		goods1.setColumn2("2");
		
		goods1.setName("红色，L");
		
		goods1.setId("2");
		
		goods1.setJprice(199.99);
		
		goods1.setDefaultvalue(198);
		
		goods1.setColumn3("399.98");
		
		goodsList1.add(goods1);
		
		pay1.setGoodsValues(goodsList1);
		
		pay1.setName("老王");
		
		list.add(pay);
		list.add(pay1);
		
		return list;
	}
	
	@RequestMapping("/query")
	public String query(Model model) {
		
		model.addAttribute("paytypeList", paytypeList());
		
		model.addAttribute("supplierlist", supplierlist());
		
		model.addAttribute("shappinglist", shappinglist());
		
		return "wjh/insertOrder";
	}
	
	@RequestMapping("/insertOrder")
	@ResponseBody
	public String insertOrder(@RequestBody Stock stock) {
		
		return orderInsert.insert(stock)+"";
	}
	
	@RequestMapping("/insertOrderOut")
	@ResponseBody
	public String insertOrderOut(@RequestBody Sales sales) {
		
		return orderInsert.insertOut(sales)+"";
	}
	
	@RequestMapping("/uploadInsertOrder")
	@ResponseBody
	public String uploadInsertOrder(@RequestBody Stock stock) {
		
		return orderInsert.updateInsertOrder(stock)+"";
	}
	
	@RequestMapping("/toInsertOrderOut")
	public String toInsertOrderOut(Model model) {
		
		model.addAttribute("paytypeList", paytypeList());
		
		model.addAttribute("supplierlist", supplierlist());
		
		model.addAttribute("shappinglist", shappinglist());
		
		return "wjh/insertOrderOut";
	}
	
	@RequestMapping("/insertSalesorder")
	@ResponseBody
	public String insertSalesorder(@RequestBody Salesorder salesorder) {
		
		return orderInsert.insertSalesorder(salesorder)+"";
	}
	
	@RequestMapping("/toYetOrder")
	public String uploadInsertOrderOut() {
		
		return "wjh/yetOrder";
	}
	
	@RequestMapping("/allot")
	@ResponseBody
	public String allot(@RequestBody Sales sales) {
				
		return orderInsert.allot(sales)+"";
	}
	
}
