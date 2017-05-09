package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.TourCommentVO;
import kr.co.rscamper.persistence.TourDAO;

@Service
public class TourServiceImpl implements TourService {
	
	@Inject
	TourDAO dao;
	
	@Override
	public void commentInsert(TourCommentVO vo) throws Exception {
		dao.commentInsert(vo);
	}

	@Override
	public List<TourCommentVO> commentList(int contentid) throws Exception {
		return dao.commentList(contentid);
	}

	@Override
	public int likeCnt(int parseInt) throws Exception {
		return dao.likeCnt(parseInt);
	}

	@Override
	public void likeInsert(TourCommentVO vo) throws Exception {
		dao.likeInsert(vo);
	}

	@Override
	public String likeStatus(TourCommentVO vo) throws Exception {
		return dao.likeStatus(vo);
	}

	@Override
	public void bookmarkInsert(TourCommentVO vo) throws Exception {
		dao.bookmarkInsert(vo);
	}

	@Override
	public int bookmarkCnt(int contentid) throws Exception {
		return dao.bookmarkCnt(contentid);
	}

	@Override
	public String bookmarkStatus(TourCommentVO vo) throws Exception {
		return dao.bookmarkStatus(vo);
	}
	
	
}
