package model.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisMemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<MemberVO> login(MemberVO vo) {
		return mybatis.selectList("memberdao.login",vo);	
	}
	public MemberVO check(MemberVO vo) {
		return mybatis.selectOne("memberdao.check",vo);	
	}
	public boolean signup(MemberVO vo) {
		return (mybatis.insert("memberdao.signup", vo)>=1)? true: false;
	}
	public boolean signout(MemberVO vo) {
		return (mybatis.delete("memberdao.signout", vo)>=1)? true: false;
	}
	public boolean mUpdate(MemberVO vo) {
		return (mybatis.update("memberdao.mupdate", vo)>=1)? true: false;
	}

}
