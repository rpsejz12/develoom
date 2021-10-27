package model.member;

import java.util.List;

public interface MemberService {
	public List<MemberVO> login(MemberVO vo);
	public void signup(MemberVO vo);
	public void signout(MemberVO vo);
	public void uupdate(MemberVO vo);
}
