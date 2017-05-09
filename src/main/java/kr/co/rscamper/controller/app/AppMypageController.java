package kr.co.rscamper.controller.app;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.service.AppMypageService;

@Controller
@RequestMapping("/app/mypage/*")
public class AppMypageController {

	@Inject
	private AppMypageService service;
	private static final Logger logger = LoggerFactory.getLogger(AppMypageController.class);
	
	@RequestMapping(value = "/select/bookMark", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectBookMarkList(int page, int count, String userUid) throws Exception {
		return service.selectBookMarkList(page, count, userUid);
	}
	
	@RequestMapping(value = "/route", method = RequestMethod.POST)
	public @ResponseBody void insertRoute(String jsonValue) throws Exception {
		service.insertRoute(jsonValue);
	}
	
	@RequestMapping(value = "/route", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectRouteListByNo(int page, int count) throws Exception {
		return service.selectRouteListByNo(page, count);
	}
	
}
