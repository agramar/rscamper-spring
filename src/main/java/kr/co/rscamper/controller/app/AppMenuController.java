package kr.co.rscamper.controller.app;

import javax.inject.Inject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.co.rscamper.service.MenuService;

@RestController
@RequestMapping("/app/menu*")
public class AppMenuController {
	
	@Inject
	private MenuService service;

}
