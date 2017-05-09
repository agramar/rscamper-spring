package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.PageMaker;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.PostVO;
import kr.co.rscamper.service.PostService;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/post/*")
public class PostController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostService postservice;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String post(String uid) {
		logger.info("/post > home");
		
//		return "redirect:http://localhost:80/rscamper-web/views/post/list.jsp?uid=" + uid;
		return "redirect:http://localhost:80/rscamper-web/views/post/list.jsp";
	}
	
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> list(PageVO vo, String uid) throws Exception{
        logger.info("/travelog > List");
		
		List<PostVO> list = new ArrayList<>();
		list = postservice.listAll(vo, uid);
		System.out.println(list);
		
		int totalCount = postservice.totalCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(vo);
		pageMaker.setTotalCount(totalCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
		
		return map;
		
	}
	
	
	
}
