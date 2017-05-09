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

import kr.co.rscamper.domain.MenuVO;
import kr.co.rscamper.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/menu/*")
public class MenuController {
	
	@Inject
	private MenuService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<MenuVO> list() throws Exception {
		logger.info("in menu > list");
		List<MenuVO> list = new ArrayList<>();
		list = service.list();
		return list;
	}
}
