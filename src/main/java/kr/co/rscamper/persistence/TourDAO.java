package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.TourCommentVO;

public interface TourDAO {

	public void commentInsert(TourCommentVO vo) throws Exception;

	public List<TourCommentVO> commentList(int contentid) throws Exception;

	public int likeCnt(int parseInt) throws Exception;

	public void likeInsert(TourCommentVO vo) throws Exception;

	public String likeStatus(TourCommentVO vo) throws Exception;

	public void bookmarkInsert(TourCommentVO vo) throws Exception;

	public int bookmarkCnt(int contentid) throws Exception;

	public String bookmarkStatus(TourCommentVO vo) throws Exception;
	
}
