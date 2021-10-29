package controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.room.RoomService;
import model.room.RoomVO;

@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;	
	@RequestMapping("/main.do")
	public String main(RoomVO vo,Model model) {
		model.addAttribute("rdatas",roomService.rSelectAll());
		return "main.jsp";
	}
	@RequestMapping("/rinsert.do")
	public String rinsert(RoomVO vo) {
		roomService.rInsert(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/rdelete.do")
	public String rdelete(RoomVO vo) {
		roomService.rDelete(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/rupdate.do")
	public String rupdate(RoomVO vo) {
		roomService.rUpdate(vo);
		return "redirect:main.do";
	}
	
}
