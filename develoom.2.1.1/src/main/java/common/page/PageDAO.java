package common.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class PageDAO {


	String count = "select count(*) from board";
	PageVO data = null;


	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;

	public PageVO paging(PageVO vo) {		
		conn = JNDI.connect();
		try {			
			pstmt=conn.prepareStatement(count);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setTotal(rs.getInt(1));
			}		
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}

		vo.setLastPage((vo.getTotal()-1)/vo.getPerPage()+1);	
		vo.setStart((vo.getCurPage()-1)*vo.getPerPage());	
		vo.setEnd(vo.getStart()+vo.getPerPage());			

		vo.setStartPage((vo.getCurPage()-1)/vo.getPerPageSet()*vo.getPerPageSet()+1);	
		if(vo.getStartPage() < 1) {	
			vo.setStartPage(1);
		}
		
		vo.setEndPage(vo.getStartPage()+vo.getPerPageSet()-1);						
		if(vo.getEndPage() > vo.getLastPage()) {
			vo.setEndPage(vo.getLastPage());
		}
		return vo;

	}






}
