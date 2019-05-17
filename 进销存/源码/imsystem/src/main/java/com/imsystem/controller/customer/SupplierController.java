package com.imsystem.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Store;
import com.imsystem.domain.Supplier;
import com.imsystem.domain.TypeLevelVO;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.SupplierService;
import com.imsystem.service.setup.StoreService_c;

@Controller
@RequestMapping("supplier")
public class SupplierController {
	
	@Autowired
	SupplierService sService;
	@Autowired
	StoreService_c scService;
	@Autowired
	CustomerService cService;
	
	@RequestMapping("tosupplierlist")
	public String toCustomerList() {
		return "lxy/Supplier";
	}
	
	@RequestMapping("querysupplierlist")
	@ResponseBody
	public PageInfo<Supplier> queryCustomerList(Double zero,String content,Integer curentPage,String uid) {
		
		if(curentPage == null || curentPage <= 0 ) {
			curentPage = 1;
		}
		Page<Supplier> page=PageHelper.startPage(curentPage,1,true);
		List<Supplier> slist = sService.querySupplierList(zero,content,uid);
		PageInfo<Supplier> pages=new PageInfo<>(slist);
		
		return pages;
	}
	
	@RequestMapping("toaddsupplier")
	public String toAddSupplier() {
		return "lxy/AddSupplier";
	}
	
	@RequestMapping("querystoretoaddsupplier")
	@ResponseBody
	public TypeLevelVO queryStore(String uid) {
		TypeLevelVO tlVO=new TypeLevelVO();
		tlVO.setSlist(cService.queryTypeAndLevel(uid).getSlist());
		return tlVO;
	}
	
	@RequestMapping("addSupplier")
	public String addSupplier(Supplier sObj) {
		int row=sService.insertSupplier(sObj);
		return "redirect:tosupplierlist";
	}
	
	@RequestMapping("tosupplierdetail")
	public String toSupplierDetail(String id,Model model) {
		model.addAttribute("sid", id);
		return "lxy/SupplierDetail";
	}
	
	@RequestMapping("querysupplierbyid")
	@ResponseBody
	public Supplier querySupplierById(String id) {
		return sService.querySupplierById(id);
	}
	
	@RequestMapping("updatesupplier")
	public String updateSupplier(Supplier sObj) {
		int row=sService.updatSupplier(sObj);
		return "redirect:tosupplierlist";
	}
	
	@RequestMapping("deletesupplier")
	public String deleteSupplier(String id) {
		int row=sService.deleteSupplier(id);
		return "redirect:tosupplierlist";
	}
	
	/*进货列表*/
	@RequestMapping("tojinhuolist")
	public String toJinHuoList() {
		return "yhb/jinhuo";
	}
	
	@RequestMapping("tosupplierincomelist")
	public String toSupplierIncomeList() {
		return "yhb/qiankuan";
	}
	
	

}
