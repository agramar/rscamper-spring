package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.service.TrainService;

// @RestController
// @RequestMapping("/train/*")
public class TrainController {
	
	@Inject
	private TrainService service;
	
	private static final Logger logger = LoggerFactory.getLogger(TrainController.class);
	
/*	@RequestMapping(value="/test", method = RequestMethod.GET)
	public @ResponseBody List<TrainVO> list() throws Exception {
		logger.info("qqqqq");
		System.out.println("짜자잔");
		List<TrainVO> list = new ArrayList<>();
		list = service.list();
		return list;
	}*/
}
