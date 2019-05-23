package com.imsystem.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.imsystem.domain.Log;
import com.imsystem.domain.Module;
import com.imsystem.domain.User;
import com.imsystem.service.setup.ModuleService;
import com.imsystem.service.setup.logService;

@Component
@Aspect
public class MyAop {

	@Autowired
	ModuleService moduleService;

	@Autowired
	logService logService;

	@Pointcut("execution(* com.imsystem.controller.*.*.*(..))")
	public void pointcut() {

	}

//  方法执行前通知
	@Before("pointcut()")
	public void before(JoinPoint point) {

		try {

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			HttpSession session = request.getSession();

			List<String> ennames = new ArrayList<String>();
			String enname = point.getSignature().getName();
			ennames.add(enname);
			System.out.println("1." + enname);
			User user = (User) session.getAttribute("user");

			System.out.println("2."+user.getName());

			for (String ennname : ennames) {
				Module m = moduleService.queryModuleNameByEnname(enname);
				
				System.out.println("3."+user.getId());
				System.out.println("4"+m.getName());
				logService.XinZengLog(user.getId(),m.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("开始执行前通知 ");
		}
	}

//  执行成功后通知
	@AfterReturning("pointcut()")
	public void afterReturningLog() {
		System.out.println("方法成功执行后通知");
	}

//  抛出异常后通知
	@AfterThrowing("pointcut()")
	public void afterThrowingLog() {
		System.out.println("方法抛出异常后执行通知");
	}

}
