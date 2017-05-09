package kr.co.rscamper.controller.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/tour/*")
public class AppTourController {
	private static final Logger logger = LoggerFactory.getLogger(AppTourController.class);
}
