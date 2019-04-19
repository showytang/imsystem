package com.imsystem.controller.setup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.imsystem.domain.Module;
import com.imsystem.domain.User;
import com.imsystem.service.setup.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleContrller {

	@Autowired
	ModuleService moduleService;
	
	
	
	@RequestMapping("queryMuLu")
	public String queryMuLu(String rid,Model model,HttpSession session) {
			
		User user=(User) session.getAttribute("user");
		
		List<Module> list=moduleService.queryMuLu(user.getId(),0);
		
		model.addAttribute("list", list);
		
		System.out.println(JSON.toJSONString(list));
		
		
		return "index_on";
	}
	
	
	
	
	
	@RequestMapping("query")
	public void query(HttpServletRequest req,HttpServletResponse resp) {
		resp.setContentType("utf-8");
		resp.setCharacterEncoding("utf-8");
		User u=(User)req.getSession().getAttribute("user");
		List<Module> list=moduleService.queryMuLu(u.getId(), 0);
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
