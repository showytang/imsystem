package com.imsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.imsystem.handler.WebSocketHandler;
import com.imsystem.interceptor.WebSocket;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new WebSocketHandler(), "/mywebsocket").setAllowedOrigins("*").addInterceptors(new WebSocket());//mywebsocket握手的地址
	}

}
