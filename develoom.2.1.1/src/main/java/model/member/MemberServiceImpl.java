package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO; // alt+shift+R -> 이름 한번에 변경 가능!
	
	
	@Override
	public List<MemberVO> login(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.login(vo);
	}

	@Override
	public void signup(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.signup(vo);
	}

	@Override
	public void signout(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.signout(vo);
	}

	@Override
	public void uupdate(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.uupdate(vo);
	}

}
