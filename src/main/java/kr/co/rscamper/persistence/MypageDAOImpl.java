package kr.co.rscamper.persistence;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.MypageCountVO;

@Repository
public class MypageDAOImpl implements MypageDAO{

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.MypageMapper";
	
	@Override
	public MypageCountVO selectMenuCountByUserUid(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".selectMenuCountByUserUid", userUid);
	}

	
}
