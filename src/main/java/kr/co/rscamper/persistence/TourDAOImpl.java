package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.TourCommentVO;

@Repository
public class TourDAOImpl implements TourDAO {
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.TourMapper";
	
	
	@Override
	public void commentInsert(TourCommentVO vo) throws Exception {
		int result = sqlSessionTemplate.insert(namespace + ".commentInsert", vo);
		System.out.println("result : " + result);
	}


	@Override
	public List<TourCommentVO> commentList(int contentid) throws Exception {
		return sqlSessionTemplate.selectList(namespace + ".commentList", contentid);
	}


	@Override
	public int likeCnt(int contentid) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".likeCnt", contentid);
	}


	@Override
	public void likeInsert(TourCommentVO vo) throws Exception {
		sqlSessionTemplate.selectOne(namespace + ".likeInsert", vo);
	}


	@Override
	public String likeStatus(TourCommentVO vo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".likeStatus", vo);
	}


	@Override
	public void bookmarkInsert(TourCommentVO vo) throws Exception {
		sqlSessionTemplate.selectOne(namespace + ".bookmarkInsert", vo);
	}


	@Override
	public int bookmarkCnt(int contentid) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".bookmarkCnt", contentid);
	}


	@Override
	public String bookmarkStatus(TourCommentVO vo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".bookmarkStatus", vo);
	}
}
