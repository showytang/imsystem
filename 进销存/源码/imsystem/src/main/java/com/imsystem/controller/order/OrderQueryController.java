package com.imsystem.controller.order;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockrecord;
import com.imsystem.domain.Store;
import com.imsystem.service.order.OrderQueryService;

@Controller
@RequestMapping("/orderQueryController")
public class OrderQueryController {

	@Autowired
	OrderQueryService orderquery;

	@RequestMapping("/toQuery")
	public String toQuery() {

		return "wjh/index";
	}

	public Vector<Store> store() {

		Vector<Store> store = new Vector<Store>();

		Store sto = new Store();

		sto.setId("1");

		sto.setName("株洲百货");

		Store sto1 = new Store();

		sto1.setId("11");

		sto1.setName("百货");

		store.add(sto1);
		store.add(sto);

		return store;
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

		model.addAttribute("clientList",store());
		
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

	@RequestMapping("/yetQuery")
	public String yetQuery() {
		return "wjh/yetOrder";
	}

	@RequestMapping("/orderOver")
	public String orderOver() {
		return "wjh/orderOver.html";
	}

	@RequestMapping("/orderDesc")
	public String orderDesc() {
		return "wjh/orderDesc";
	}

}