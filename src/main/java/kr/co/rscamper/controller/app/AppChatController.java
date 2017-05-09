package kr.co.rscamper.controller.app;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserInfoVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.ChatService;

@Controller
@RequestMapping("/app/chat")
public class AppChatController {
	
	@Inject
	private ChatService service;
	
	@RequestMapping("/getCodeName")
	@ResponseBody
	public List<CodeVO> getCodeName(String codeName) throws Exception {
		return service.getCodeName(codeName);
	}
	@RequestMapping("/getChatRoom")
	@ResponseBody
	public List<ChatRoomVO> getChatRoom(int no) throws Exception {
		return service.getChatRoom(no);
	}
	
	@RequestMapping("/getChatRoomInfo") 
	@ResponseBody
	public ChatRoomVO getChatRoomInfo(int roomNo) throws Exception {
		return service.getChatRoomInfo(roomNo);
	}
	
	@RequestMapping("/selectRoomUserList")
	@ResponseBody
	public List<ChatUserInfoVO> selectRoomUserList(int chatRoomInfoNo) throws Exception {
		return service.getRoomUserList(chatRoomInfoNo);
	}
	
	@RequestMapping("/joinRoom")
	@ResponseBody
	public List<ChatUserInfoVO> joinRoom(ChatUserVO cv) throws Exception {
		service.insertChatRoomUser(cv);
		return service.getRoomUserList(cv.getChatRoomInfoNo());
	}
	
	@RequestMapping("/getBase64String")
	@ResponseBody
	public String getBase64String() throws Exception {
		return "";
	}
	
	@RequestMapping("/delChatUser")
	@ResponseBody
	public void delChatUser(String uid) throws Exception {
		service.delChatUser(uid);
	}
	
	@RequestMapping("/createRoom")
	@ResponseBody
	public ChatRoomVO createRoom(ChatRoomVO cv) throws Exception {
		return service.insertRoomInfo(cv);
	}
	
	@RequestMapping("/delRoom")
	@ResponseBody
	public List<ChatRoomVO> delRoom(int roomNo, int no) throws Exception {
		service.deleteChatRoom(roomNo);
		return service.getChatRoom(no);
	}
}
