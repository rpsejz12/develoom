package model.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pageService")
public class PageServiceImpl implements PageService{
	
	@Autowired
	private MybatisPageDAO pageDAO; // alt+shift+R -> 이름 한번에 변경 가능!

	@Override
	public PageVO paging(PageVO vo) {
		// TODO Auto-generated method stub
		return pageDAO.paging(vo);
	}
}
