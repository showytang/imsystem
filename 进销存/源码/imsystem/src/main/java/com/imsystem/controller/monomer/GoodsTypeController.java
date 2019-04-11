package com.imsystem.controller.monomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Goodstype;
import com.imsystem.service.monomer.GoodsTypeService;

@Controller
@RequestMapping("/goods")
public class GoodsTypeController {
	@Autowired
	GoodsTypeService goods;
	
/*	@RequestMapping("/querypage")
	public String queryByPage(String name,Model model,Integer currentPage) {
		if(currentPage==null) {
			currentPage=1;
		}
		PageInfo<Goodstype> pageInfo = goods.queryByPage(currentPage, 3);
		
		model.addAttribute("page",pageInfo);
		
		
		return "PageQuery";
	
	}*/
}
