package com.kh.ws;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketGroupServer extends TextWebSocketHandler {
	
	/*
	 * 사용자들을 기억하기 위한 저장소
	 * - 중복 불가
	 * - 동기화 지원
	 * 
	 */

	// 사용자의 정보는 WebSocketSession에 담김
	private Set<WebSocketSession> users = new CopyOnWriteArraySet();

	
	// 접속했을 때 - set에 담아주기
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		System.out.println("사용자 접속 ! 현재 : " + users.size() + "명");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		System.out.println("사용자 종료 ! 현재 : " + users.size() + "명");
	}
	
	
	

}
