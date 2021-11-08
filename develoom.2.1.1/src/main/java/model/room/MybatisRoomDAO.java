package model.room;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.page.PageVO;

@Repository
public class MybatisRoomDAO {	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public RoomVO rSelectOne(RoomVO vo) {
		return mybatis.selectOne("roomdao.rselectone", vo);	
	}
	public List<RoomVO> rSelectAll(PageVO vo) {
		return mybatis.selectList("roomdao.rselectall",vo);	
	}
	public boolean rInsert(RoomVO vo) {
		return (mybatis.insert("roomdao.rinsert", vo)>=1)? true: false;
	}
	
	@Transactional
	public boolean rDelete(RoomVO vo) {
		boolean flag = true;
		
		if(mybatis.delete("roomdao.rdelete", vo)==0) {
			flag = false;
		}
		if(mybatis.delete("chatdao.cdeletetx", vo)==0) {
			flag = false;
		}
		return flag;
	}
	public boolean rUpdate(RoomVO vo) {
		return (mybatis.update("roomdao.rupdate", vo)>=1)? true: false;
	}
	
}
