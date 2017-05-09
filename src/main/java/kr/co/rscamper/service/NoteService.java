package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.NoteVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.UserVO;

public interface NoteService {

	public List<NoteVO> noteList(String uid) throws Exception;

	public List<NoteVO> noteList(String uid, PageVO vo) throws Exception;

	public int totalCount(String uid) throws Exception;

	public void insertNote(NoteVO vo) throws Exception;

	public List<NoteVO> noteSentList(String uid, PageVO vo) throws Exception;

	public int sentTotalCount(String uid) throws Exception;

}
