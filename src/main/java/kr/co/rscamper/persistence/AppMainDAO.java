package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.AppMainCommentVO;
import kr.co.rscamper.domain.AppMessageVO;
import kr.co.rscamper.domain.AppMainVO;

@Repository
public class AppMainDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.AppMainMapper";
	
	public List<AppMainVO> selectMainList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectMainList", pageMap);
	}
	
	public int countAllBoard() {
		return sqlSessionTemplate.selectOne(namespace + ".countAllBoard");
	}
	
	public int countAllRecord() {
		return sqlSessionTemplate.selectOne(namespace + ".countAllRecord");
	}
	
	public List<AppMainVO> selectBoardListByCategoryNo(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectBoardListByCategoryNo", pageMap);
	}
	
	public int countBoardByCategoryNo(int categoryNo) {
		return sqlSessionTemplate.selectOne(namespace + ".countBoardByCategoryNo", categoryNo);
	}
	
	public List<AppMainVO> selectRecordList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectRecordList", pageMap);
	}
	
	public List<AppMainCommentVO> selectMainCommentList(String userUid) {
		return sqlSessionTemplate.selectList(namespace + ".selectMainCommentList", userUid);
	}
	
	public List<AppMessageVO> selectMainMessageList(String userUid) {
		return sqlSessionTemplate.selectList(namespace + ".selectMainMessageList", userUid);
	}
	
	public List<AppMainVO> selectMainRouteList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectMainRouteList", pageMap);
	}
	
	public int countAllRouteList() {
		return sqlSessionTemplate.selectOne(namespace + ".countAllRouteList");
	}
}
