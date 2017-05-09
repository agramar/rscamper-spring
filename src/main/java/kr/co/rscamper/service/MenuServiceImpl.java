package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.MenuVO;
import kr.co.rscamper.persistence.MenuDAO;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Inject
	private MenuDAO dao;

	@Override
	public List<MenuVO> list() throws Exception {
		return dao.list();
	}

	
}
