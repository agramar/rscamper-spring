package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.NotisficationVO;

@Repository
public class NotisficationDAOImpl implements NotisficationDAO {
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.NotisficationMapper";

	@Override
	public List<NotisficationVO> list(String userUid) throws Exception {
		return sqlSessionTemplate.selectList(namespace + ".list", userUid);
	}

	@Override
	public void deleteByNo(int no) throws Exception {
		sqlSessionTemplate.delete(namespace + ".deleteByNo", no);
	}

	@Override
	public void insertNotification(NotisficationVO vo) throws Exception {
		sqlSessionTemplate.insert(namespace + ".insertNotification", vo);
	}
}
