package kr.co.rscamper.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.BoardLikeVO;
import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.PageMaker;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.TravelogService;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/travelog/*")
public class TravelogController {
	
	private static final Logger logger = LoggerFactory.getLogger(TravelogController.class);
	
	@Autowired
	private TravelogService travelogservice;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String travelog() {
		logger.info("/travelog > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/travelog/list.jsp";
	}
	
	// 게시글 목록 확인
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody  Map<String, Object> read(PageVO page) throws Exception{
		logger.info("/travelog > List");
		
		
		List<TravelogVO> list = new ArrayList<>();
		list = travelogservice.listTravelog(page);
		
		
		int totalCount = travelogservice.totalCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(page);
		pageMaker.setTotalCount(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
		
		return map;
	}
	
	// 게시글 실제 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> insert(
			@RequestParam String userUid, String title, String content, int categoryNo, PageVO page) 
			throws Exception {
		
		TravelogVO travelog = new TravelogVO();
		travelog.setUserUid(userUid);
		travelog.setTitle(title);
		travelog.setContent(content);
		travelog.setCategoryNo(categoryNo);
		
		travelogservice.regist(travelog);
		
		List<TravelogVO> list = new ArrayList<>();
		list = travelogservice.listTravelog(page);
		
		int totalCount = travelogservice.totalCount();
				
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(page);
		pageMaker.setTotalCount(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
				
		return null;
	}
	
	// 게시글 상세 
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
	public String redirectDetail(@PathVariable("boardNo") int boardNo) throws Exception {
		logger.info("/travelog > redirectDetail");
		
		return "redirect:http://localhost:80/rscamper-web/views/travelog/detail.jsp?boardNo=" + boardNo;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody TravelogVO detail(@RequestParam("boardNo") int boardNo) throws Exception {
		logger.info("/travelog > detail");
		
		
		TravelogVO vo = new TravelogVO();
		vo = travelogservice.selectByNo(boardNo);
		
		return travelogservice.selectByNo(boardNo);
	}
	
	// 게시글 삭제 
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteBoardByBoardNo(int boardNo) throws Exception{
		logger.info("/travelog > redirectDelete");
		
		travelogservice.deleteBoardByBoardNo(boardNo);
		return "redirect:http://localhost:80/rscamper-web/views/travelog/list.jsp";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody void updateBoard(TravelogVO travelog) throws Exception{
		logger.info("/travelog > redirectUpdate");
		
		System.out.println("travelog:"+travelog);
		travelogservice.updateBoard(travelog);
	}
	
	// 댓글 등록
	@RequestMapping(value = "/commentRegister", method = RequestMethod.POST)
	public @ResponseBody void insert(
			@RequestParam String userUid, String commentContent, int boardNo, PageVO page) 
			throws Exception {
		logger.info("/travelogComment > insert");
		
		CommentVO cVo = new CommentVO();
		cVo.setUserUid(userUid);
		cVo.setCommentContent(commentContent);
		cVo.setBoardNo(boardNo);
		travelogservice.addCommnet(cVo);
		
	}
	
	// 댓글 목록
	@RequestMapping(value = "/commentList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> listComment(@RequestParam int boardNo, PageVO page) throws Exception {
		logger.info("/travelogComment > listComment");
		
		List<CommentVO> list = new ArrayList<>();
		list = travelogservice.listComment(boardNo, page);
		for (CommentVO val : list) {
			UserVO uVo = userService.selectMainByUidComment(val.getUserUid());
			val.setDisplayName(uVo.getDisplayName());
			val.setProviderPhotoUrl(uVo.getPhotoUrl());
		}
		
		int totalCountComment = travelogservice.totalCountComment(boardNo);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(page);
		pageMaker.setTotalCount(totalCountComment);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
		
		System.out.println(map);
		
		return map;
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/commentDelete", method = RequestMethod.GET)
	public @ResponseBody void commentDelete(@RequestParam int commentNo) throws Exception {
		logger.info("/travelogComment > commentDelete");
		travelogservice.deleteComment(commentNo);
	} 
	
	// 댓글 수정
	@RequestMapping(value = "/commentUpdate", method = RequestMethod.POST)
	public @ResponseBody void commentUpdate(
			@RequestParam String userUid, String commentContent, int commentNo, PageVO page) throws Exception {
		logger.info("/travelogComment > commentUpdate");
		
		CommentVO cVo = new CommentVO();
		cVo.setUserUid(userUid);
		cVo.setCommentContent(commentContent);
		cVo.setCommentNo(commentNo);
		
		travelogservice.updateComment(cVo);
	}
	
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public @ResponseBody boolean likeProcess(BoardLikeVO boardLike) throws Exception {
		logger.info("/travelogComment > like");
		return travelogservice.likeProcess(boardLike);
	}
	
	@RequestMapping(value = "/bookMark", method = RequestMethod.POST)
	public @ResponseBody boolean bookMarkProcess(BoardBookMarkVO boardBookMark) throws Exception {
		logger.info("/travelogComment > bookMark");
		return travelogservice.bookMarkProcess(boardBookMark);
	}
	
	@RequestMapping(value = "/select/bookMark", method = RequestMethod.GET)
	public @ResponseBody boolean selectBookMarkStatus(BoardBookMarkVO boardBookMark) throws Exception {
		logger.info("/travelogComment > select > bookMark");
		return travelogservice.selectBookMarkStatus(boardBookMark);
	}
	
}
