package kr.co.rscamper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.MypageCountVO;
import kr.co.rscamper.service.MypageService;

@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageService mypageService;
	
	@RequestMapping(value="/select/menuCount", method = RequestMethod.GET)
	public @ResponseBody MypageCountVO selectMenuCountByUserUid(String userUid) throws Exception{
		return mypageService.selectMenuCountByUserUid(userUid);
	}
	
	
	
}
