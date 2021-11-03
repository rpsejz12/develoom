package controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.chat.ChatService;
import model.chat.ChatVO;

@Controller
public class ChatController {
	@Autowired
	private ChatService chatService;	
	@RequestMapping("/room.do")
	public String room(ChatVO vo, Model model) {
		model.addAttribute("cdatas",chatService.cSelectAll(vo));
		return "room.jsp";
	}
}
