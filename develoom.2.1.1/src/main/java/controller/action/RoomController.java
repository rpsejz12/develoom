package controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.chat.ChatService;
import model.chat.ChatVO;
import model.member.MemberVO;
import model.room.RoomService;
import model.room.RoomVO;

@Controller
@SessionAttributes("user")
public class RoomController {
	@Autowired
	private RoomService roomService;	
	
	@Autowired
	private ChatService chatService;	
	
	@RequestMapping("/main.do")
	public String main(RoomVO vo,Model model) {
		model.addAttribute("rdatas",roomService.rSelectAll());
		return "main.jsp";
	}
	
	@RequestMapping("/myroom.do")
	public String myroom(RoomVO vo,Model model, @ModelAttribute("user")MemberVO mvo) {
		System.out.println(mvo);
		vo.setEmail(mvo.getEmail());
		model.addAttribute("rdatas",roomService.rSelectAllMy(vo));
		return "myroom.jsp";
	}
	
	
	@RequestMapping("/room.do")
	public String room(ChatVO cvo,RoomVO rvo, Model model) {
		RoomVO data = roomService.rSelectOne(rvo);
		if(data == null) {		
			return "redirect:main.do";
		}
		else {
			model.addAttribute("cdatas",chatService.cSelectAll(cvo));
			return "room.jsp";
		}
	}
	
	
	@RequestMapping("/rform.do")
	public String rform(RoomVO vo,Model model) {
		System.out.println("rform" + vo);
		model.addAttribute("rdata",roomService.rSelectOne(vo));
		return "rform.jsp";
	}
	
	@RequestMapping("/rinsert.do")
	public String rinsert(RoomVO vo) {
		roomService.rInsert(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/rdelete.do")
	public String rdelete(RoomVO vo) {
		roomService.rDelete(vo);
		return "redirect:myroom.do";
	}
	
	@RequestMapping("/rupdate.do")
	public String rupdate(RoomVO vo) {
		roomService.rUpdate(vo);
		return "redirect:myroom.do";
	}
	
}
