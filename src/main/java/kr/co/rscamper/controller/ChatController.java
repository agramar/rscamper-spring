package kr.co.rscamper.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.ChatService;
import kr.co.rscamper.service.UserService;


@Controller
@RequestMapping("/chat/*")
public class ChatController {
	
	@Inject
	private ChatService service;
	@Inject 
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String chat() {
		logger.info("/chat > home");

		return "redirect:http://14.32.66.104:8083/rscamper-web/views/chat/list.jsp";
	};
	
	
	@RequestMapping(value = "/room_list", method = RequestMethod.GET)
	public @ResponseBody List<ChatRoomVO> ajaxRoomList() throws Exception {
		logger.info("/chat > room list");

		List<ChatRoomVO> list = new ArrayList<>();
		list = service.list();
		
		CodeVO cVo = new CodeVO();
		for (ChatRoomVO vo : list) {
			cVo.setGroupCodeNo("chat_areacode");
			cVo.setCodeNo(vo.getAreacode());
			String areaName = service.selectAreaNameBycode(cVo);
			vo.setAreaName(areaName);
			
			List<ChatUserVO> userList = new ArrayList<>();
			
			userList = service.selectRoomUserList(vo.getChatRoomInfoNo());
			vo.setRoomUserCnt(userList.size());
		}
		
		return list;
	};
	
	
	// 지역별 채팅방 리스트
	@RequestMapping(value = "/area_room_list", method = RequestMethod.GET)
	public @ResponseBody List<ChatRoomVO> ajaxAreaRoomList(@RequestParam("area") int area) throws Exception {
		logger.info("/chat > area_room_list");
		
		System.out.println("area : " + area);
		
		List<ChatRoomVO> list = new ArrayList<>();
		list = service.listByArea(area);
		
		CodeVO cVo = new CodeVO();
		for (ChatRoomVO vo : list) {
			cVo.setGroupCodeNo("chat_areacode");
			cVo.setCodeNo(vo.getAreacode());
			String areaName = service.selectAreaNameBycode(cVo);
			vo.setAreaName(areaName);
			
			List<ChatUserVO> userList = new ArrayList<>();
			
			userList = service.selectRoomUserList(vo.getChatRoomInfoNo());
			vo.setRoomUserCnt(userList.size());
		}
		
		return list;
	};
	
	
	// 채팅방 입장 접속자 정보 입력
	@RequestMapping(value = "/insert_user", method = RequestMethod.POST)
	public @ResponseBody void ajaxInsertUser(ChatUserVO uVo) throws Exception {
		logger.info("/chat > insert_user");
		
		System.out.println(uVo.getChatRoomInfoNo());
		System.out.println(uVo.getUserUid());
		
		// 채팅방 유저 입력
		service.insertChatRoomUser(uVo);
	};
	
	
	// 채팅방 접속자 리스트 가져오기
	@RequestMapping(value = "/list_user", method = RequestMethod.GET)
	public @ResponseBody List<ChatUserVO> listUser(@RequestParam("roomNo") int roomNo) throws Exception {
		logger.info("/chat > list_user");
		
		System.out.println(roomNo);
		
		List<ChatUserVO> userList = new ArrayList<>();
		userList = service.selectRoomUserList(roomNo);
		
		for (ChatUserVO vo : userList) {
			System.out.println(vo.getUserUid());
			UserVO uVo = userService.selectUserByUid(vo.getUserUid());
			System.out.println(uVo.toString());
			vo.setDisplayName(uVo.getDisplayName());
		}
		
		return userList;
	};
	
	
	// 기본방 입장
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailChat(ChatRoomVO crVo, UserVO uVo, @RequestParam("room") int roomNo, @RequestParam("location") int location,
			@RequestParam("title") String title) throws Exception {
		logger.info("/chat > detail get");

		System.out.println(roomNo);
		System.out.println(location);
		System.out.println(title);

		CodeVO cVo = new CodeVO();
		cVo.setGroupCodeNo("chat_areacode");
		cVo.setCodeNo(location);
		String areaName = service.selectAreaNameBycode(cVo);

		// location = URLEncoder.encode(location, "UTF-8");
		title = URLEncoder.encode(title, "UTF-8");
		areaName = URLEncoder.encode(areaName, "UTF-8");

		return "redirect:http://14.32.66.104:8083/rscamper-web/views/chat/detail.jsp?room=" + areaName + "&location=" + location + "&title=" + title + "&roomNo=" + roomNo;

	};
	
	
	// 사용자 방 생성 -> 입장
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody String detailChat(ChatRoomVO crVo, UserVO uVo) throws Exception {
		logger.info("/chat > detail post");
		
		System.out.println(crVo.getAreacode());
		System.out.println(crVo.getChatRoomName());
		System.out.println(uVo.getUserUid());
		
		ChatRoomVO vo = new ChatRoomVO();
		vo = service.insertRoomInfo(crVo);
		CodeVO cVo = new CodeVO();
		cVo.setGroupCodeNo("chat_areacode");
		cVo.setCodeNo(crVo.getAreacode());
		String areaName1 = service.selectAreaNameBycode(cVo);
		vo.setAreaName(areaName1);
		System.out.println(vo.toString());
		
		String title = URLEncoder.encode(crVo.getChatRoomName(), "UTF-8");
		String areaName = URLEncoder.encode(areaName1, "UTF-8");
		
		return "redirect:http://14.32.66.104:8083/rscamper-web/views/chat/detail.jsp?room=" + areaName + "&location=" + crVo.getAreacode() + "&title=" + title + "&roomNo=" + crVo.getChatRoomInfoNo();
	};
	
	@RequestMapping(value = "/delete/user/{userUid}/{roomNo}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteUser(@PathVariable("userUid") String userUid, @PathVariable("roomNo") int roomNo) throws Exception {
		logger.info("/tour > delete > user");
		
		System.out.println(userUid);
		System.out.println(roomNo);
		
		ChatUserVO vo = new ChatUserVO();
		vo.setUserUid(userUid);
		vo.setChatRoomInfoNo(roomNo);
		service.deleteRoomUser(vo);
	}
	
	@RequestMapping(value = "/delete/room/{roomNo}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteRoom(@PathVariable("roomNo") int roomNo) throws Exception {
		logger.info("/tour > delete > room");
		
		System.out.println("삭제할 채팅방 번호 : " + roomNo);
		service.deleteChatRoom(roomNo);
	}
	
	
}

