package model.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roomService")
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomDAO roomDAO;

	@Override
	public List<RoomVO> rSelectAll() {
		// TODO Auto-generated method stub
		return roomDAO.rSelectAll();
	}

	@Override
	public List<RoomVO> rSelectAllMy(RoomVO vo) {
		// TODO Auto-generated method stub
		return roomDAO.rSelectAllMy(vo);
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
