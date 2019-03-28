package com.imsystem.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler{
	/**
	 * 缓存所有握手成功的用户
	 */
	static Map<String,WebSocketSession> map = new HashMap<String,WebSocketSession>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		String uid = session.getAttributes().get("uid")+"";
		map.put(uid, session);
		session.sendMessage(new TextMessage("建立连接成功可以进行通信。"));
	}
	public String sendmsg(String msg,String targerId) {
		WebSocketSession session = map.get(targerId);
		try {
			session.sendMessage(new TextMessage(msg));
			return "001";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "000";
		}
	}
}
