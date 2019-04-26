package com.imsystem.controller.setup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Store;
import com.imsystem.domain.User;
import com.imsystem.service.setup.StoreService_c;

@Controller
@RequestMapping("/store")
public class StoreContrller {

	
	@Autowired
	StoreService_c storeService_c;
	
	@RequestMapping("deleteStore")
	@ResponseBody
	public int deleteStoreById(Integer state, String id) {
		 
		 
		 System.out.println("store......");
		
		 System.out.println(state);
		 System.out.println(id);
		 storeService_c.deleteStoreById(state, id);
		 
		 return 1;
	}
	
	
	@RequestMapping("toInsertStore")
	public String city() {
		
		return "czx/city";
	}
	
	
	
	@RequestMapping("insertStore")
	public String  insertStore(Store store,HttpSession session) {
		
		System.out.println("进来了 增加门店");
		 
		User user=(User) session.getAttribute("user");
		
		String id = "" ;
		String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
		String sdf = new SimpleDateFormat("yyyyMMddss").format(new Date());
		id = trandNo.toString().substring(0, 4); 
		id = id + sdf ;
		
		
		Store  parented=storeService_c.SelectZongDian();
		System.out.println(parented);
		store.setId(id);
		
		if(store.getSufname()=="总店") {
			store.setParented(0+"");
		}else {
			store.setParented(parented.getId());
		}
		
		store.setUid(user.getId());
		
		int i=storeService_c.insertStore(store);
		 
		return "redirect:queryStore";
	}
	
	
	@RequestMapping("queryStoreById")
	public String selectByPrimaryKey(String id,Model model) {
		
		Store store= storeService_c.selectByPrimaryKey(id);
		
		model.addAttribute("st", store);
		
		return "czx/store-update";
	}
	
	
	@RequestMapping("updateStore")
	public String updateByPrimaryKey(Store store,HttpSession session) {
		 
		 User user=(User) session.getAttribute("user");
		 
		 store.setUid(user.getId());
		 
		 storeService_c.updateByPrimaryKey(store);
		 
		 
		 return "redirect:queryStore";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("deleteAll")
	public int deleteAll(Integer[] ids) {
		
		 storeService_c.deleteAll(ids);
		 
		 return 1;
	}
	
	
	@RequestMapping("queryStore")
	public String queryUserRole(Model model,Store store, Integer pageNum, Integer pageSize) {
		if (pageNum==null || pageNum==0) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=2;
		}
		
		
		
		PageInfo<Store> page= storeService_c.queryByPage(store, pageNum, pageSize);
		
		model.addAttribute("page",page);
		
		
		return "/czx/Store";	
	}
	
	
}
