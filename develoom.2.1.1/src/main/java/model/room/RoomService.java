package model.room;

import java.util.List;

import model.page.PageVO;

public interface RoomService {
	public List<RoomVO> rSelectAll(PageVO pvo);
	public RoomVO rSelectOne(RoomVO rvo);
	public boolean rInsert(RoomVO rvo);
	public boolean rDelete(RoomVO rvo);
	public boolean rUpdate(RoomVO rvo);
}
