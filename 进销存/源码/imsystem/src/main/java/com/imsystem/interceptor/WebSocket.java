package com.imsystem.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.imsystem.domain.Users;

@Component
public class WebSocket implements HandshakeInterceptor{

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		/**
		 * 匹配用户 （获取http的session中的用户）将用户存储在ws的session中
		 */
		ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
		//从http request中获取session中的用户对象。
		Users us = (Users)servletRequest.getServletRequest().getSession().getAttribute("user");
		if(us!=null) {
			attributes.put("uid",us.getId());
			return true;
		}
		return false;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}
	
}
