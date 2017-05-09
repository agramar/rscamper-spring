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

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.PageMaker;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.service.BenefitService;

@Controller
@RequestMapping("/benefit/*")
public class BenefitController {
	private static final Logger logger = LoggerFactory.getLogger(TogetherController.class);

	@Inject
	private BenefitService service;


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String benefit() {
		logger.info("/benefit > home");

		return "redirect:http://localhost:80/rscamper-web/views/benefit/list.jsp";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> read(PageVO vo) throws Exception {
		logger.info("/benefit > List");

		List<BenefitVO> list = new ArrayList<>();
		int totalCount = service.totalCount();
		System.out.print("totalCount: ");
		System.out.println(totalCount);
		
		vo.setPerPageNum(20);
		list = service.listTogether(vo);
		System.out.print("list: ");
		System.out.println(list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(vo);
		pageMaker.setTotalCount(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);

		return map;
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public @ResponseBody BenefitVO detail(@RequestParam("benefitno") int benefitno) throws Exception {
		logger.info("/benefit > detail");
		
		BenefitVO vo = new BenefitVO();
		vo = service.selectByNo(benefitno);
		
		System.out.println(vo.getContent());
		
		return vo;
	}
}
