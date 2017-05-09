package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.NoteVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.NoteDAO;

@Service
public class NoteServiceImpl implements NoteService {
	@Inject
	private NoteDAO dao;
	
	@Override
	public List<NoteVO> noteList(String uid) throws Exception {
		return dao.noteList(uid);
	}

	@Override
	public List<NoteVO> noteList(String uid, PageVO vo) throws Exception {
		return dao.noteList(uid, vo);
	}

	@Override
	public int totalCount(String uid) throws Exception {
		return dao.totalCount(uid);
	}

	@Override
	public void insertNote(NoteVO vo) throws Exception {
		dao.insertNote(vo);
	}

	@Override
	public List<NoteVO> noteSentList(String uid, PageVO vo) throws Exception {
		return dao.noteSentList(uid, vo);
	}

	@Override
	public int sentTotalCount(String uid) throws Exception {
		return dao.sentTotalCount(uid);
	}

}
