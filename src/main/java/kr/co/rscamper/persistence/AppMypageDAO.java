package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BoardRouteVO;
import kr.co.rscamper.domain.BookMarkPageVO;
import kr.co.rscamper.domain.BookMarkVO;

@Repository
public class AppMypageDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.AppMypageMapper";
	
	public List<BookMarkVO> selectBookMarkList(BookMarkPageVO bookMarkPage) {
		return sqlSessionTemplate.selectList(namespace + ".selectBookMarkList", bookMarkPage);
	}
	
	public int countBookMark(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".countBookMark", userUid);
	}
	
	
	
	
	
	
	
	//////////////
	public int selectMaxNo() {
		return sqlSessionTemplate.selectOne(namespace + ".selectMaxNo");
	}
	
	public void insertRoute(BoardRouteVO br) {
		sqlSessionTemplate.insert(namespace + ".insertRoute", br);
	}
	
	public List<BoardRouteVO> selectRouteListByNo(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectRouteListByNo", pageMap);
	}
	
	public List<BoardRouteVO> selectRouteDetailByNo(int boardRouteNo) {
		return sqlSessionTemplate.selectList(namespace + ".selectRouteDetailByNo", boardRouteNo);
	}
	
	public int countAllRouteList() {
		return sqlSessionTemplate.selectOne(namespace + ".countAllRouteList");
	}
	
}
