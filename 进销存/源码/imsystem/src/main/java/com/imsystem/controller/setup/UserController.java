package com.imsystem.controller.setup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.atp.DateParser;
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
import com.imsystem.domain.Role;
import com.imsystem.domain.Store;
import com.imsystem.domain.User;
import com.imsystem.service.setup.RoleService;
import com.imsystem.service.setup.StoreService_c;
import com.imsystem.service.setup.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@Autowired
	StoreService_c storeService_c;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping("page-login")
	public String login() {
		return "czx/page-login";
	}
	
	@RequestMapping("toInsertUser")
	public String toInsertUser() {
		return "czx/admin-add";
	}
	
	@RequestMapping("deleteUserById")
	@ResponseBody
	public int deleteUserById(Integer state, String id) {
		
		int i=userService.deleteUserById(state, id);
		
		return 1;
	}
	
	@RequestMapping("TingYongUser")
	@ResponseBody
	public int TingYongUser(Integer state, String id) {
		
		
		
		int i=userService.deleteUserById(state, id);
		
		return 1;
	}
	
	@RequestMapping("deleteAll")
	@ResponseBody
	public int deleteAll(Integer[] ids) {
		
		
		
		int i= userService.deleteAll(ids);
		if(i>0) {
			return 1;
		}else {
			return 0;
		}
		
		
	}

	
	@RequestMapping("loginOut")
	public String loginOut(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:user/page-login";
		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("queryUserById")
	public String queryUserById(String id,Model model) {
		User u=userService.queryUserById(id);
		
		
		
		model.addAttribute("u", u);
		List<Role> list=roleService.queryRoleAll();
		model.addAttribute("list",list);
		List<Store> listStore =storeService_c.queryStoreAll();
		model.addAttribute("listStore", listStore);
		return "czx/admin-update";
	}

	
	@RequestMapping("updateUserById")
	public String updateUserById(User user,HttpSession session) {
		
		System.out.println("用户修改进来");
		
		System.out.println(user.getId());
		
		User user1 = (User)session.getAttribute("user");
		user.setUid(user1.getId());
		userService.updateUserById(user);
		
		return "redirect:queryUserRole";
	}
	
	
	
	
	@RequestMapping("insertUser")
	public String insertUser(User user,HttpSession session) {
		
		System.out.println("进来了");
		
		
		String id = "" ;
		String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
		String sdf = new SimpleDateFormat("yyyyMMddss").format(new Date());
		id = trandNo.toString().substring(0, 4); 
		id = id + sdf ;
		
		
		
		
		
		
		
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		String hehe = dateFormat.format( now ); 
		Date utilDate = null;
		try {
			utilDate = dateFormat.parse(hehe);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Date date = new java.sql.Date(utilDate.getTime());
		System.out.println(date); 
		User user2=(User) session.getAttribute("user");
		String uid=user2.getId();
		
		User u=new User();
		u.setId(id);
		u.setName(user.getName());
		u.setPwd(user.getPwd());
		u.setStoreid(user.getStoreid());
		u.setRid(user.getRid());
		u.setTime(date);
		u.setState(0);
		u.setUid(uid);
		int i=userService.insertUser(u);
		
		
		
		return "redirect:queryUserRole";
		
		
	}
	
	@RequestMapping("queryUserRole")
	public String queryUserRole(Model model,User user, Integer pageNum, Integer pageSize) {
		if (pageNum==null || pageNum==0) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=2;
		}
		
		PageInfo<User> page= userService.queryByPage(user, pageNum, pageSize);
		
		model.addAttribute("page",page);
		
		
		return "/czx/admin-list";	
	}
	
	
	
	@RequestMapping("zhuye")
	public String zhuye() {
		return "index_on";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String queryByName(String name, String pwd,HttpSession session) {
		 
		
		 
		 User user= userService.queryUserByName(name, pwd);
		 
		 if (user!=null) {
			   session.setAttribute("user", user);
			   return "1";
		  }else {	  
			  return null;
		  }
	   
		 
	}
	
	
}
