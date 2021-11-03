package model.chat;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisChatDAO {

	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ChatVO> cSelectAll(ChatVO vo) {	
		return mybatis.selectList("chatdao.cselectall",vo);	
	}	
}
