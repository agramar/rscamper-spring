package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.co.rscamper.domain.PageMaker;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TogetherVO;
import kr.co.rscamper.service.TogetherService;

@Controller
@RequestMapping("/together/*")
public class TogetherController {
	private static final Logger logger = LoggerFactory.getLogger(TogetherController.class);
	
	@Inject
	private TogetherService service;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String together() {
		logger.info("/together > home");
		
		return "redirect:http://14.32.66.104:8083/rscamper-web/views/together/list.jsp";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> read(PageVO vo) throws Exception {
		logger.info("/together > List");
		
		List<TogetherVO> list = new ArrayList<>();
		vo.setPerPageNum(30);
		list = service.listTogether(vo);
		int totalCount = service.totalCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(vo);
		pageMaker.setTotalCount(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
		
		return map;
	}
	
	@RequestMapping(value = "/{detailNo}", method = RequestMethod.GET)
	public String redirectDetail(@PathVariable("detailNo") int dNo) throws Exception {
		logger.info("/together > redirectDetail");
		
		return "redirect:http://14.32.66.104:8083/rscamper-web/views/together/detail.jsp?no=" + dNo;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody TogetherVO detail(@RequestParam("no") int no) throws Exception {
		logger.info("/together > detail");
		
		TogetherVO vo = new TogetherVO();
		vo = service.selectByNo(no);
		
		return service.selectByNo(no);
	}
}
