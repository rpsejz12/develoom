package model.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EchoDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private final String cInsertSQL = "insert into chat(rpk,email,content) values(?,?,?)";

	public void cInsert(ChatVO vo) {
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(cInsertSQL);
			pstmt.setInt(1, vo.getRpk());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
}
