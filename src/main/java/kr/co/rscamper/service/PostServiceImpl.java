package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.PostVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.PostDAO;



@Service
public class PostServiceImpl implements PostService {

	@Inject
	public PostDAO dao;
	
	@Override
	public String getTime() throws Exception {
		return dao.getTime();
	}
	
	@Override
	public int totalCount() throws Exception {
		return dao.totalCount();
	}

	@Override
	public PostVO read(Integer boardNo) throws Exception {
		return dao.detailMyPost(boardNo);
	}

	@Override
	public void modify(PostVO post) throws Exception {
		dao.updateMyPost(post);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		dao.deleteMyPost(boardNo);
	}

	@Override
	public List<PostVO> listAll(PageVO vo, String uid) throws Exception {
		return dao.listAllMyPost(vo, uid);
	}

}
