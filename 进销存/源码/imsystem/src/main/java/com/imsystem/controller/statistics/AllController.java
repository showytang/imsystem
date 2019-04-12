package com.imsystem.controller.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Store;
import com.imsystem.service.statistics.GoodsValueService;
import com.imsystem.service.statistics.SalesorderService;
import com.imsystem.service.statistics.StoreService;

@Controller
@RequestMapping("/statistics")
public class AllController {
	@Autowired
	SalesorderService salesorderS;
	@Autowired
	StoreService storeS;
	@Autowired
	GoodsValueService gvs;
	
	@RequestMapping("query")
	@ResponseBody
	public Salesorder query(String storeid, String code, String startTime, String endTime) {
		List<Salesorder> list = salesorderS.query(storeid, code, startTime, endTime);
		Salesorder sale = new Salesorder();
		sale.setPaymoney(0.0);
		sale.setCount(0);
		sale.setColumn2("0");
		sale.setColumn3("暂无数据");
		sale.setColumn1("0");
		int sum = 0;
		for (Salesorder s : list) {
			 sum+=1;
			 sale.setPaymoney(sale.getPaymoney()+s.getPaymoney());
			 sale.setColumn1(Double.parseDouble(sale.getColumn1())+Double.parseDouble(s.getColumn1())+"");//计算成本
		}
		sale.setCount(sum);//今日订单量
		if (list.size()>0) {
			String lr = sale.getPaymoney() - Double.parseDouble(sale.getColumn1())+"";
			sale.setColumn2(lr);//利润
			String id = salesorderS.queryFirst(storeid, code, startTime, endTime).getStoreid();//查询今日销量冠军
			Store store = storeS.selectByPrimaryKey(id);
			sale.setColumn3(store.getName()+"【"+store.getSufname()+"】");//今日销量冠军
		}
		return sale;
	}
	/**
	 * By cody 查询商品
	 * @param code
	 * @return
	 */
	@RequestMapping("queryByCode")
	@ResponseBody
	public List<Goodsvalue> queryByCode(String code){
		List<Goodsvalue> list = gvs.queryByCode(code);
		return list;
	}
	/**
	 * index top 四方格
	 * @param storeid
	 * @return
	 */
	@RequestMapping("queryDaysAgo")
	@ResponseBody
	public List<Salesorder> queryDaysAgo(String storeid){
		List<Salesorder> list = salesorderS.queryDaysAgo(storeid);
		if (list.size()>0) {
			for (Salesorder s : list) {
				s.setList(gvs.queryByCode(s.getId()));
			}
		}
		return list;
	}
	/***
	 * 查询店铺排名
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("queryRanking")
	@ResponseBody
	public List<Salesorder> queryRanking(String startTime, String endTime){
		List<Salesorder> list = salesorderS.queryRanking(startTime, endTime);
		if (list.size()>0) {
			for (Salesorder ss : list) {
				Integer tedayMoney = salesorderS.queryTedayMoney(ss.getStoreid());
				if (tedayMoney != null) {
					ss.setColumn2(tedayMoney+"");
				}else {
					ss.setColumn2("0");
				}
				List<Goodsvalue> l = gvs.queryByCode(ss.getId());
				if (l.size()>0) {
					ss.setList(l);
				}
			}
		}
		return list;
	}
	
	@RequestMapping("queryThisYear")
	@ResponseBody
	public List<Salesorder> queryThisYear(String year,String storeId) {
		List<Salesorder> list = salesorderS.queryThisYear(year);
		if (list.size()>0) {
			for (Salesorder ss : list) {
				List<Goodsvalue> gv = gvs.queryGoodsByTime(ss.getColumn3(),"","",storeId);
				if (gv.size()>0) {
					ss.setList(gv);
				}
			}
		}
		return list;
	}
	@RequestMapping("queryGoodsRanking")
	@ResponseBody
	public List<Goodsvalue> queryGoodsRanking(String time,String startTime,String endTime,String storeId){
		List<Goodsvalue> list = gvs.queryGoodsByTime(time, startTime, endTime, storeId);
		return list;
	}
}
