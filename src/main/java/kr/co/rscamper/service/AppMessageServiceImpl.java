package kr.co.rscamper.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.AppMessageVO;
import kr.co.rscamper.domain.BookMarkPageVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.AppMessageDAO;

@Service
public class AppMessageServiceImpl implements AppMessageService {

	@Inject
	private AppMessageDAO dao;
	
	@Override
	public Map<String, Object> selectMessageList(int page, int count, String userUid) {
		page = (page - 1) * count;
		
		int totalPages = (int)Math.ceil((double)dao.countMessageList(userUid) / (double)count);
		
		BookMarkPageVO paging = new BookMarkPageVO(page, count, userUid);
		List<AppMessageVO> messageList = dao.selectMessageList(paging);
		
		Map<String, Object> messageMap = new HashMap<>();
		messageMap.put("messageList", messageList);
		messageMap.put("totalPages", totalPages);
		
		return messageMap;
	}
	
	@Override
	public AppMessageVO selectMessageByNotesNo(int notesNo) {
		dao.updateMessageState(notesNo);
		return dao.selectMessageByNotesNo(notesNo);
	}
	
	@Override
	public List<UserVO> getUserInfo(String word) {
		List<String> wordList = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			wordList.add(word.substring(i, i+1));
		}
		return dao.getUserInfo(wordList);
	}
	
	@Override
	public void sendMessage(AppMessageVO message) {
		dao.insertMessage(message);
	}
}
