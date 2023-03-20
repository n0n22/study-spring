package com.kh.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*
 * 웹소켓의 기본적인 이해를 돕기 위해 만든 서버
 * - 특정 클래스/인터페이스 상속 필요
 * 
 * 	인터페이스 구현 말고 클래스를 상속받아서 구현하는 이유는?
 *	강제성이 강한 인터페이스를 구현하면 다른 메소드도 다 오버라이딩해야하기 때문에
 *	클래스를 상속받아서 필요한 메소드만 사용할 것임
 * 
 */

// public class WebSocketBasicServer implements WebSocketHandler { // -> 인터페이스 구현
public class WebSocketBasicServer extends TextWebSocketHandler {   // -> 상속 받아서 구현


	/*
	 * 접속 시 실행되는 메소드 (특정 상황에 실행되는 코드) => 콜백
	 * - session : 접속한 사용자의 웹 소켓 정보 (HttpSession이 아님!!) - 들어왔다만 알 수 있음
	 * 
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("접속 : ");
		System.out.println("session : " + session);
	}

	/*
	 * 메시지 수신 시 호출될 메소드
	 * 
	 * - session : 접속한 사용자(전송한 사람)의 웹 소켓 정보 (HttpSession이 아님!!)
	 * - message : 사용자가 전송한 메시지 정보
	 * 				- payload : 실제 보낸 내용
	 * 				- byteCount : 보낸 메시지 크기 (Byte)
	 * 				- last : 메시지 종료 여부 (true이면 마지막 메시지)
	 * 
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("session : " + session);
		System.out.println("message : " + message);
	}
	
	

	/*
	 * 접속 종료 시 호출되는 메소드 => 콜백
	 * - session : 사용자의 웹 소켓 정보 (HttpSession이 아님!!)
	 * - status : 접속이 종료된 원인과 관련된 정보
	 * 
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("접속 종료");
		System.out.println("session : " + session);
		System.out.println("status : " + status);
	}
	
	
	
	
	
	
	
}
