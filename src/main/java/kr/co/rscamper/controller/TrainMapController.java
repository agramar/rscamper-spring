package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.TrainMapVO;
import kr.co.rscamper.service.TrainMapService;

@Controller
@RequestMapping("/trainMap/*")
public class TrainMapController {
	
	@Inject
	private TrainMapService service;
	
	private static final Logger logger = LoggerFactory.getLogger(TrainMapController.class);
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String trainMap() {
		logger.info("/trainMap > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/train/trainMap.jsp";
	}
	
	@RequestMapping(value="/mapTrain", method = RequestMethod.GET)
	public @ResponseBody List<TrainMapVO> list() throws Exception {
		logger.info("trainMap");
		List<TrainMapVO> list = new ArrayList<>();
		list = service.list();
		return list;
	}
	
	@RequestMapping(value="/trainMapLine", method = RequestMethod.GET)
	public @ResponseBody List<TrainMapVO> trainLineMapList() throws Exception {
		logger.info("trainMapLine");
		List<TrainMapVO> result = new ArrayList<>();
		result = service.trainLineMapList();
		return result;
	}
}
