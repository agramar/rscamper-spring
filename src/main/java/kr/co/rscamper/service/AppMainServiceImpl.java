package kr.co.rscamper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.AppMainCommentVO;
import kr.co.rscamper.domain.AppMessageVO;
import kr.co.rscamper.domain.AppMainVO;
import kr.co.rscamper.persistence.AppMainDAO;
import kr.co.rscamper.persistence.TourScheduleDAO;

@Service
public class AppMainServiceImpl implements AppMainService {

	@Inject
	private AppMainDAO dao;
	@Inject
	private TourScheduleDAO tdao;
	
	@Override
	public Map<String, Object> selectMainList(int page, int count) {
		page = (page - 1) * count;

		int totalPages = (int)Math.ceil(((double)dao.countAllBoard() + (double)dao.countAllRecord()) / (double)count);
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("count", count);
		List<AppMainVO> mainList = dao.selectMainList(pageMap);
		
		for (AppMainVO appMainVO : mainList) {
			if(appMainVO.getPicture() == 1) {
				appMainVO.setCoverImgUrl(tdao.getCover(appMainVO.getNo()).getFilePath());
			}
		}
		
		Map<String, Object> mainMap = new HashMap<>();
		mainMap.put("mainList", mainList);
		mainMap.put("totalPages", totalPages);

		return mainMap;
	}
	
	@Override
	public Map<String, Object> selectBoardListByCategoryNo(int page, int count, int categoryNo) {
		page = (page - 1) * count;
		
		int totalPages = (int)Math.ceil((double)dao.countBoardByCategoryNo(categoryNo) / (double)count);
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("count", count);
		pageMap.put("categoryNo", categoryNo);
		List<AppMainVO> categoryBoardList = dao.selectBoardListByCategoryNo(pageMap);
		
		Map<String, Object> categoryBoardMap = new HashMap<>();
		categoryBoardMap.put("categoryBoardList", categoryBoardList);
		categoryBoardMap.put("totalPages", totalPages);
		
		return categoryBoardMap;
	}
	
	@Override
	public Map<String, Object> selectRecordList(int page, int count) {
		page = (page - 1) * count;

		int totalPages = (int)Math.ceil((double)dao.countAllRecord() / (double)count);
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("count", count);
		List<AppMainVO> recordList = dao.selectRecordList(pageMap);
		
		for (AppMainVO appMainVO : recordList) {
			if(appMainVO.getPicture() == 1) {
				appMainVO.setCoverImgUrl(tdao.getCover(appMainVO.getNo()).getFilePath());
			}
		}
		
		Map<String, Object> recordListMap = new HashMap<>();
		recordListMap.put("recordList", recordList);
		recordListMap.put("totalPages", totalPages);

		return recordListMap;
	}
	
	@Override
	public List<AppMainCommentVO> selectMainCommentList(String userUid) {
		return dao.selectMainCommentList(userUid);
	}
	
	@Override
	public List<AppMessageVO> selectMainMessageList(String userUid) {
		return dao.selectMainMessageList(userUid);
	}
	
	@Override
	public Map<String, Object> selectMainRouteList(int page, int count) {
		page = (page - 1) * count;

		int totalPages = (int)Math.ceil((double)dao.countAllRouteList() / (double)count);
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("count", count);
		List<AppMainVO> routeList = dao.selectMainRouteList(pageMap);
		
		Map<String, Object> routeListMap = new HashMap<>();
		routeListMap.put("routeList", routeList);
		routeListMap.put("totalPages", totalPages);

		return routeListMap;
	}
}
