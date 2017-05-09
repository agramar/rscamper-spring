package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.PageVO;

public interface BenefitService {

	public List<BenefitVO> listTogether(PageVO vo) throws Exception;

	public int totalCount() throws Exception;

	public BenefitVO selectByNo(int no) throws Exception;

}
