package com.imsystem.controller.setup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Module;
import com.imsystem.domain.Role;
import com.imsystem.domain.Rolemodule;
import com.imsystem.domain.Store;
import com.imsystem.domain.User;
import com.imsystem.service.setup.ModuleService;
import com.imsystem.service.setup.RoleModuleService;
import com.imsystem.service.setup.RoleService;
import com.imsystem.service.setup.StoreService_c;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	StoreService_c storeService_c;
	
	
	@Autowired
	RoleModuleService roleModuleService;
	
	@Autowired
	ModuleService moduleService;
	
	
	
	
	
	
	
	
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
	
	
	
	@RequestMapping("queryRoleById")
	public String queryRoleById(String id,Model model) {
		
		
		
		
		Role r=roleService.queryRoleById(id);
		
		System.out.println(JSON.toJSONString(r));
		model.addAttribute("r", r);
		
		List<Module> list=moduleService.selectModuleAll(0+"");
		
		model.addAttribute("module", list);
		
		return "czx/role-update";
		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("insertRole")
	@ResponseBody
	public int insertRole(@RequestBody Role role,HttpSession session) {
		 
		
		 User user1 = (User)session.getAttribute("user");
		String id = "" ;
		String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
		String sdf = new SimpleDateFormat("yyyyMMddss").format(new Date());
		id = trandNo.toString().substring(0, 4); 
		id = id + sdf ;
		role.setId(id);
		role.setUid(user1.getId());
		 
		
		 for (Rolemodule r : role.getRmlist()) {
				String id2 = "" ;
				String trandNo2 = String.valueOf((Math.random() * 9 + 1) * 1000000);
				String sdf2 = new SimpleDateFormat("yyyyMMddss").format(new Date());
				id2 = trandNo2.toString().substring(0, 4); 
				id2 = id2 + sdf2 ;
				r.setId(id2);
				r.setRid(id);
				r.setUid(user1.getId());
		}
		 roleService.insertRole(role);
		 return 0;
	}
	
	
	
	@RequestMapping("queryRoleAll")
	public String XiTongadd(Model model) {
		
		
		
		List<Role> list=roleService.queryRoleAll();
		model.addAttribute("list",list);
		List<Store> listStore =storeService_c.queryStoreAll();
		model.addAttribute("listStore", listStore);
		
		return "czx/admin-add";
	}
	
	
	
	@RequestMapping("updateRoleById")
	@ResponseBody
	public int updateRoleById(@RequestBody Role role,HttpSession session) {
		User user1 = (User)session.getAttribute("user");
		
		System.out.println("兄弟 进来了");
		
		System.out.println(role.getId());
		
		System.out.println(role.getName());
		
		role.setName(role.getName());
		
		role.setUid(user1.getId());
		
		roleService.updateRoleById(role);
		
//		roleModuleService.deleteRoleModuleByRid(role.getId());
		
		
		
		
		
		return 0;
		
		
	}
	
	
	
	
	
	
	@RequestMapping("selectModuleAll")
	public String queryModuleAll(Model model){
		
		List<Module> list=moduleService.selectModuleAll(0+"");
		
		model.addAttribute("module", list);
		
		return "czx/role-add";
		
	}
	
	
	
	

	
	
	
	
	
	@RequestMapping("admin-cate")
	public String XiTongedit() {
		return "czx/admin-cate";
	}
	
}
