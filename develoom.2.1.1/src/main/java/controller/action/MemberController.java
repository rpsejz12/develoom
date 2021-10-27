package controller.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.member.MemberService;
import model.member.MemberVO;

@Controller
@SessionAttributes("user")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/login.do")
	public String login(MemberVO vo,Model model) {
		List<MemberVO> datas = memberService.login(vo);
		if(datas.isEmpty()) {
			return "redirect:login.jsp";
		}
		else {
			model.addAttribute("user", datas.get(0));
			return "redirect:main.do";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:login.jsp";
	}

	@RequestMapping("/signup.do")
	public String signup(MemberVO vo,Model model) {
		memberService.signup(vo);
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/signout.do")
	public String signout(@ModelAttribute("user")MemberVO vo,Model model) {
		memberService.signout(vo);
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/uupdate.do")
	public String uupdate(@ModelAttribute("user")MemberVO vo,Model model) {
		memberService.uupdate(vo);
		return "redirect:login.jsp";
	}



}
