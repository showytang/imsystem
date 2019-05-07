package com.imsystem.controller.monomer;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.github.pagehelper.PageInfo;

import com.imsystem.domain.Goodstype;
import com.imsystem.service.monomer.SpTypeService;

@Controller
@RequestMapping("/goods")
public class GoodsTypeController {
	@Autowired
	SpTypeService goods;
	
	
	@RequestMapping("querygoods")
	public String querygoods(Model model) {
		List<Goodstype> list=goods.querybypid();
		model.addAttribute("list", list);
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
	
	@RequestMapping("/delete")
	public String delete(String id) {
		goods.deleteupdate(id);
		return "redirect:/goods/querygoods";
	}
	
	@RequestMapping("insert")
	@ResponseBody
	public int insert(Goodstype good) {
		Goodstype goodstype=goods.querybyname(good.getName(), good.getPid());
		if (goodstype==null) {
			String id=new Date().getTime() +"";
			good.setId(id);
			int r=goods.insertgoodstype(good);
			return r;
		}else {
			return 0;
		}
		
		
		
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Goodstype update(Integer id) {
		Goodstype good=goods.querybyid(id);
		return good;
		
	}
	
	@RequestMapping("toupdate")
	@ResponseBody
	public int toupdate(Goodstype good) {
		Goodstype type=goods.querybyname(good.getName(), good.getPid());
		if (type==null) {
			int r=goods.toupdate(good);
			return r;
		}else {
			return 0;
		}
				
		
	}

}
