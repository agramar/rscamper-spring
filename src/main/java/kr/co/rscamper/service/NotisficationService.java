package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.NotisficationVO;

public interface NotisficationService {

	public List<NotisficationVO> list(String userUid) throws Exception;

	public void deleteByNo(int no) throws Exception;

	public void insertNotification(NotisficationVO vo) throws Exception;

}
