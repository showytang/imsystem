package com.imsystem.controller.order;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesback;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Salesorderdetails;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Stockrecord;
import com.imsystem.domain.Store;
import com.imsystem.domain.Supplier;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.SupplierService;
import com.imsystem.service.order.OrderQueryService;
import com.imsystem.service.setup.StoreService_c;

@Controller
@RequestMapping("/orderQueryController")
public class OrderQueryController {

	@Autowired
	OrderQueryService orderquery;
	
	@Autowired
	SupplierService supplier;
	
	@Autowired
	CustomerService curstomerservice;

	@Autowired
	StoreService_c store;
	
	@RequestMapping("/toQuery")
	public String toQuery() {

		return "wjh/index";
	}

	@RequestMapping("/query")
	@ResponseBody
	public PageInfo<Stock> query(String code, String time, String endTime, Integer currentPage, Integer pageSize,
			String order, Integer kucun) {

		if (currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}

		PageInfo<Stock> page = orderquery.queryStock(code, time, endTime, currentPage, pageSize, order, kucun);

		return page;
	}

	@RequestMapping("/toQueryAllot")
	public String toQueryAllot(Model model) {

		model.addAttribute("clientList",store.queryStoreAll());
		
		return "wjh/allot";
	}

	@RequestMapping("/queryAllot")
	@ResponseBody
	public Vector<Stockrecord> queryAllot(String time, String endTime, String code, String jcode) {

		return orderquery.queryAllot(time, endTime, code, jcode);
	}
	
	@RequestMapping("/toAllotDetails")
	public String toAllotDetails(Model modal,String id) {
		
		Vector<Stockrecord> stock = orderquery.queryAllotDetails(id);
		
		modal.addAttribute("stockcored",stock);
		
		return "wjh/allotDetails";
	}
	
	@RequestMapping("/toGoodsAllot")
	public String toGoodsAllot(Model model) {
		
		model.addAttribute("li", store.queryStoreAll());
		
		return "wjh/indexAllotDatail";
	}
	
	@RequestMapping("/goodsAllot")
	@ResponseBody
	public Vector<Stockdetails> goodsAllot(String name){
		return orderquery.queryGoods(name);
	}
	
	@RequestMapping("/queryDetails")
	@ResponseBody
	public Vector<Stockdetails> queryDetails(String gvid){
		
		return orderquery.queryDetails(gvid);
	}

	
	@RequestMapping("/querySalesOrder")
	@ResponseBody
	public PageInfo<Salesorder> querySalesOrder (Salesorder sales) {
		
		return orderquery.querySalesOrder(sales);
	}
	
	@RequestMapping("/toSalesOrder")
	public String toSalesOrder() {
		
		return "wjh/salesorder";
	}
	
	
	@RequestMapping("/toYetQuery")
	public String yetQuery() {
		return "wjh/yetOrder";
	}

	@RequestMapping("/toOrderOver")
	public String toOrderOver() {
		return "wjh/orderOver";
	}

	@RequestMapping("/orderDesc")
	public String orderDesc() {
		return "wjh/orderDesc";
	}
	
	@RequestMapping("/salesOrderById")
	@ResponseBody
	public Salesorder salesOrderById(String id) {
		
		return orderquery.salesOrderById(id);
	}
	
	@RequestMapping("/orderOver")
	@ResponseBody
	public PageInfo<Sales> OrderOver(String code,String endTime,String time,Integer currentPage) {
		
		return orderquery.OrderOver(code, endTime, time, currentPage);
	}
	
	@RequestMapping("/toderDescQuery")
	@ResponseBody
	public PageInfo<Salesback> orderDescQuery(@RequestBody Salesback back){
		return orderquery.orderDescQuery(back);
	}
	
	@RequestMapping("/querySupper")
	@ResponseBody
	public List<Supplier> querySupper(String name){
		
		return supplier.queryByName(name);
	}
	
	@RequestMapping("/queryCustomer")
	@ResponseBody
	public List<Customer> queryCustomer(){
		
		return curstomerservice.queryCustomerByStore("1");
	}
	
	
	
	
}