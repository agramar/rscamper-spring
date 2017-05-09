package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.BoardLikeVO;
import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TogetherVO;
import kr.co.rscamper.domain.TravelogVO;

@Repository
public class TravelogDAOImpl implements TravelogDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.TravelogMapper";

	@Override
	public String getTime() throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".getTime");
	}

	@Override
	public List<TravelogVO> listTravelog(PageVO page) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("page", page);
//		paramMap.put("categoryNo", categoryNo);
//		System.out.println("page:"+page+"   categoryNo:"+ categoryNo);
		
		return sqlSessionTemplate.selectList(namespace + ".listAll", page);
	}
	
	@Override
	public int totalCount() throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".totalCount");
	}

	@Override
	public void insertTravelog(TravelogVO travelog) throws Exception {
		sqlSessionTemplate.insert(namespace + ".insert", travelog);
	}

	@Override
	public TravelogVO selectByNo(int boardNo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".selectByNo", boardNo);
	}
	
	@Override
	public void updateBoard(TravelogVO travelog) throws Exception {
		sqlSessionTemplate.update(namespace + ".updateBoard", travelog);
	}
	
	@Override
	public void deleteBoardByBoardNo(int boardNo) throws Exception {
		sqlSessionTemplate.delete(namespace + ".deleteBoardByBoardNo", boardNo);
	}
	

	@Override
	public List<CommentVO> listComment(Integer boardNo, PageVO page) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("boardNo", boardNo);
		paramMap.put("page", page);
		System.out.println(paramMap);
		return sqlSessionTemplate.selectList(namespace + ".listComment", paramMap);
	}

	@Override
	public void insertComment(CommentVO cVo) throws Exception {
		sqlSessionTemplate.selectList(namespace + ".insertComment", cVo);
	}

	@Override
	public void updateComment(CommentVO cVo) throws Exception {
		sqlSessionTemplate.selectList(namespace + ".updateComment", cVo);
	}

	@Override
	public void delteteComment(Integer commentNo) throws Exception {
		sqlSessionTemplate.selectList(namespace + ".delteteComment", commentNo);
	}
	
	@Override
	  public int count(Integer boardNo) throws Exception {
	    return sqlSessionTemplate.selectOne(namespace + ".count", boardNo);
	  }

	@Override
	public int getBno(Integer rno) throws Exception {
	    return sqlSessionTemplate.selectOne(namespace + ".getBno", rno);
	  }

	@Override
	public int totalCountComment(Integer boardNo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".totalCountComment", boardNo);
	}
	
	@Override
	public int selectBoardLike(BoardLikeVO boardLike) {
		return sqlSessionTemplate.selectOne(namespace + ".selectBoardLike", boardLike);
	}

	@Override
	public void insertBoardLike(BoardLikeVO boardLike) {
		sqlSessionTemplate.insert(namespace + ".insertBoardLike", boardLike);
	}

	@Override
	public void deleteBoardLike(BoardLikeVO boardLike) {
		sqlSessionTemplate.insert(namespace + ".deleteBoardLike", boardLike);
	}

	@Override
	public int selectBoardBookMark(BoardBookMarkVO boardBookMark) {
		return sqlSessionTemplate.selectOne(namespace + ".selectBoardBookMark", boardBookMark);
	}

	@Override
	public void insertBoardBookMark(BoardBookMarkVO boardBookMark) {
		sqlSessionTemplate.insert(namespace + ".insertBoardBookMark", boardBookMark);
	}

	@Override
	public void deleteBoardBookMark(BoardBookMarkVO boardBookMark) {
		sqlSessionTemplate.insert(namespace + ".deleteBoardBookMark", boardBookMark);
	}

	
}
