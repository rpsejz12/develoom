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
	private final String uupdateSQL = "update set member nickname = ?, password = ? where email = ?";
	
	public List<MemberVO> login(MemberVO vo) {
		Object[] args= { vo.getEmail(),vo.getPassword() };
		return jdbcTemplate.query(loginSQL, args,new MemberRowMapper());		
	}
	public void signup(MemberVO vo) {
		Object[] args= { vo.getEmail(),vo.getNickname(),vo.getPassword()};
		jdbcTemplate.update(signupSQL, args);
	}
	public void signout(MemberVO vo) {
		Object[] args= { vo.getEmail()};
		jdbcTemplate.update(signoutSQL, args);
	}
	public void uupdate(MemberVO vo) {
		Object[] args= { vo.getNickname(),vo.getPassword(),vo.getEmail()};
		jdbcTemplate.update(uupdateSQL, args);
	}
}
