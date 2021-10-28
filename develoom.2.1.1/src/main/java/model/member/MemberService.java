package model.member;

import java.util.List;

public interface MemberService {
	public List<MemberVO> login(MemberVO vo);
	public boolean signup(MemberVO vo);
	public boolean signout(MemberVO vo);
	public boolean uupdate(MemberVO vo);
}
