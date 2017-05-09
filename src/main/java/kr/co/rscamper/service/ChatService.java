package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserInfoVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;
import kr.co.rscamper.domain.UserVO;

public interface ChatService {
	
	public List<CodeVO> getCodeName(String codeName) throws Exception;

	public List<ChatRoomVO> list() throws Exception;

	public String selectAreaNameBycode(CodeVO cVo) throws Exception;

	public List<ChatUserVO> selectRoomUserList(int chatRoomInfoNo) throws Exception;

	public void insertChatRoomUser(ChatUserVO uVo) throws Exception;
	
	public List<ChatRoomVO> getChatRoom(int no) throws Exception;
	
	public ChatRoomVO getChatRoomInfo(int roomNo) throws Exception;
	
	public UserVO getUserInfo(String uid) throws Exception;
	
	public List<ChatUserInfoVO> getRoomUserList(int chatRoomInfoNo) throws Exception;

	public void deleteRoomUser(ChatUserVO vo) throws Exception;

	public ChatRoomVO insertRoomInfo(ChatRoomVO crVo) throws Exception;

	public void deleteChatRoom(int roomNo) throws Exception;

	public List<ChatRoomVO> listByArea(int area) throws Exception;

	
	public void delChatUser(String uid) throws Exception;
	
}
