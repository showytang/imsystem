package com.imsystem.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.imsystem.domain.Module;
import com.imsystem.domain.User;
import com.imsystem.service.setup.ModuleService;
import com.sun.org.apache.xpath.internal.operations.Mod;

@Component
public class MyInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	ModuleService moduleService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("你来了.....");



		Map<String, Module> map = (Map<String, Module>) request.getSession().getAttribute("urlMap");
				
		if(map==null) {
			User u = (User) request.getSession().getAttribute("user");
			if(u!=null) {
				 map = (Map<String, Module>) moduleService.queryMap(u.getId());
//				 request.getSession().setAttribute("urlMap",map);
			}else {
				String ctx =request.getContextPath();
				response.sendRedirect(ctx+"/user/page-login");
				return false;
			}
			
		}
		String uri =request.getRequestURI();
		
		System.out.println(uri);
		Object obj =map.get(uri);
		if(obj!=null) {
			return true;
		}else {
			
			return false;
		}






		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
