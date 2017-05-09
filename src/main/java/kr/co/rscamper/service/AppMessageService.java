package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.AppMessageVO;
import kr.co.rscamper.domain.UserVO;

public interface AppMessageService {
	
	/**쪽지 리스트*/
	public Map<String, Object> selectMessageList(int page, int count, String userUid);
	
	/**쪽지 상세페이지를 보여주고 쪽지가 읽지 않음 상태이면 읽읆으로 바꿈*/
	public AppMessageVO selectMessageByNotesNo(int notesNo);

	/**받는 사람에 쓰일 유저리스트 가져오기*/
	public List<UserVO> getUserInfo(String word);
	
	/**쪽지 보내기*/
	public void sendMessage(AppMessageVO message);
	
}
