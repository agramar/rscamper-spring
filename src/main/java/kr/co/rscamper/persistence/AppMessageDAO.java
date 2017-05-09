package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.AppMainCommentVO;
import kr.co.rscamper.domain.AppMessageVO;
import kr.co.rscamper.domain.BookMarkPageVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.domain.AppMainVO;

@Repository
public class AppMessageDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.AppMessageMapper";
	
	public List<AppMessageVO> selectMessageList(BookMarkPageVO paging) {
		return sqlSessionTemplate.selectList(namespace + ".selectMessageList", paging);
	}
	
	public int countMessageList(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".countMessageList", userUid);
	}
	
	public void updateMessageState(int notesNo) {
		sqlSessionTemplate.update(namespace + ".updateMessageState", notesNo);
	}
	
	public AppMessageVO selectMessageByNotesNo(int notesNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectMessageByNotesNo", notesNo);
	}
	
	public List<UserVO> getUserInfo(List<String> wordList) {
		return sqlSessionTemplate.selectList(namespace + ".getUserInfo", wordList);
	}
	
	public void insertMessage(AppMessageVO message) {
		sqlSessionTemplate.insert(namespace + ".insertMessage", message);
	}
	
}
