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

	/*	System.out.println("你来了.....");


		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			return true;
		}
		String uri = request.getRequestURI();
		String ctx=request.getContextPath();
		response.sendRedirect(ctx+"/user/page-login");
		System.out.println(uri);
		if (request.getSession().getAttribute("urlMap") == null) {
			Map<String, Module> map = (Map<String, Module>) moduleService.queryMap(user.getId());
			request.getSession().setAttribute("urlMap", map);
		}
		Object map = request.getSession().getAttribute("urlMap");
	if (map != null) {
			Map<String, Module> maps = (Map<String, Module>) request.getSession().getAttribute("urlMap");
			if (maps.get(uri) != null) {
				return true;
			}
		}
		return false;*/
		return true;
		
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
