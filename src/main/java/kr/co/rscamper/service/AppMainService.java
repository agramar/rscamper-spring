package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.AppMainCommentVO;
import kr.co.rscamper.domain.AppMessageVO;

public interface AppMainService {

	/**메인페이지 메인탭 글 리스트 불러오기*/
	public Map<String, Object> selectMainList(int page, int count);
	
	/**메인페이지 베스트 여행기, 추천 정보, 추천 리뷰, 자유게시판*/
	public Map<String, Object> selectBoardListByCategoryNo(int page, int count, int categoryNo);
	
	/**메인페이지 베스트 일정*/
	public Map<String, Object> selectRecordList(int page, int count);
	
	/**메인페이지 댓글*/
	public List<AppMainCommentVO> selectMainCommentList(String userUid);
	
	/**메인페이지 메세지*/
	public List<AppMessageVO> selectMainMessageList(String userUid);
	
	/**메인페이지 추천루트*/
	public Map<String, Object> selectMainRouteList(int page, int count);
}
