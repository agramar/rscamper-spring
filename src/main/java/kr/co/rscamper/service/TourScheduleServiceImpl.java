package kr.co.rscamper.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.LocationCommentVO;
import kr.co.rscamper.domain.LocationLikedVO;
import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.RecordLocationVO;
import kr.co.rscamper.domain.ScheduleLikeVO;
import kr.co.rscamper.domain.ScheduleListCommentVO;
import kr.co.rscamper.domain.ScheduleMemoCommentVO;
import kr.co.rscamper.domain.ScheduleMemoLikeVO;
import kr.co.rscamper.domain.ScheduleMemoVO;
import kr.co.rscamper.domain.TourSchedulePlanVO;
import kr.co.rscamper.domain.TourScheduleVO;
import kr.co.rscamper.domain.TravelPriceVO;
import kr.co.rscamper.persistence.TourScheduleDAO;

@Service
public class TourScheduleServiceImpl implements TourScheduleService {
	
	@Inject
	private TourScheduleDAO dao;

	@Override
	public List<TourScheduleVO> getSchedule(String uid) throws Exception {
		return dao.getSchedule(uid);
	}

	@Override
	public void insertSchedule(TourScheduleVO tv) throws Exception {
		dao.insertSchedule(tv);
	}

	@Override
	public void delSchedule(int no) throws Exception {
		dao.delSchedule(no);
		dao.delCover(no);
		dao.delScheduleLocation(no);
		dao.delScheduleAllMemo(no);
		dao.delSchedulePrice(no);
	}

	@Override
	public void changeCover(RecordCoverVO rc) throws Exception {
		dao.changeCover(rc);
		
	}

	@Override
	public void insertCover(RecordCoverVO rc) throws Exception {
		dao.insertCover(rc);
	}

	@Override
	public RecordCoverVO getCover(int no) throws Exception {
		
		return dao.getCover(no);
	}

	@Override
	public TourScheduleVO getDetailTourSchedule(int no) throws Exception {
		return dao.getDetailTourSchedule(no);
	}

	@Override
	public void updateStrapline(TourScheduleVO tv) throws Exception {
		dao.updateStrapline(tv);
	}

	@Override
	public void addScheduleLocation(RecordLocationVO rl) throws Exception {
		dao.addScheduleLocation(rl);
	}

	@Override
	public List<RecordLocationVO> getScheduleLocation(int no) throws Exception {
		return dao.getScheduleLocation(no);
	}

	@Override
	public int locationLikeCount(int code) throws Exception {
		return dao.locationLikeCount(code);
	}

	@Override
	public int isLike() throws Exception {
		return 0;
	}

	@Override
	public void insertLikePlus(LocationLikedVO ll) throws Exception {
		dao.insertLikePlus(ll);
	}

	@Override
	public Map<String, Object> checkedIsLike(LocationLikedVO ll) throws Exception {
		Map<String, Object> map = new HashMap<>();
		LocationLikedVO isLike = dao.checkedIsLike(ll);
		if (isLike == null) {
			map.put("isLike", true);
		} else {
			map.put("isLike", false);
		}
		
		LocationLikedVO isBack = dao.checkBackLocationLike(ll);
		if (isBack == null) {
			map.put("isBack", true);
		} else {
			map.put("isBack", false);
		}
		map.put("contentId", ll.getContentId());
		return map;
	}

	@Override
	public void removeLiked(LocationLikedVO ll) throws Exception {
		dao.removeLiked(ll);
	}

	@Override
	public void delLocation(int locationNo) throws Exception {
		dao.delLocation(locationNo);
		dao.delLocationPrice(locationNo);
		dao.delLocationMemo(locationNo);
	}

	@Override
	public Map<String, Object> allScheduleList(int page, int count, int soltType) throws Exception {
		page = (page - 1) * count;
		int totalCount = dao.selectScheduleCount();
		int totalPages = (int) Math.ceil((double) totalCount / (double) count);
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("count", count);
		pageMap.put("page", page);
		switch(soltType) {
		case 1 :
			return soltScheduleList(dao.allScheduleList(pageMap), totalPages, totalCount);
		case 2 : 
			return soltScheduleList(dao.allScheduleListDate(pageMap), totalPages, totalCount);
		case 3 :
			return soltScheduleList(dao.allScheduleListDate(pageMap), totalPages, totalCount); 
		case 4 : 
			pageMap.put("day", 1);
			return soltScheduleList(dao.allScheduleListDay(pageMap), totalPages, totalCount); 
		case 5 : 
			pageMap.put("day", 7);
			return soltScheduleList(dao.allScheduleListDay(pageMap), totalPages, totalCount); 
		case 6 : 
			pageMap.put("day", 30);
			return soltScheduleList(dao.allScheduleListDay(pageMap), totalPages, totalCount); 
		}
		return null;
	}
	
	public Map<String, Object> soltScheduleList(List<TourSchedulePlanVO> tourList, int totalPages, int totalCount) {
		for (TourSchedulePlanVO ts : tourList) {
			if (ts.getPicture() == 1) {
				ts.setCover(dao.getCover(ts.getRecordNo()));
			}
		}
		
		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("tourList", tourList);
		boardMap.put("totalPages", totalPages);
		boardMap.put("totalCount", totalCount);
		return boardMap; 
	}

	@Override
	public int addScheduleLike(ScheduleLikeVO sl) throws Exception {
		dao.addScheduleLike(sl);
		return dao.getScheduleLikeCount(sl.getRecordNo());
	}

	@Override
	public boolean checkScheduleLike(ScheduleLikeVO sl) throws Exception {
		ScheduleLikeVO slv = dao.checkScheduleLike(sl);
		if (slv == null) {
			return true;
		}
		return false;
	}

	@Override
	public int cancelScheduleLike(ScheduleLikeVO sl) throws Exception {
		dao.cancelScheduleLike(sl);
		return dao.getScheduleLikeCount(sl.getRecordNo());
	}

	@Override
	public int addCustomizing(TourScheduleVO tv) throws Exception {
		int beforeRecordNo = tv.getRecordNo();
		int recordNo = dao.addCustomizing(tv);
		System.out.println("recordNo : " + recordNo);
		System.out.println("before : " + beforeRecordNo);
		List<RecordLocationVO> list = dao.getScheduleLocation(beforeRecordNo);
		System.out.println(list.toString());
		for (RecordLocationVO rv : list) {
			rv.setRecordNo(recordNo);
			dao.addScheduleLocation(rv);
		}
		ScheduleLikeVO sl = new ScheduleLikeVO();
		sl.setRecordNo(beforeRecordNo);
		sl.setUserUid(tv.getUserUid());
		sl.setAfterRecordNo(recordNo);
		return dao.addCustomizingLike(sl);
	}

	@Override
	public boolean checkCustomizing(ScheduleLikeVO sl) throws Exception {
		ScheduleLikeVO slv = dao.checkCustomizing(sl);
		if (slv == null) {
			return true;
		}
		return false;
	}

	@Override
	public int cancelCustomizing(ScheduleLikeVO sl) throws Exception {
		ScheduleLikeVO slv = dao.checkCustomizing(sl);
		dao.delSchedule(slv.getAfterRecordNo());
		return dao.cancelCustomizingLike(sl);
	}

	@Override
	public int addScheduleBookmark(BoardBookMarkVO bbv) throws Exception {
		return dao.addScheduleBookmark(bbv);
	}

	@Override
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) throws Exception {
		return dao.cancelScheduleBookMark(bbv);
	}

	@Override
	public Map<String, Boolean> checkScheduleSet(ScheduleLikeVO sl, int targetType) throws Exception {
		Map<String, Boolean> map = new HashMap<>();
		BoardBookMarkVO bbv = new BoardBookMarkVO();
		bbv.setUserUid(sl.getUserUid());
		bbv.setTargetNo(sl.getRecordNo());
		bbv.setTargetType(targetType);
		
		ScheduleLikeVO slv = dao.checkScheduleLike(sl);
		if (slv == null) {
			map.put("scheduleLike", true);
		} else {
			map.put("scheduleLike", false);			
		}
		
		ScheduleLikeVO slv2 = dao.checkCustomizing(sl);
		if (slv2 == null) {
			map.put("customizing", true);
		} else {
			map.put("customizing", false);			
		}
		
		BoardBookMarkVO bbv2 = dao.checkScheduleBookMark(bbv);
		if (bbv2 == null) {
			map.put("bookMark", true);
		} else {
			map.put("bookMark", false);			
		}
		return map;
	}

	@Override
	public TourSchedulePlanVO scheduleListDetail(int no) throws Exception {
		TourSchedulePlanVO tv = dao.scheduleListDetail(no);
		if (tv.getPicture() == 1) {
			tv.setCover(dao.getCover(no));
		}
		return tv;
	}

	@Override
	public List<ScheduleListCommentVO> insertScheduleListComment(ScheduleListCommentVO slc) throws Exception {
		dao.insertScheduleListComment(slc);
		return dao.getScheduleListComment(slc.getRecordNo());
	}

	@Override
	public List<ScheduleListCommentVO> getScheduleListComment(int recordNo) throws Exception {
		return dao.getScheduleListComment(recordNo);
	}

	@Override
	public List<ScheduleListCommentVO> delScheduleListComment(int commentNo, int recordNo) throws Exception {
		dao.delScheduleListComment(commentNo);
		return dao.getScheduleListComment(recordNo);
	}

	@Override
	public Map<String,Object> addScheduleMemo(ScheduleMemoVO sm) throws Exception {
		Map<String,Object> map = new HashMap<>();
		int scheduleMemoNo = dao.addScheduleMemo(sm);
		List<ScheduleMemoVO> list = dao.getScheduleMemo(sm);
		for (ScheduleMemoVO sv : list) {
			sv.setPrice(dao.getMemoTravelPrice(sv.getScheduleMemoNo()));
		}
		map.put("scheduleMemoNo", scheduleMemoNo);
		map.put("list", list);
		return map;
	}

	@Override
	public List<ScheduleMemoVO> getScheduleMemo(ScheduleMemoVO sm) throws Exception {
		List<ScheduleMemoVO> list = dao.getScheduleMemo(sm);
		for (ScheduleMemoVO sd : list) {
			sd.setPrice(dao.getMemoTravelPrice(sd.getScheduleMemoNo()));
		}
		return list;
	}

	@Override
	public List<ScheduleMemoVO> getMyPost(String userUid) throws Exception {
		List<ScheduleMemoVO> list = dao.getMyPost(userUid);
		for (ScheduleMemoVO sd : list) {
			sd.setPrice(dao.getMemoTravelPrice(sd.getScheduleMemoNo()));
		}
		return list;
	}

	@Override
	public ScheduleMemoVO getDetailPost(ScheduleMemoVO sm) throws Exception {
		ScheduleMemoVO smv = dao.getDetailPost(sm);
		smv.setPrice(dao.getMemoTravelPrice(smv.getScheduleMemoNo()));
		return smv;
	}

	@Override
	public List<ScheduleMemoCommentVO> insertMemoComment(ScheduleMemoCommentVO smv) throws Exception {
		dao.insertMemoComment(smv);
		return dao.getMemoComment(smv.getScheduleMemoNo());
	}

	@Override
	public List<ScheduleMemoCommentVO> getMemoComment(int postNo) throws Exception {
		return dao.getMemoComment(postNo);
	}

	@Override
	public int addScheduleMemoLike(ScheduleMemoLikeVO sml) throws Exception {
		dao.addScheduleMemoLike(sml);
		return dao.getScheduleMemoLikeCnt(sml.getScheduleMemoNo());
	}

	@Override
	public int cancelScheduleMemoLike(ScheduleMemoLikeVO sml) throws Exception {
		dao.cancelScheduleMemoLike(sml);
		return dao.getScheduleMemoLikeCnt(sml.getScheduleMemoNo());
	}

	@Override
	public List<ScheduleMemoCommentVO> delMemoComment(ScheduleMemoCommentVO smc) throws Exception {
		dao.delMemoComment(smc.getCommentNo());
		return dao.getMemoComment(smc.getScheduleMemoNo());
	}

	@Override
	public void delScheduleMemo(int scheduleMemoNo) throws Exception {
		dao.delScheduleMemo(scheduleMemoNo);
		dao.delMemoPrice(scheduleMemoNo);
	}

	@Override
	public List<LocationLikedVO> getWishBoardList(String userUid) throws Exception {
		return dao.getWishBoardList(userUid);
	}

	@Override
	public List<ScheduleMemoVO> getLocationMemo(int contentId) throws Exception {
		// TODO Auto-generated method stub
		List<ScheduleMemoVO> list = dao.getLocationMemo(contentId);
		for (ScheduleMemoVO sv : list) {
			sv.setPrice(dao.getMemoTravelPrice(sv.getScheduleMemoNo()));
		}
		return list;
	}

	@Override
	public Map<String, Integer> checkLocationLikeCnt(int contentId) throws Exception {
		Map<String,Integer> map = new HashMap<>();
		map.put("likeCnt", dao.locationLikeCount(contentId));
		map.put("postCnt", dao.getLocationMemoCnt(contentId));
		map.put("backLocationCnt", dao.getBackLocationLikeCnt(contentId));
		return map;
	}

	@Override
	public int addBackLocationLike(LocationLikedVO ll) throws Exception {
		dao.addBackLocationLike(ll);
		return dao.getBackLocationLikeCnt(ll.getContentId());
	}

	@Override
	public int delBackLocationLike(LocationLikedVO ll) throws Exception {
		dao.delBackLocationLike(ll);
		return dao.getBackLocationLikeCnt(ll.getContentId());
	}

	@Override
	public List<LocationCommentVO> getLocationComment(int contentId) throws Exception {
		return dao.getLocationComment(contentId);
	}

	@Override
	public List<LocationCommentVO> addLocationComment(LocationCommentVO lc) throws Exception {
		dao.addLocationComment(lc);
		return dao.getLocationComment(lc.getContentId());
	}

	@Override
	public Map<String, Integer> checkScheduleDetailCnt(ScheduleLikeVO sv, int targetType) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		BoardBookMarkVO bbv = new BoardBookMarkVO();
		bbv.setTargetNo(sv.getRecordNo());
		bbv.setTargetType(targetType);
		map.put("likeCnt", dao.getScheduleLikeCount(sv.getRecordNo()));
		map.put("customizingCnt", dao.getCustomizingCnt(sv.getRecordNo()));
		map.put("bookMarkCnt", dao.getScheduleBookMark(bbv));
		return map;
	}

	@Override
	public List<Map<String, Object>> addTravelPrice(String list) throws Exception {
		ObjectMapper mapper =  new ObjectMapper();
		List<TravelPriceVO> tList = new ArrayList<>();
		tList = mapper.readValue(list, new TypeReference<List<TravelPriceVO>>() {});
		
		for (TravelPriceVO tp : tList) {
			dao.addTravelPrice(tp);
			System.out.println(tp.toString());
		}
		List<TravelPriceVO> getList = dao.getLocationTravelPrice(tList.get(0).getLocationNo());
		List<Map<String, Object>> resultList = new ArrayList<>();
		// priceType
		// 1. 교통비
		// 2. 음식
		// 3. 오락,엑티비티
		// 4. 쇼핑
		// 5. 숙박
		// 6. 기타
		
		for (TravelPriceVO tp : getList) {
			Map<String, Object> map = new HashMap<>();
			switch (tp.getPriceType()) {
			case 1: map.put("type", "교통비"); break;
			case 2: map.put("type", "음식"); break;
			case 3: map.put("type", "오락,엑티비티"); break;
			case 4: map.put("type", "쇼핑"); break;
			case 5: map.put("type", "숙박"); break;
			case 6: map.put("type", "기타"); break;
			}
			map.put("price", tp.getTravelPrice());
			resultList.add(map);
		}
		
		return resultList;
	}

	@Override
	public List<TravelPriceVO> getScheduleTravelPrice(int recordNo) throws Exception {
		return dao.getScheduleTravelPrice(recordNo);
	}

	@Override
	public Map<String, Object> addWishBoardReview(ScheduleMemoVO sm) throws Exception {
		Map<String,Object> map = new HashMap<>();
		int scheduleMemoNo = dao.addScheduleMemo(sm);
		List<ScheduleMemoVO> list = dao.addWishBoardReview(sm.getContentId());
		for (ScheduleMemoVO sv : list) {
			sv.setPrice(dao.getMemoTravelPrice(sv.getScheduleMemoNo()));
		}
		map.put("scheduleMemoNo", scheduleMemoNo);
		map.put("list", list);
		return map;
	}

	@Override
	public TourScheduleVO updateSchedule(TourScheduleVO ts, int type) throws Exception {
		// type : 1 출발 도착 날짜가 모두 같은 경우(지역, 메모 정보를 삭제 할 필요 없음)
		// type : 2 하나라도 다르면 지역, 메모 정보 전부 삭제
		System.out.println(ts.toString());
		switch (type) {
		case 1 : dao.updateScheduleSameDate(ts); break;
		case 2 : 
			dao.delScheduleLocation(ts.getRecordNo());
			dao.delScheduleAllMemo(ts.getRecordNo());
			dao.delSchedulePrice(ts.getRecordNo());
			dao.updateScheduleDifferentDate(ts);
			break;
		}
		return dao.getDetailTourSchedule(ts.getRecordNo());
	}

	@Override
	public List<LocationLikedVO> getLocationCnt(String contentIdJson) throws Exception {
		System.out.println(contentIdJson);
		ObjectMapper mapper =  new ObjectMapper();
		List<Integer> tList = mapper.readValue(contentIdJson, new TypeReference<List<Integer>>() {});
		List<LocationLikedVO> list = new ArrayList<>();
		for (Integer contentId : tList) {
			LocationLikedVO lv = dao.getLocationCnt(contentId);
			lv.setContentId(contentId);
			list.add(lv);
		}
		return list;
	}

}
