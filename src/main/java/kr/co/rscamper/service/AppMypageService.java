package kr.co.rscamper.service;

import java.util.Map;

public interface AppMypageService {
	
	/**내 북마크 리스트 가져오기*/
	public Map<String, Object> selectBookMarkList(int page, int count, String userUid);
	
	
	
	
	
	///////////////////////////////////////////
	/**루트 추천 글 등록*/
	public void insertRoute(String jsonValue) throws Exception;
	
	/**루트 추천 글 리스트*/
	public Map<String, Object> selectRouteListByNo(int page, int count);
	
}
