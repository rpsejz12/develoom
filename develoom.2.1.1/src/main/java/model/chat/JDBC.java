package model.chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://rpsejz12.cafe24.com/rpsejz12","rpsejz12","rnjs7672");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection conn,PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
