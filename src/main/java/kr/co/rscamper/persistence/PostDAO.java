package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.PostVO;
import kr.co.rscamper.domain.UserVO;

public interface PostDAO {

	public String getTime() throws Exception;
	
	public int totalCount() throws Exception;

	public PostVO detailMyPost(Integer boardNo) throws Exception;

	public void updateMyPost(PostVO post) throws Exception;


	public void deleteMyPost(Integer boardNo) throws Exception;
	
	public List<PostVO> listAllMyPost(PageVO vo, String uid) throws Exception;

}
