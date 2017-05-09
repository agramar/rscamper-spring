package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.BoardLikeVO;
import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;

public interface TravelogService {
	
	public String getTime() throws Exception;
	
	// 여행기 list 조회
	public List<TravelogVO> listTravelog(PageVO page) throws Exception;
	
	public int totalCount() throws Exception;
	
	// 여행기 게시물 등록
	public void regist(TravelogVO travelog) throws Exception;
	
	// 여행기 게시물 조회
	public TravelogVO selectByNo(int boardNo) throws Exception;
	
	// 여행기 게시물 수정
	public void updateBoard(TravelogVO travelog) throws Exception;
	
	// 여행기 게시물 삭제
	public void deleteBoardByBoardNo(int boardNo) throws Exception;
	
	// comment *******************************************
	public void addCommnet(CommentVO cVo) throws Exception;
	
	public List<CommentVO> listComment(Integer boardNo, PageVO page) throws Exception;
	
	public void deleteComment(Integer commentNo) throws Exception;
	
	public void updateComment(CommentVO cVo) throws Exception;
	
	public int count(Integer boardNo) throws Exception;
	
	public int totalCountComment(Integer boardNo) throws Exception;
	
	/** 좋아요 서비스(좋아요 안했으면 좋아요+1, 했으면 좋아요-1) */
	public boolean likeProcess(BoardLikeVO boardLike);

	/** 북마크 서비스(북마크 안했으면 추가, 했으면 삭제) */
	public boolean bookMarkProcess(BoardBookMarkVO boardBookMark);

	/** 북마크 여부 조회 */
	public boolean selectBookMarkStatus(BoardBookMarkVO boardBookMark);
	
}
