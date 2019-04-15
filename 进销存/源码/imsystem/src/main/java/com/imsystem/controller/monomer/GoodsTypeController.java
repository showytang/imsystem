package com.imsystem.controller.monomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Bit;
import com.imsystem.domain.Goodstype;
import com.imsystem.service.monomer.SpTypeService;

@Controller
@RequestMapping("/goods")
public class GoodsTypeController {
	@Autowired
	SpTypeService goods;
	
	
	/*@RequestMapping("querygoods")
	public String  querygoods(Model model,String tiaojian,Integer currentPage,Integer pageSize){
		if("null".equals(tiaojian)) {
			tiaojian  = null;
		}
		if(currentPage == null || currentPage<=1) {
			currentPage = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("tiaojian", tiaojian);
		model.addAttribute("page", goods.queryByLikepage(tiaojian, currentPage, 5));
		System.out.println(goods.queryByLikepage(tiaojian, currentPage, 5).getList());
		return "spleixing";
	}*/
	
	
	@RequestMapping("querygoods")
	public String querygoods() {
		return "xl/spleixing";
	}
	
	
	
	@RequestMapping("querypage")
	@ResponseBody
	public PageInfo<Goodstype> querypage(String tiaojian,Integer currentPage){
		
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		
		PageInfo<Goodstype> page=goods.queryByLikepage(tiaojian, currentPage, 5);
		return page;
	
	}
	

}
