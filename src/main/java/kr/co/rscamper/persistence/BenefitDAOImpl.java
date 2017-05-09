package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.PageVO;

@Repository
public class BenefitDAOImpl implements BenefitDAO {
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.BenefitMapper";
	

	@Override
	public List<BenefitVO> listTogether(PageVO vo) {
		List<BenefitVO> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList(namespace + ".listPage", vo);
		return list;
	}

	
	@Override
	public int totalCount() {
		return sqlSessionTemplate.selectOne(namespace + ".totalCount");
	}
	
	
	@Override
	public BenefitVO selectByNo(int no) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".selectByNo", no);
	}
}
