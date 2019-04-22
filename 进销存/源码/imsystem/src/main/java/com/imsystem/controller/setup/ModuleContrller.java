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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Module;
import com.imsystem.domain.User;
import com.imsystem.service.setup.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleContrller {

	@Autowired
	ModuleService moduleService;
	
	
	
	
	
	@RequestMapping("queryModuleAll")
	public String queryUserRole(Model model,Module module, Integer pageNum, Integer pageSize) {
		if (pageNum==null || pageNum==0) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=4;
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
		
		System.out.println("come。。。。。。。");
		
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
		
		
		
		
		System.out.println("大耳朵图图");
		
		
		
		String parentid = module.getParentid().substring(module.getParentid().indexOf(",") + 1);
		
		
		int i=moduleService.insertModule(module);
		
		
		
		return "redirect:queryModuleAll";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("queryMuLu")
	public String queryMuLu(String rid,Model model,HttpSession session) {
			
		User user=(User) session.getAttribute("user");
		
		List<Module> list=moduleService.queryMuLu(user.getId(),0+"");
		
		model.addAttribute("list", list);
		
		System.out.println(JSON.toJSONString(list));
		
		
		return "index_on";
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
