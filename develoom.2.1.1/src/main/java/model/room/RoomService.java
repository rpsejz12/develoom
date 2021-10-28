package model.room;

import java.util.List;

public interface RoomService {
	public List<RoomVO> rSelectAll();
	public List<RoomVO> rSelectAllMy(RoomVO vo);
	public boolean rInsert(RoomVO vo);
	public boolean rDelete(RoomVO vo);
	public boolean rUpdate(RoomVO vo);
}
