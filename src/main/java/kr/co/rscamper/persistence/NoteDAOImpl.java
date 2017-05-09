package kr.co.rscamper.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.NoteVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.UserVO;

@Repository
public class NoteDAOImpl implements NoteDAO {
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.NoteMapper";
	
	
	@Override
	public List<NoteVO> noteList(String uid) throws Exception {
		return sqlSessionTemplate.selectList(namespace + ".noteList", uid);
	}


	@Override
	public List<NoteVO> noteList(String uid, PageVO vo) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("pageStart", vo.getPageStart());
		map.put("perPageNum", vo.getPerPageNum());
		
		System.out.println("uid : " + uid);
		System.out.println("pageStart : " + vo.getPageStart());
		System.out.println("perPageNum : " + vo.getPerPageNum());
		
		return sqlSessionTemplate.selectList(namespace + ".notePage", map);
	}


	@Override
	public int totalCount(String uid) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".totalCount", uid);
	}


	@Override
	public void insertNote(NoteVO vo) throws Exception {
		int result = sqlSessionTemplate.insert(namespace + ".insertNote", vo);
		System.out.println("result : " + result);
	}


	@Override
	public List<NoteVO> noteSentList(String uid, PageVO vo) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("pageStart", vo.getPageStart());
		map.put("perPageNum", vo.getPerPageNum());
		
		System.out.println("uid : " + uid);
		System.out.println("pageStart : " + vo.getPageStart());
		System.out.println("perPageNum : " + vo.getPerPageNum());
		
		return sqlSessionTemplate.selectList(namespace + ".noteSentPage", map);
	}


	@Override
	public int sentTotalCount(String uid) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".sentTotalCount", uid);
	}

}
