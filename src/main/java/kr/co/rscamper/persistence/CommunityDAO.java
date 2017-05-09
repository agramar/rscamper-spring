package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.AppCommunityVO;
import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.BoardLikeVO;
import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.CommunityVO;

public interface CommunityDAO {
	
	/** 게시판 리스트 조회(유저별) */
	public int selectCommunityTotalPagesByUserUid(String userUid);
	
	/** 게시물 카운트 조회(유저별) */
	public List<CommunityVO> selectCommunityListByUserUid(Map<String, Object> pageMap);

	/** 게시판 리스트 조회(전체) */
	public List<CommunityVO> selectCommunityList(Map<String, Integer> pageMap);
	
	/** 게시글 리스트 조회(카테고리별) */
	public List<CommunityVO> selectCommunityListByCategoryNo(Map<String, Integer> pageMap);
	
	/** 게시글 리스트 조회(유저 북마크별)*/
	public int selectBookmarkCommunityTotalPagesByUserUid(String userUid);

	/** 전체 게시물 카운트 조회 */
	public int selectCommunityTotalPages();
	
	/** 게시판별 게시물 카운트 조회 */
	public int selectCommunityTotalPagesByCategoryNo(int categoryNo);
	
	/** 게시물 카운트 조회(유저 북마크별)*/
	public List<CommunityVO> selectBookmarkCommunityListByUserUid(Map<String, Object> pageMap);

	/** 게시판 카테고리 조회 */
	public List<CommunityVO> selectCategoryList();

	/** 게시물 하나 조회 */
	public CommunityVO selectCommunity(int boardNo);

	/** 게시글 입력 */
	public void insertBoard(CommunityVO community);

	/** 게시글 하나 수정 */
	public void updateboardByBoardNo(CommunityVO community);
	
	/** 게시글 하나 삭제 */
	public void deleteBoardByBoardNo(int boardNo);

	/** 전체 댓글 카운트 조회 */
	public int selectCommentTotalPages(int boardNo);

	/** 페이징 처리된 댓글 리스트 조회 */
	public List<CommentVO> selectCommentList(Map<String, Integer> pageMap);

	/** 댓글 입력 */
	public void insertComment(CommentVO comment);

	/** 댓글 삭제 */
	public void deleteCommentByCommentNo(int commentNo);

	/** 댓글 수정 */
	public void updateCommentByCommentNo(CommentVO comment);

	/** 좋아요 조회 */
	public int selectBoardLike(BoardLikeVO boardLike);
	
	/** 좋아요 등록 */
	public void insertBoardLike(BoardLikeVO boardLike);
	
	/** 좋아요 삭제 */
	public void deleteBoardLike(BoardLikeVO boardLike);

	/** 북마크 조회 */
	public int selectBoardBookMark(BoardBookMarkVO boardBookMark);

	/** 북마크 등록 */
	public void insertBoardBookMark(BoardBookMarkVO boardBookMark);

	/** 북마크 삭제 */
	public void deleteBoardBookMark(BoardBookMarkVO boardBookMark);


	
	
	
	
	
	
	
	
	
	/** 앱 커뮤니티 전체 */
	public List<AppCommunityVO> selectAppCommunityList(Map<String, Integer> pageMap);
	/** 루트 추천 게시글 갯수 */
	public int countAllRouteList();
	/** 루트 추천 게시글 상세 */
	public List<AppCommunityVO> selectRouteDetailByNo(int boardNo);
	/** 루트 추천 게시물 하나 조회 */
	public AppCommunityVO selectOneRoute(int boardNo);
	
}
