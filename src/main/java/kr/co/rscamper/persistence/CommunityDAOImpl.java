package kr.co.rscamper.persistence;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.AppCommunityVO;
import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.BoardLikeVO;
import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.CommunityVO;

@Repository
public class CommunityDAOImpl implements CommunityDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.CommunityMapper";

	@Override
	public List<CommunityVO> selectCommunityList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectCommunityList", pageMap);
	}

	@Override
	public List<CommunityVO> selectCommunityListByCategoryNo(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectCommunityListByCategoryNo", pageMap);
	}
	
	@Override
	public int selectCommunityTotalPagesByUserUid(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".selectCommunityTotalPagesByUserUid");
	}

	@Override
	public List<CommunityVO> selectCommunityListByUserUid(Map<String, Object> pageMap) {
		System.out.println("count" + pageMap.get("count"));
		System.out.println("page" + pageMap.get("page"));
		System.out.println("userUid" + pageMap.get("userUid"));
		return sqlSessionTemplate.selectList(namespace + ".selectCommunityListByUserUid", pageMap);
	}

	@Override
	public int selectCommunityTotalPages() {
		return sqlSessionTemplate.selectOne(namespace + ".selectCommunityTotalPages");
	}

	@Override
	public int selectCommunityTotalPagesByCategoryNo(int categoryNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectCommunityTotalPagesByCategoryNo", categoryNo);
	}

	@Override
	public List<CommunityVO> selectCategoryList() {
		return sqlSessionTemplate.selectList(namespace + ".selectCategoryList");
	}

	@Override
	public CommunityVO selectCommunity(int boardNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectCommunity", boardNo);
	}

	@Override
	public void insertBoard(CommunityVO community) {
		sqlSessionTemplate.insert(namespace + ".insertBoard", community);
	}
	
	@Override
	public void updateboardByBoardNo(CommunityVO community) {
		sqlSessionTemplate.update(namespace + ".updateBoardByBoardNo", community);
	}
	
	@Override
	public void deleteBoardByBoardNo(int boardNo) {
		sqlSessionTemplate.delete(namespace + ".deleteBoardByBoardNo", boardNo);
	}

	@Override
	public List<CommentVO> selectCommentList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectCommentList", pageMap);
	}
	
	@Override
	public int selectCommentTotalPages(int boardNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectCommentTotalPages", boardNo);
	}

	@Override
	public void insertComment(CommentVO comment) {
		sqlSessionTemplate.insert(namespace + ".insertComment", comment); 
	}

	@Override
	public void deleteCommentByCommentNo(int commentNo) {
		sqlSessionTemplate.delete(namespace + ".deleteCommentByCommentNo", commentNo); 
	}

	@Override
	public void updateCommentByCommentNo(CommentVO comment) {
		sqlSessionTemplate.update(namespace + ".updateCommentByCommentNo", comment);
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

	@Override
	public int selectBookmarkCommunityTotalPagesByUserUid(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".selectBookmarkCommunityTotalPagesByUserUid", userUid);
	}

	@Override
	public List<CommunityVO> selectBookmarkCommunityListByUserUid(Map<String, Object> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectBookmarkCommunityListByUserUid", pageMap);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<AppCommunityVO> selectAppCommunityList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectAppCommunityList", pageMap);
	}
	@Override
	public int countAllRouteList() {
		return sqlSessionTemplate.selectOne(namespace + ".countAllRouteList");
	}
	@Override
	public List<AppCommunityVO> selectRouteDetailByNo(int boardNo) {
		return sqlSessionTemplate.selectList(namespace + ".selectRouteDetailByNo", boardNo);
	}
	@Override
	public AppCommunityVO selectOneRoute(int boardNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectOneRoute", boardNo);
	}
}
