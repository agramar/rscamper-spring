package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TogetherVO;

@Repository
public class TogetherDAOImpl implements TogetherDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.TogetherMapper";
	
	
	@Override
	public List<TogetherVO> selectTogether() {
		System.out.println("in selectTogether");
		List<TogetherVO> list = new ArrayList<>(); 
		list = sqlSessionTemplate.selectList(namespace + ".selectTogether");
		System.out.println("list cnt : " + list.size());
		
		return list;
	}


	@Override
	public List<TogetherVO> listTogether(PageVO vo) {
		List<TogetherVO> list = new ArrayList<>(); 
		list = sqlSessionTemplate.selectList(namespace + ".listPage", vo);
		System.out.println(list.size());
		
		return list;
	}


	@Override
	public int totalCount() throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".totalCount");
	}


	@Override
	public TogetherVO selectByNo(int dNo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".selectByNo", dNo);
	}
}
