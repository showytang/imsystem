package com.imsystem.controller.customer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.controller.goods.ImgCompress;
import com.imsystem.domain.Customer;
import com.imsystem.domain.Customerlevel;
import com.imsystem.domain.Customertype;
import com.imsystem.domain.Store;

import com.imsystem.domain.Supplier;

import com.imsystem.domain.TypeLevelVO;
import com.imsystem.service.customer.CustomerLevelService;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.CustomerTypeService;
import com.imsystem.service.setup.StoreService_c;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService cService;
	@Autowired
	CustomerTypeService ctService;
	@Autowired
	CustomerLevelService clService;
	@Autowired
	StoreService_c sService;
	
	@RequestMapping("tocustomerlist")

	public String toCustomerList() {
		return "lxy/Customer";
	}
	
	@RequestMapping("toaddcustomer")
	public String toAddCustomer() {
		return "lxy/AddCustomer";
	}
	
	
	
	
	@RequestMapping("querytypelevel")
	@ResponseBody
	public TypeLevelVO queryTypeAndLevel() {
		TypeLevelVO tlVO=new TypeLevelVO();
		tlVO.setCtlist(ctService.queryAllCustomerType());
		tlVO.setCllist(clService.queryAllCustomerLevel());
		tlVO.setSlist(sService.queryStoreAll());
		return tlVO;
	}
	
	@RequestMapping("addcustomer")
	@ResponseBody
	public int addCustomer(MultipartFile files,Customer cObj) {
		
	    try {
	    	if(files!=null) {
	    		InputStream inp = files.getInputStream();
	    		File file = new File(files.getOriginalFilename());
	    		ImgCompress.inputStreamToFile(inp, file);
	    		ImgCompress imgc = new ImgCompress(file);
	    		
	    		cObj.setImg(imgc.resizeFix(400, 400));
	    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    int row=cService.insertCustomer(cObj);
        
		return row;
	}
	
	@RequestMapping("querycustomerlist")
	@ResponseBody
	public PageInfo<Customer> queryCustomerList(Double zero,String content,Integer curentPage,String uid){
		if(curentPage == null || curentPage <= 0 ) {
			curentPage = 1;
		}
		Page<Customer> page=PageHelper.startPage(curentPage, 1, true);
		List<Customer> clist=cService.queryCustomerList(zero, content, curentPage, uid);
		
		PageInfo<Customer> pages=new PageInfo<>(clist);
		return pages;
	}
	
	@RequestMapping("tocustomerdetail")
	public String toCustomerDetail(String id,Model model) {
		model.addAttribute("cid", id);
		return "lxy/CustomerDetail";
	}
	
	@RequestMapping("querylcustomerbyid")
	@ResponseBody
	public Customer queryCustomerById(String id) {
		return cService.queryCustomerById(id);
	}
	
	@RequestMapping("updatecustomer")
	@ResponseBody
	public int updateCustomer(MultipartFile files,Customer cObj) {
		
	    try {
	    	if(files!=null) {
	    		
	    		InputStream inp = files.getInputStream();
	    		File file = new File(files.getOriginalFilename());
	    		ImgCompress.inputStreamToFile(inp, file);
	    		ImgCompress imgc = new ImgCompress(file);
	    		
	    		cObj.setImg(imgc.resizeFix(400, 400));
	    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    int row=cService.updateCustomer(cObj);
        
		return row;
	}
	
	@RequestMapping("deletecustomer")
	public String deleteCustomer(String id) {
		int row=cService.deleteCustomer(id);
		return "redirect:tocustomerlist";
	}
	
	/*没添加路径*/
	@RequestMapping("tocustomersalelist")
	public String toCustomerSaleList(String id,Model model) {
		model.addAttribute("cid", id);
		return "wjh/salesorder";
	}
	
	@RequestMapping("tocustomerincome")
	public String toCustomerIncome(String id,Model model) {
		model.addAttribute("cid", id);
		return "yhb/shouzhang";
	}
	

}
