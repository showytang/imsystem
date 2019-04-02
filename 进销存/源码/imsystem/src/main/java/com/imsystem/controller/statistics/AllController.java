package com.imsystem.controller.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Store;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.service.statistics.SalesorderService;

@Controller
@RequestMapping("/statistics")
public class AllController {
	@Autowired
	SalesorderService salesorderS;
	
	@RequestMapping("query")
	@ResponseBody
	public Salesorder query(String storeid, String code, String startTime, String endTime) {
		List<Salesorder> list = salesorderS.query(storeid, code, startTime, endTime);
		Salesorder sale = new Salesorder();
		sale.setTainmoney(0.0);
		sale.setCount(0);
		sale.setColumn1("0");
		for (Salesorder s : list) {
			 sale.setTainmoney(sale.getTainmoney()+s.getTainmoney());
			 sale.setCount(sale.getCount()+s.getCount());
			 sale.setColumn1(Double.parseDouble(sale.getColumn1())+Double.parseDouble(s.getColumn1())+"");
		}
		String lr = sale.getTainmoney() - Double.parseDouble(sale.getColumn1())+"";
		sale.setColumn2(lr);
		String id = salesorderS.queryFirst(storeid, code, startTime, endTime).getStoreid();
		System.out.println(sale.getColumn3());
		System.out.println(sale.getTainmoney()+"\t"+sale.getCount()+"\t"+sale.getColumn2());
		return sale;
	}
}
