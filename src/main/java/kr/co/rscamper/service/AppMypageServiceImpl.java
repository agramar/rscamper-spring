package kr.co.rscamper.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.rscamper.domain.AppMainVO;
import kr.co.rscamper.domain.BoardRouteVO;
import kr.co.rscamper.domain.BookMarkPageVO;
import kr.co.rscamper.domain.BookMarkVO;
import kr.co.rscamper.persistence.AppMypageDAO;
import kr.co.rscamper.persistence.TourScheduleDAO;

@Service
public class AppMypageServiceImpl implements AppMypageService {

	@Inject
	private AppMypageDAO dao;
	@Inject
	private TourScheduleDAO tdao;
	
	@Override
	public Map<String, Object> selectBookMarkList(int page, int count, String userUid) {
		page = (page - 1) * count;

		int totalPages = (int) Math.ceil((double) dao.countBookMark(userUid) / (double) count);
		BookMarkPageVO bookMarkPage = new BookMarkPageVO();
		bookMarkPage.setCount(count);
		bookMarkPage.setPage(page);
		bookMarkPage.setUserUid(userUid);
		List<BookMarkVO> bookMarkList = dao.selectBookMarkList(bookMarkPage);
		
		for (BookMarkVO bookMarkVO : bookMarkList) {
			if (bookMarkVO.getTargetType().equals("3") && bookMarkVO.getPicture() == 1) {
				bookMarkVO.setCoverImgUrl(tdao.getCover(bookMarkVO.getNo()).getFilePath());
			}
		}

		Map<String, Object> bookMarkMap = new HashMap<>();
		bookMarkMap.put("bookMarkList", bookMarkList);
		bookMarkMap.put("totalPages", totalPages);
		return bookMarkMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////
	@Override
	public void insertRoute(String jsonValue) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<BoardRouteVO> brList = new ArrayList<>();
		brList = mapper.readValue(jsonValue, new TypeReference<List<BoardRouteVO>>() {});
		
		int no = dao.selectMaxNo() + 1;
		int orderNo = 0;
		for (BoardRouteVO br : brList) {
			br.setOrderNo(++orderNo);
			br.setBoardRouteNo(no);
			dao.insertRoute(br);
		}
	}
	
	@Override
	public Map<String, Object> selectRouteListByNo(int page, int count) {
		page = (page - 1) * count;

		int totalPages = (int)Math.ceil((double)dao.countAllRouteList() / (double)count);
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("count", count);
		List<BoardRouteVO> routeList = dao.selectRouteListByNo(pageMap);
		
		
		for (BoardRouteVO br : routeList) {
			List<BoardRouteVO> routeDetailList = dao.selectRouteDetailByNo(br.getBoardRouteNo());
			br.setRouteDetailList(routeDetailList);
		}
		
		Map<String, Object> routeMap = new HashMap<>();
		routeMap.put("routeList", routeList);
		routeMap.put("totalPages", totalPages);

		return routeMap;
	}
}
