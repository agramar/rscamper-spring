package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.NoteVO;
import kr.co.rscamper.domain.PageMaker;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.NoteService;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/note/*")
public class NoteController {
	
	@Inject
	private NoteService service;
	@Inject 
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ajaxNoteList(@RequestParam("uid") String uid, PageVO vo) throws Exception {
		logger.info("/note > list");
		
//		System.out.println(vo.toString());
		
		List<NoteVO> list = new ArrayList<>();
		
		list = service.noteList(uid, vo);
		int totalCount = service.totalCount(uid);
		
		int v = 1;
		for (NoteVO nVo : list) {
			UserVO uVo = userService.selectUserByUid(nVo.getSentUserUid());
//			System.out.println(nVo.toString());
//			System.out.println(uVo.toString());
			nVo.setDisplayName(uVo.getDisplayName());
			nVo.setPhotoUrl(uVo.getPhotoUrl());
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(vo);
		pageMaker.setTotalCount(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
//		
//		System.out.print("endPage : ");
//		System.out.println(pageMaker.getEndPage());
		
		return map;
	}
	
	
	@RequestMapping(value = "/sent-list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ajaxNoteSentList(@RequestParam("uid") String uid, PageVO vo) throws Exception {
		logger.info("/note > sent-list");
		
//		System.out.println("uid : " + uid);
		List<NoteVO> list = new ArrayList<>();
		
		list = service.noteSentList(uid, vo);
		int totalCount = service.sentTotalCount(uid);
		
		for (NoteVO nVo : list) {
			UserVO uVo = userService.selectUserByUid(nVo.getRecvUserUid());
			nVo.setDisplayName(uVo.getDisplayName());
			nVo.setPhotoUrl(uVo.getPhotoUrl());
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(vo);
		pageMaker.setTotalCount(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
		
		return map;
	}
	
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody void ajaxNoteSend(NoteVO vo) throws Exception {
		logger.info("/note > send");
//		System.out.println(vo.toString());
		vo.setRecvRead("N");
		
		service.insertNote(vo);
	}
	
	
	@RequestMapping(value = "/user-list", method = RequestMethod.GET)
	public @ResponseBody List<UserVO> searchUserList() throws Exception {
		logger.info("/note > user-list");
		
		List<UserVO> list = new ArrayList<>();
		list = userService.selectUserList();
		
		return list;
	}
	
//	@RequestMapping(value = "/search-modal", method = RequestMethod.GET)
//	public @ResponseBody UserVO searchById(@RequestParam("uid") String uid) throws Exception {
//		logger.info("/note > search-modal");
//		System.out.println(uid);
//		
//		UserVO uVo = userService.selectUserByUid(uid);
//		
//		return uVo;
//	}
}
