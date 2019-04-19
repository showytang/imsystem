package com.imsystem.controller.setup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Module;
import com.imsystem.domain.Role;
import com.imsystem.domain.Store;
import com.imsystem.domain.User;
import com.imsystem.service.setup.RoleService;
import com.imsystem.service.setup.StoreService_c;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	StoreService_c storeService_c;
	
	
	@RequestMapping("TianJiaRole")
	public String TianJiaRole() {
		
		return "czx/role-add";
	}
	
	
	
	
	
	
	@RequestMapping("deleteRoleAll")
	@ResponseBody
	public int deleteRoleAll(Integer[] ids) {
		
		int i=roleService.deleteRoleAll(ids);
		
		if(i>1) {
			return 1;
			
		}else  {
			
			return 0;
		}
		
	}
	
	
	
	
	
	
	@RequestMapping("deleteRole")
	@ResponseBody
	public int deleteRole(Integer state, String id) {
		
		 int i=roleService.deleteRole(state, id);
		 
		 System.out.println("deleteRole");
		 
		 System.out.println(state);
		 System.out.println(id);
		 if(i>0) {
			 return 1;
		 }else {
			 return 0;
		 }
		 
	}
	
	@RequestMapping("queryRoleModule")
	public String queryByPage(Role role, Integer pageNum, Integer pageSize,Model model) {
		if (pageNum==null || pageNum==0) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=2;
		}
		PageInfo<Role> page= roleService.queryByPage(role, pageNum, pageSize);
		
		
		System.out.println(JSON.toJSONString(page.getList()));
		model.addAttribute("page",page);
		
		return "czx/admin-role";	
	}
	
	
	
	
	@RequestMapping("queryRoleAll")
	public String XiTongadd(Model model) {
		
		List<Role> list=roleService.queryRoleAll();
		model.addAttribute("list",list);
		List<Store> listStore =storeService_c.queryStoreAll();
		model.addAttribute("listStore", listStore);
		
		System.out.println(JSON.toJSONString(listStore));
		return "czx/admin-add";
	}
	
	
	
	@RequestMapping("admin-cate")
	public String XiTongedit() {
		return "czx/admin-cate";
	}
	
}
