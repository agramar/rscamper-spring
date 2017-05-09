package kr.co.rscamper.controller.app;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.AppMainCommentVO;
import kr.co.rscamper.domain.AppMessageVO;
import kr.co.rscamper.service.AppMainService;

@Controller
@RequestMapping("/app/main/*")
public class AppMainController {

	@Inject
	private AppMainService service;
	private static final Logger logger = LoggerFactory.getLogger(AppMainController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectMainList(int page, int count) throws Exception {
		return service.selectMainList(page, count);
	}
	
	@RequestMapping(value = "/categoryBoardList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectBoardListByCategoryNo(int page, int count, int categoryNo) throws Exception {
		return service.selectBoardListByCategoryNo(page, count, categoryNo);
	}
	
	@RequestMapping(value = "/recordList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectRecordList(int page, int count) throws Exception {
		return service.selectRecordList(page, count);
	}
	
	@RequestMapping(value = "/commentList", method = RequestMethod.GET)
	public @ResponseBody List<AppMainCommentVO> selectMainCommentList(String userUid) throws Exception {
		return service.selectMainCommentList(userUid);
	}
	
	@RequestMapping(value = "/messageList", method = RequestMethod.GET)
	public @ResponseBody List<AppMessageVO> selectMainMessageList(String userUid) throws Exception {
		return service.selectMainMessageList(userUid);
	}
	
	@RequestMapping(value = "/routeList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectMainRouteList(int page, int count) throws Exception {
		return service.selectMainRouteList(page, count);
	}
	
}
