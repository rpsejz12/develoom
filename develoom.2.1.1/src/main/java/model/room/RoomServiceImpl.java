package model.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.page.PageVO;

@Service("roomService")
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private MybatisRoomDAO roomDAO;

	@Override
	public List<RoomVO> rSelectAll(PageVO vo) {
		// TODO Auto-generated method stub
		return roomDAO.rSelectAll(vo);
	}
	
	public RoomVO rSelectOne(RoomVO vo) {
		return roomDAO.rSelectOne(vo);
	}

	@Override
	public boolean rInsert(RoomVO vo) {
		// TODO Auto-generated method stub
		return roomDAO.rInsert(vo);
	}

	@Override
	public boolean rDelete(RoomVO vo) {
		// TODO Auto-generated method stub
		return roomDAO.rDelete(vo);
	}

	@Override
	public boolean rUpdate(RoomVO vo) {
		// TODO Auto-generated method stub
		return roomDAO.rUpdate(vo);
	}

}
