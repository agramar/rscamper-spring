package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.BoardLikeVO;
import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;

public interface TravelogDAO {

	/** 여행기 게시물 */
	public String getTime() throws Exception;
	
	public List<TravelogVO> listTravelog(PageVO page) throws Exception;
	
	public int totalCount() throws Exception;
	
	public void insertTravelog(TravelogVO travelog) throws Exception;

	public TravelogVO selectByNo(int boardNo) throws Exception;
	
	public void updateBoard(TravelogVO travelog) throws Exception;
	
	public void deleteBoardByBoardNo(int boardNo) throws Exception;
	
	/** comment */  
	
	public List<CommentVO> listComment(Integer boardNo, PageVO page) throws Exception;
	
	public void insertComment(CommentVO cVo) throws Exception;
	
	public void updateComment(CommentVO cVo) throws Exception;
	
	public void delteteComment(Integer commentNo) throws Exception;

	public int count(Integer boardNo) throws Exception;

	public int getBno(Integer rno) throws Exception;

	public int totalCountComment(Integer boardNo) throws Exception;
	
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
}
