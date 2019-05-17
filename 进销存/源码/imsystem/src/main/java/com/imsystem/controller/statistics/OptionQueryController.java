package com.imsystem.controller.statistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.imsystem.domain.GoodsValueVo;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Supplier;
import com.imsystem.service.goods.GoodsService;
import com.imsystem.service.statistics.GoodsValueLableService;
import com.imsystem.service.statistics.GoodsValueService;
import com.imsystem.service.statistics.SalesService;
import com.imsystem.service.statistics.Supplier_yService;

@RestController
@RequestMapping("ther")
public class OptionQueryController {
	@Autowired
	GoodsService gs;
	@Autowired
	Supplier_yService ss;
	@Autowired 
	SalesService salesService;
	@Autowired
	GoodsValueService gvs;
	@Autowired
	GoodsValueLableService gvals;
	
	
	@RequestMapping("queryGoods")
	public List<GoodsValueVo> queryGoods(){
		List<GoodsValueVo> list = gs.queryAllGoods("", null, "");
		return list;
	}
	
	@RequestMapping("querySupplier_yByStore")
	public List<Supplier> querySupplier_yByStore(String sid){
		List<Supplier> list = ss.querySupplier_yByStore(sid);
		return list;
	}
	
	@RequestMapping("queryXf")
	public List<Sales> queryXf(String sid, String startTime, String endTime) {
		List<Sales> list = salesService.queryXf(sid, startTime, endTime);
		if (list.size()>0) {
			for (Sales s : list) {
				List<Goodsvalue> glist = gvs.querySalesByCid(s.getCid(), startTime, endTime);
				s.setGlist(glist);
			}
		}
		return list;
	}
	
	@RequestMapping("queryLikeGoodsValue")
	public List<Goodsvaluelable> queryLikeGoodsValue(String cid,String season){
		List<Goodsvaluelable> list = gvals.querySalesGoodsValueByLable(cid, season);
		List<Goodsvaluelable> l = new ArrayList<>();
		for (Goodsvaluelable gvl : list) {
			List<Goodsvaluelable> ll = gvals.queryByLid(gvl.getId(), season);
			l.addAll(ll);
		}
		for(int i = 0;i<l.size();i++) {
			for(int s = 0;s<l.size();s++) {
				if (l.get(i).getId().equals(l.get(s).getId())) {
					l.remove(s);
				}
			}
		}
		return l;
	}
	
}
