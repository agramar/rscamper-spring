package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.persistence.BenefitDAO;

@Service
public class BenefitServiceImpl implements BenefitService {
	
	@Inject
	private BenefitDAO dao;
	
	
	@Override
	public List<BenefitVO> listTogether(PageVO vo) throws Exception {
		return dao.listTogether(vo);
	}

	@Override
	public int totalCount() throws Exception {
		return dao.totalCount();
	}

	@Override
	public BenefitVO selectByNo(int no) throws Exception {
		return dao.selectByNo(no);
	}


}
