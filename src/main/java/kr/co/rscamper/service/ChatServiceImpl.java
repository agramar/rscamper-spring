package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserInfoVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.ChatDAO;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Inject
	private ChatDAO dao;
	

	@Override
	public List<ChatRoomVO> list() throws Exception {
		return dao.listRoom();
	}


	@Override
	public String selectAreaNameBycode(CodeVO vo) throws Exception {
		return dao.selectAreaNameBycode(vo);
	}


	@Override
	public List<ChatUserVO> selectRoomUserList(int chatRoomInfoNo) throws Exception {
		return dao.selectRoomUserList(chatRoomInfoNo);
	}


	@Override
	public void insertChatRoomUser(ChatUserVO vo) throws Exception {
		dao.insertChatRoomUser(vo);
	}


	@Override
	public List<CodeVO> getCodeName(String codeName) throws Exception {
		return dao.getCodeName(codeName);
	}
	
	@Override
	public void deleteRoomUser(ChatUserVO vo) throws Exception {
		dao.deleteRoomUser(vo);
	}


	@Override
	public List<ChatRoomVO> getChatRoom(int no) throws Exception {
		return dao.getChatRoom(no);
	}
	
	@Override
	public ChatRoomVO insertRoomInfo(ChatRoomVO vo) throws Exception {
		return dao.insertRoomInfo(vo);
	}


	@Override
	public ChatRoomVO getChatRoomInfo(int roomNo) throws Exception {
		return dao.getChatRoomInfo(roomNo);
	}


	@Override
	public UserVO getUserInfo(String uid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ChatUserInfoVO> getRoomUserList(int chatRoomInfoNo) throws Exception {
		return dao.getRoomUserList(chatRoomInfoNo);
	}
	
	
	@Override
	public void deleteChatRoom(int roomNo) throws Exception {
		dao.deleteChatRoom(roomNo);
	}


	@Override
	public List<ChatRoomVO> listByArea(int area) throws Exception {
		return dao.listByArea(area);
	}
	
	
	@Override
	public void delChatUser(String uid) throws Exception {
		dao.delChatUser(uid);
	}

}
