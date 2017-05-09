package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.NotisficationVO;

public interface NotisficationDAO {

	public List<NotisficationVO> list(String userUid) throws Exception;

	public void deleteByNo(int no) throws Exception;

	public void insertNotification(NotisficationVO vo) throws Exception;

}
