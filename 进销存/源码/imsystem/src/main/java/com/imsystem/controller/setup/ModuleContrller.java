package com.imsystem.controller.setup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Module;
import com.imsystem.domain.Role;
import com.imsystem.domain.Rolemodule;
import com.imsystem.domain.User;
import com.imsystem.service.setup.ModuleService;
import com.imsystem.service.setup.RoleModuleService;
import com.imsystem.service.setup.RoleService;

@Controller
@RequestMapping("/module")
public class ModuleContrller {

	
	@Autowired
	ModuleService moduleService;
	
	
	@Autowired
	RoleService roleService;
	
	
	@Autowired
	RoleModuleService roleModuleService;
	
	@RequestMapping("queryModuleAll")
	public String queryUserRole(Model model,Module module, Integer pageNum, Integer pageSize) {
		if (pageNum==null || pageNum==0) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=5;
		}
		
		PageInfo<Module> page= moduleService.queryByPage(module, pageNum, pageSize);
		
		
		List<Module> list= moduleService.queryModuleByParentid(0+"");
		
		model.addAttribute("page",page);
		
		model.addAttribute("list", list);
		
		return "czx/admin-rule";
	}
	
	@RequestMapping("queryModuleByParentid_two")
	@ResponseBody
	public List<Module> queryModuleByParentid(String parentid){
		
		
		
		List<Module> list=moduleService.queryModuleByParentid(parentid+"");
		
		
		return list;
		
	}
	
	
	@RequestMapping("insertModule")
	public String insertModule(Module module,HttpSession session) {
		
		User user=(User) session.getAttribute("user");
		
		String id = "" ;
		String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
		String sdf = new SimpleDateFormat("yyyyMMddss").format(new Date());
		id = trandNo.toString().substring(0, 4); 
		id = id + sdf ;
		module.setId(id);
		
		module.setUid(user.getId());
		
		
		String parentid = "";
		
		System.out.println("id组："+module.getParentid());
		
		
		parentid=module.getParentid().substring(module.getParentid().indexOf(",") + 1);
		System.out.println("1111:"+parentid);
		if(parentid.equals("0")) {
			String parentid1=module.getParentid().substring(0,module.getParentid().indexOf(",") );
			System.out.println("2222:"+parentid1);
			module.setParentid(parentid1);
		}else {
			module.setParentid(parentid);
		}
			
		
		int i=moduleService.insertModule(module);
		
		
		return "redirect:queryModuleAll";
	}
	
	
	@RequestMapping("queryModuleAll_two")
	public String queryModuleAll(Model model){
		
		List<Module> list=moduleService.selectModuleAll(0+"");
		
		List<Role> list2=roleService.queryRoleAll();
		
		model.addAttribute("role", list2);
		
		model.addAttribute("module", list);
		
		return "czx/RoleModule";
		
	}
	
	
	@RequestMapping("queryRoleNoModule")
	@ResponseBody
	public List<Module> queryRoleNoModule(String rid) {
		
		
		List<Module> list=moduleService.queryRoleNoModule(rid);
		 
		return list;
	}
	
	@RequestMapping("deleteModuleById_two")
	@ResponseBody
	public int deleteModuleById_two(Integer state, String id) {
		
		
		 
		 moduleService.deleteModuleById_two(state, id);
		 
		 return 0;
	}
	
	@RequestMapping("deleteModuleAll")
	@ResponseBody
	public int deleteModuleAll(Integer[] ids) {
		
		
		
		
		System.out.println(ids);
		
		 moduleService.deleteModuleAll(ids);
		 
		 return 0;
	}
	
	
	
	
	@RequestMapping("insertRoleModule_two")
	@ResponseBody
	public int insertRoleModule_two(@RequestBody Rolemodule rolemodule,String rid,String uid,HttpSession session) {
		
		User user1 = (User)session.getAttribute("user");
		
		
		
		
		
		
		
		rolemodule.setUid(user1.getId());
		
		
		
		System.out.println("rid-------"+JSON.toJSONString(rolemodule));
		int i=roleModuleService.insertRoleModule_two(rolemodule,rid,uid);
		
		
		
		return 0;
		
	}
	
	
	
	
	@RequestMapping("toModuleupdate")
	public String toModuleupdate(String id,Model model){
		
		
		
		Module module= moduleService.queryModuleById(id);
		
		
		
		model.addAttribute("m", module);
		
		return "czx/module-update";
		
	}
	
	
	
	
	
	@RequestMapping("queryMuLu")
	public String queryMuLu(String rid,Model model,HttpSession session) {
			
		
		System.out.println("进来了 登啊");
		
		
		User user=(User) session.getAttribute("user");
		
		List<Module> list=moduleService.queryMuLu(user.getId(),0+"");
		
		model.addAttribute("list", list);
		
		System.out.println(JSON.toJSONString(list));
		
		
		return "index_on";
	}
	
	
	
	
	@RequestMapping("updateModuleById_two")
	public String updateModuleById_two(String url, String id) {
		 
		
		 
		
		 moduleService.updateModuleById_two(url, id);
		 
		 return "redirect:queryModuleAll";
	}
	
	
	
	
	
	
	
	@RequestMapping("query")
	public void query(HttpServletRequest req,HttpServletResponse resp) {
		resp.setContentType("utf-8");
		resp.setCharacterEncoding("utf-8");
		User u=(User)req.getSession().getAttribute("user");
		List<Module> list=moduleService.queryMuLu(u.getId(), 0+"");
		try {
			resp.getWriter().println(JSON.toJSONString(list));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@RequestMapping("hide")
	public void hide(String []urls,HttpServletRequest req,HttpServletResponse resp) {
		User u=(User)req.getSession().getAttribute("user");
		
		Map<String,Module>maps=moduleService.queryMap(u.getUid());
		List<String>ulist=new ArrayList<String>();
		for (String s : urls) {
			if(maps.get(s)==null) {
				ulist.add(s);
			}
		}
		try {
			resp.getWriter().println(JSON.toJSONString(ulist));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
