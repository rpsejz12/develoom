package model.chat;

import java.util.List;

public interface ChatService {
	public List<ChatVO> cSelectAll(ChatVO vo);
	public boolean cInsert(ChatVO vo);
}
