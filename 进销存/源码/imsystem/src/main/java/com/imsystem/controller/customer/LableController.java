package com.imsystem.controller.customer;

import java.io.File;
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
import com.imsystem.domain.Customer;
import com.imsystem.domain.Customerlevel;
import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.Noticefiles;
import com.imsystem.domain.Store;
import com.imsystem.domain.UserLableVO;
import com.imsystem.domain.Userlable;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.LableService;
import com.imsystem.service.customer.NewsService;

@Controller
@RequestMapping("lable")
public class LableController {
	
	@Autowired
	LableService lService;
	
	@RequestMapping("tolablelist")
	public String toNewsList(Model model) {
		List<Userlable> ulList=lService.queryLableList();
		model.addAttribute("lList", ulList);
		return "lxy/UserLable";
	}
	
	@RequestMapping("addlable")
	public String addCustomertype(Userlable ulobj) {
		int row=lService.addLabel(ulobj);
		return "redirect:tolablelist";
	}
	
	@RequestMapping("querylablebyid")
	@ResponseBody
	public Userlable queryLableById(String lid) {
		return lService.queryLableById(lid);
	}
	
	@RequestMapping("updatelable")
	public String updateLable(Userlable ulobj) {
		int row=lService.updateLabel(ulobj);
		return "redirect:tolablelist";
	}
	
	/*用户和标签controller*/
	
	@RequestMapping("toadduserlabel")
	public String toAddUserLabel() {
		return "lxy/UserChooseLable";
	}
	
	@RequestMapping("querycustomer")
	@ResponseBody
	public List<Customer> queryCustomer(String uid) {
		return lService.queryCustomer(uid);
	}
	
	@RequestMapping("querycustomerlable")
	@ResponseBody
	public List<UserLableVO> queryCustomerLable(String cid,String name) {
		return lService.queryCustomerLable(cid, name);
	}
	
	@RequestMapping("adduserlable")
	public String addUserLable(UserLableVO ulvo) {
		int row=lService.addUserLable(ulvo);
		return "redirect:toadduserlabel";
	}
	
	
	/*商品实例标签*/
	
	
	@RequestMapping("togoodslablelist")
	public String toList(Model model) {
		List<Goodsvaluelable> ulList=lService.queryGoodsValueLableList();
		model.addAttribute("lList", ulList);
		return "lxy/GoodsValueLable";
	}
	
	@RequestMapping("addgvlable")
	public String addgvlable(Goodsvaluelable gvl) {
		int row=lService.addgvLabel(gvl);
		return "redirect:togoodslablelist";
	}

}
