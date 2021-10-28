package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class MemberRowMapper implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setEmail(rs.getString("email"));
		data.setNickname(rs.getString("nickname"));
		data.setPassword(rs.getString("password"));
		return data;
	}
}

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String loginSQL = "select * from member where email = ? and password = ?";
	private final String signupSQL = "insert into member values(?,?,?)";
	private final String signoutSQL = "delete from member where email = ?";
	private final String uUpdateSQL = "update set member nickname = ?, password = ? where email = ?";
	
	public List<MemberVO> login(MemberVO vo) {
		System.out.println("vo" + vo);
		Object[] args= { vo.getEmail(),vo.getPassword() };
		return jdbcTemplate.query(loginSQL, args,new MemberRowMapper());		
	}
	public boolean signup(MemberVO vo) {
		Object[] args= { vo.getEmail(),vo.getNickname(),vo.getPassword()};
		return (jdbcTemplate.update(signupSQL, args) >= 1 )? true : false;
	}
	public boolean signout(MemberVO vo) {
		Object[] args= { vo.getEmail()};
		return (jdbcTemplate.update(signoutSQL, args) >= 1 )? true : false;
	}
	public boolean uUpdate(MemberVO vo) {
		Object[] args= { vo.getNickname(),vo.getPassword(),vo.getEmail()};
		return (jdbcTemplate.update(uUpdateSQL, args) >= 1 )? true : false;
	}
}
