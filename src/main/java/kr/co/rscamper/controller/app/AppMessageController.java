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

import kr.co.rscamper.domain.AppMessageVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.AppMessageService;

@Controller
@RequestMapping("/app/message/*")
public class AppMessageController {

	@Inject
	private AppMessageService service;
	private static final Logger logger = LoggerFactory.getLogger(AppMessageController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectMessageList(int page, int count, String userUid) throws Exception {
		return service.selectMessageList(page, count, userUid);
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public @ResponseBody AppMessageVO selectMessageByNotesNo(int notesNo) throws Exception {
		return service.selectMessageByNotesNo(notesNo);
	}
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public @ResponseBody List<UserVO> getUserInfo(String word) throws Exception {
		return service.getUserInfo(word);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody void sendMessage(AppMessageVO message) throws Exception {
		service.sendMessage(message);
	}
	
}
