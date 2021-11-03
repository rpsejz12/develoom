package model.chat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class ChatRowMapper implements RowMapper<ChatVO> {
	@Override
	public ChatVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChatVO data=new ChatVO();
		data.setCpk(rs.getInt("cpk"));
		data.setRpk(rs.getInt("rpk"));
		data.setCdatetime(rs.getString("cdatetime"));
		data.setContent(rs.getString("content"));
		data.setEmail(rs.getString("email"));
		return data;
	}
}

@Repository
public class ChatDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String cSelectAllSQL = "select * from chat where rpk = ? order by cpk asc";
	
	public List<ChatVO> cSelectAll(ChatVO vo) {
		Object[] args= {vo.getRpk()};
		return jdbcTemplate.query(cSelectAllSQL,args,new ChatRowMapper());		
	}
}
