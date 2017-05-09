package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TogetherVO;

public interface TogetherDAO {

	public List<TogetherVO> selectTogether() throws Exception;

	public List<TogetherVO> listTogether(PageVO vo) throws Exception;

	public int totalCount() throws Exception;

	public TogetherVO selectByNo(int dNo) throws Exception;
}
