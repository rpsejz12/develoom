package model.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("chatService")
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private MybatisChatDAO chatDAO; // alt+shift+R -> 이름 한번에 변경 가능!

	@Override
	public List<ChatVO> cSelectAll(ChatVO vo) {
		// TODO Auto-generated method stub
		return chatDAO.cSelectAll(vo);
	}
}
