package controller.action;

import java.io.IOException;
import java.util.HashMap;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import model.chat.ChatService;
import model.chat.ChatVO;
import model.chat.EchoDAO;

@Controller
@ServerEndpoint(value="/echo.do/{rpk}")
public class WebSocketChat {
	private static final Map<Session, String> sessionMap = new HashMap<Session,String>();
	private static final Logger logger = LoggerFactory.getLogger(WebSocketChat.class);
	
	private ChatVO vo = new ChatVO();
	public EchoDAO dao = new EchoDAO();
	
	
	public WebSocketChat() {
		// TODO Auto-generated constructor stub
		System.out.println("웹소켓(서버) 객체생성");
	}



	@OnOpen
	public void onOpen(Session session, @PathParam("rpk")String rpk) {    	
		logger.info("Open session id:"+session.getId());
		try {
			final Basic basic=session.getBasicRemote();
			basic.sendText("대화방에 연결 되었습니다.");
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
	private void sendAllSessionToMessage(Session self, String nickname, String message, String rpk) {
		sessionMap.forEach((key, value)->{
			try {
				if(key!=self) {
					if(value.equals(rpk)) {
						key.getBasicRemote().sendText(nickname+" : "+message);
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
	public void onMessage(String message,Session session, @PathParam("rpk")String rpk) {
		String nickname = message.split(",")[2];
		String email = message.split(",")[1];
		message = message.split(",")[0];	
		logger.info("Message From "+ nickname + ": "+message +" : " + rpk);
		vo.setRpk(Integer.parseInt(rpk));
		vo.setEmail(email);
		vo.setNickname(nickname);
		vo.setContent(message);
		dao.cInsert(vo);
		try {
			final Basic basic=session.getBasicRemote();
			basic.sendText("<나> : "+message);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		sendAllSessionToMessage(session, nickname, message, rpk);
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