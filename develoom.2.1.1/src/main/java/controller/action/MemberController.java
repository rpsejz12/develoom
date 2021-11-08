package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping("/check.do")
	public String check(MemberVO vo, Model model, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		if(vo.getEmail() == null || vo.getEmail() == "") {
			out.println("null");
		}else {
			if(memberService.check(vo) == null) {
				out.println("false");
			}
			else {
				out.println("true");
			}
		}
		return null;		
	}

	@RequestMapping("/logout.do")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:login.jsp";
	}

	@RequestMapping("/signup.do")
	public String signup(MemberVO vo) {
		memberService.signup(vo);
		return "redirect:login.jsp";
	}

	@RequestMapping("/signout.do")
	public String signout(@ModelAttribute("user")MemberVO vo) {
		memberService.signout(vo);
		return "redirect:login.jsp";
	}

	@RequestMapping("/mupdate.do")
	public String mupdate(@ModelAttribute("user")MemberVO vo) {
		memberService.mupdate(vo);
		return "redirect:login.jsp";
	}



}
