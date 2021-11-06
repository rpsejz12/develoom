package model.page;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisPageDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public PageVO paging(PageVO pvo) {   
		pvo.setTotal(mybatis.selectOne("pagedao.pagecnt", pvo));

		pvo.setLastPage((pvo.getTotal()-1)/pvo.getPerPage()+1);	//마지막 페이지 설정	
		pvo.setStart((pvo.getCurPage()-1)*pvo.getPerPage());		//페이지에 보여줄 게시물 시작
		pvo.setEnd(pvo.getStart()+pvo.getPerPage());				//페이지에 보여줄 게시물 끝		



		pvo.setStartPage((pvo.getCurPage()-1)/pvo.getPerPageSet()*pvo.getPerPageSet()+1);	//목차 시작
		if(pvo.getStartPage() < 1) {		//시작페이지가 1보다 작을경우 1로 설정
			pvo.setStartPage(1);
		}

		pvo.setEndPage(pvo.getStartPage()+pvo.getPerPageSet()-1);							//목차 끝
		if(pvo.getEndPage() > pvo.getLastPage()) {	//끝페이지가 마지막페이지보다 클경우 마지막페이지로 설정
			pvo.setEndPage(pvo.getLastPage());
		}

		System.out.println("pageDAO 설정후 vo :" + pvo);
		return pvo;
	}
}