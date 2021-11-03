package model.room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class RoomRowMapper implements RowMapper<RoomVO> {
	@Override
	public RoomVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomVO data=new RoomVO();
		data.setRpk(rs.getInt("rpk"));
		data.setEmail(rs.getString("email"));
		data.setRoomname(rs.getString("roomname"));
		data.setPassword(rs.getString("password"));
		data.setRdatetime(rs.getString("rdatetime"));
		return data;
	}
}

@Repository
public class RoomDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String rSelectAllSQL = "select * from room";
	private final String rSelectAllMySQL = "select * from room where email = ?";
	private final String rSelectOneSQL = "select * from room where rpk = ?";
	private final String rInsertSQL = "insert into room(email,roomname,password) values(?,?,?)";
	private final String rDeleteSQL = "delete from room where rpk = ?";
	private final String rUpdateSQL = "update set room roomname = ?, password = ? where rpk = ?";
	
	public RoomVO rSelectOne(RoomVO vo) {
		Object[] args= {vo.getRpk()};
		return jdbcTemplate.queryForObject(rSelectOneSQL,args,new RoomRowMapper());
	}	
	public List<RoomVO> rSelectAll() {
		return jdbcTemplate.query(rSelectAllSQL,new RoomRowMapper());		
	}
	public List<RoomVO> rSelectAllMy(RoomVO vo) {
		Object[] args= {vo.getEmail()};
		return jdbcTemplate.query(rSelectAllMySQL,args,new RoomRowMapper());		
	}
	public boolean rInsert(RoomVO vo) {
		Object[] args= { vo.getEmail(), vo.getRoomname(), vo.getPassword()};
		return (jdbcTemplate.update(rInsertSQL, args) >= 1 )? true : false;
	}
	public boolean rDelete(RoomVO vo) {
		Object[] args= { vo.getRpk()};
		return (jdbcTemplate.update(rDeleteSQL, args) >= 1 )? true : false;
	}
	public boolean rUpdate(RoomVO vo) {
		Object[] args= { vo.getRoomname(), vo.getPassword(), vo.getRpk()};
		return (jdbcTemplate.update(rUpdateSQL, args) >= 1 )? true : false;
	}
}
