package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.PostVO;
import kr.co.rscamper.domain.UserVO;

//@Repository가 DB Exception Translation을 자동으로 해준다
@Repository
public class PostDAOImpl implements PostDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.PostMapper";

	@Override
	public String getTime() throws Exception{
		return sqlSessionTemplate.selectOne(namespace + ".getTime");
	}

	@Override
	public int totalCount() throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".totalCount");
	}

	@Override
	public PostVO detailMyPost(Integer boardNo) throws Exception {
		return sqlSessionTemplate.selectOne(namespace + ".detailPost", boardNo);
	}

	@Override
	public void updateMyPost(PostVO post) throws Exception {
		sqlSessionTemplate.update(namespace + ".updatePost", post );
	}


	@Override
	public void deleteMyPost(Integer boardNo) throws Exception {
		sqlSessionTemplate.delete(namespace + ".deletePost", boardNo);
	}


	@Override
	public List<PostVO> listAllMyPost(PageVO vo, String uid) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageStart", vo.getPageStart());
		paramMap.put("perPageNum", vo.getPerPageNum());
		paramMap.put("uid", uid);
//		System.out.println(paramMap.get("pageStart")+paramMap.get("perPageNum")+paramMap.get("uid"));
		return sqlSessionTemplate.selectList(namespace + ".listAll", paramMap);
	}

	
	
}
