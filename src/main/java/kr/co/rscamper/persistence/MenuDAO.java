package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.MenuVO;

public interface MenuDAO {
	
	public List<MenuVO> list() throws Exception;
}
