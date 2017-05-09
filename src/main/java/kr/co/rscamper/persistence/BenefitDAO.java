package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.PageVO;

public interface BenefitDAO {

	public List<BenefitVO> listTogether(PageVO vo) throws Exception;

	public int totalCount() throws Exception;

	public BenefitVO selectByNo(int no) throws Exception;
	

}
