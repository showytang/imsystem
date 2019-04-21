package com.imsystem.controller.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.imsystem.domain.GoodsValueVo;
import com.imsystem.domain.Supplier;
import com.imsystem.service.goods.GoodsService;
import com.imsystem.service.statistics.Supplier_yService;

@RestController
@RequestMapping("ther")
public class OptionQueryController {
	@Autowired
	GoodsService gs;
	@Autowired
	Supplier_yService ss;
	
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
	
}
