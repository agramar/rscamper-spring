package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.MenuVO;

public interface MenuService {
	
	public List<MenuVO> list() throws Exception;
}
