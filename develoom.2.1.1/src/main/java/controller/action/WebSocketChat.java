package controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@ServerEndpoint(value="/echo/{rpk}")
public class WebSocketChat {
	private static final Map<Session, String> sessionMap = new HashMap<Session,String>();
	private static final Logger logger = LoggerFactory.getLogger(WebSocketChat.class);
	public WebSocketChat() {
		// TODO Auto-generated constructor stub
		System.out.println("웹소켓(서버) 객체생성");
	}



	@OnOpen
	public void onOpen(Session session, @PathParam("rpk")String rpk) {    	
		logger.info("Open session id:"+session.getId());
		try {
			final Basic basic=session.getBasicRemote();
			basic.sendText("대화방에 연결 되었습니다." + rpk);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		sessionMap.put(session, rpk);
	}

	/*
	 * 모든 사용자에게 메시지를 전달한다.
	 * @param self
	 * @param sender
	 * @param message
	 */
	private void sendAllSessionToMessage(Session self, String sender, String message, String rpk) {
		sessionMap.forEach((key, value)->{
			try {
				if(key!=self) {
					if(value.equals(rpk)) {
						key.getBasicRemote().sendText(sender+" : "+message + " : " + rpk);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	/*
	 * 내가 입력하는 메세지
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message,Session session) {

		String rpk = message.split(",")[2];
		String sender = message.split(",")[1];
		message = message.split(",")[0];

		logger.info("Message From "+sender + ": "+message +" : " + rpk);
		try {
			final Basic basic=session.getBasicRemote();
			basic.sendText("<나> : "+message);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		sendAllSessionToMessage(session, sender, message, rpk);
	}

	@OnError
	public void onError(Throwable e,Session session) {

	}

	@OnClose
	public void onClose(Session session) {
		logger.info("Session "+session.getId()+" has ended");
		sessionMap.remove(session);
	}
}