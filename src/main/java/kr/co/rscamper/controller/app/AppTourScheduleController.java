package kr.co.rscamper.controller.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
import kr.co.rscamper.service.TourScheduleService;

@Controller
@RequestMapping("/app/tourschedule")
public class AppTourScheduleController {

	@Inject
	private TourScheduleService service;
	
	@RequestMapping("/getschedule")
	@ResponseBody
	public List<TourScheduleVO> getScheduleList(String uid) throws Exception {
		System.out.println("asdasd");
		List<TourScheduleVO> tList = new ArrayList<>();
		tList = service.getSchedule(uid);
		for (TourScheduleVO ts : tList) {
			if (ts.getPicture() == 1) {
				ts.setCover(service.getCover(ts.getRecordNo()));
			}
		}
		return tList;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public List<TourScheduleVO> insertTourSchedule(String uid, String title, String sDate, String fDate, int isOpen) throws Exception {
		TourScheduleVO tv = new TourScheduleVO();
		System.out.println("스케줄등록");
		tv.setUserUid(uid);
		tv.setTitle(title);
		tv.setDepartureDate(parseDate(sDate));
		tv.setArriveDate(parseDate(fDate));
		tv.setPeriod(getDate(tv.getDepartureDate(), tv.getArriveDate()));
		// 1 = 공개     2 = 비공개
		tv.setIsOpen(isOpen);
		service.insertSchedule(tv);
		return getScheduleList(uid);
	}
	
	public Date parseDate(String date) throws Exception {
		String parseDay[] = date.split("T");
		String date1[] = parseDay[0].split("-"); 
		int day = Integer.parseInt(date1[2]) + 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.parse(date1[0] + "-" + date1[1] + "-" + day);
	}
	
	public String getDate(Date dDate, Date aDate) {
		String d = "";
		long nTime = aDate.getTime() - dDate.getTime();
		long year = nTime/1000/60/60/24/365;
		long day = nTime/1000/60/60/24;
		if (year == 0 && day >= 1) {
			long duty = day + 1;
			d = day + "박" + duty + "일";
		} else {
			d = "1일";
		}
		System.out.println(d);
		return d;
	}
	
	@RequestMapping("/getTourDate")
	@ResponseBody
	public List<String> getTourDate(long dDate, long aDate) throws Exception {
		long nTime = aDate - dDate;
		long day = 1000 * 60 * 60 * 24;
		int period = (int) (nTime/day);
		List<String> dayList = new ArrayList<>();
		dayList.add(getWeek(new Date(dDate)));
		long nextDay = dDate + day;
		while (aDate >= nextDay) {
			dayList.add(getWeek(new Date(nextDay)));
			nextDay = nextDay + day;
		}
		for(String aaa : dayList) {
			System.out.println(aaa);
		}
		return dayList;
	}
	
	public String getWeek(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd.");
		String dayText = sdf.format(d);
		switch (d.getDay()) {
		case 0: dayText = dayText +  " 일"; break;
		case 1: dayText = dayText +  " 월"; break;
		case 2: dayText = dayText +  " 화"; break;
		case 3: dayText = dayText +  " 수"; break;
		case 4: dayText = dayText +  " 목"; break;
		case 5: dayText = dayText +  " 금"; break;
		case 6: dayText = dayText +  " 토"; break;
		}
		return dayText;
	}
	
	@RequestMapping("/delSchedule")
	@ResponseBody
	public List<TourScheduleVO> delSchedule(String uid, int no) throws Exception {
		service.delSchedule(no);
		return getScheduleList(uid);
	}
	
	@RequestMapping("/changeCover")
	@ResponseBody
	public TourScheduleVO changeCover(int no, int isPhoto, String photo) throws Exception {
		System.out.println("Asdasd");
		RecordCoverVO rc = new RecordCoverVO();
		rc.setRecordNo(no);
		rc.setFilePath(photo);
		if (isPhoto == 0) {
			service.insertCover(rc);
		} else {
			service.changeCover(rc);
		}
		TourScheduleVO tv = service.getDetailTourSchedule(no);
		tv.setCover(service.getCover(no));
		return tv;
	}
	
	@RequestMapping("/updateStrapline")
	@ResponseBody
	public TourScheduleVO updateStrapline(int no, String title, String content) throws Exception {
		TourScheduleVO tv = new TourScheduleVO();
		tv.setRecordNo(no);
		tv.setStrapline(title);
		tv.setIntroduce(content);
		service.updateStrapline(tv);
		return service.getDetailTourSchedule(no);
	}
	
	@RequestMapping("/addScheduleLocation")
	@ResponseBody
	public void addScheduleLocation(String add, String title, String imgUrl, String contentCode, String contentTypeId, int recordNo, double mapX, double mapY) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd. hh:mm");
		String getDate[] = add.replace("[", "").replace("\"","").replace("]", "").split(",");
		String timeData[] = getDate[0].substring(0, 12).replace(" ", "").split("\\.");
		Date d = new Date(Integer.parseInt(timeData[0]) - 1900, Integer.parseInt(timeData[1]) - 1, Integer.parseInt(timeData[2]), Integer.parseInt(getDate[1]), Integer.parseInt(getDate[2]));
		RecordLocationVO rl = new RecordLocationVO();
		rl.setRecordNo(recordNo);
		rl.setImageUrl(imgUrl);
		rl.setContentCode(Integer.parseInt(contentCode));
		rl.setContentTypeId(Integer.parseInt(contentTypeId));
		rl.setDepartureDate(getDate[0]);
		System.out.println("--------------------------------------");
		System.out.println(rl.getDepartureDate());
		System.out.println("--------------------------------------");
		for (String a : timeData) {
			System.out.println(a);
		}
		System.out.println("--------------------------------------");
		rl.setDetailDepartureDate(d);
		System.out.println(rl.getDetailDepartureDate());
		rl.setTitle(title);
		rl.setMapX(mapX);
		rl.setMapY(mapY);
		service.addScheduleLocation(rl);
	}
	
	@RequestMapping("/getScheduleLocation")
	@ResponseBody
	public List<RecordLocationVO> getScheduleLocation(int no) throws Exception {
		List<RecordLocationVO> rl = service.getScheduleLocation(no);
		
		for (RecordLocationVO rv : rl) {
			rv.setLikeCount(service.locationLikeCount(rv.getContentCode()));
		}
		return rl;
	}
	
	@RequestMapping("/delLocation")
	@ResponseBody
	public List<RecordLocationVO> delLocation(int locationNo, int no) throws Exception {
		service.delLocation(locationNo);
		
		List<RecordLocationVO> rl = service.getScheduleLocation(no);
		
		for (RecordLocationVO rv : rl) {
			rv.setLikeCount(service.locationLikeCount(rv.getContentCode()));
		}
		return rl;
	}
	
	@RequestMapping("/locationLikeCount")
	@ResponseBody
	public int locationLikeCount(int no) throws Exception {
		return service.locationLikeCount(no);
	}
	
	@RequestMapping("/checkedIsLike")
	@ResponseBody
	public Map<String, Object> checkedIsLike(LocationLikedVO ll) throws Exception {
		return service.checkedIsLike(ll);
	}
	
	@RequestMapping("/insertLikePlus")
	@ResponseBody
	public int insertLikePlus(int no, String uid) throws Exception {
		LocationLikedVO ll = new LocationLikedVO();
		ll.setContentId(no);
		ll.setUid(uid);
		service.insertLikePlus(ll);
		System.out.println(no);
		System.out.println(uid);
		
		return service.locationLikeCount(no);
	}
	
	@RequestMapping("/removeLiked")
	@ResponseBody
	public int removeLiked(int no, String uid) throws Exception {
		LocationLikedVO ll = new LocationLikedVO();
		ll.setContentId(no);
		ll.setUid(uid);	
		service.removeLiked(ll);
		return service.locationLikeCount(no);
	}
	
	
	@RequestMapping("/allScheduleList")
	@ResponseBody
	public Map<String, Object> allScheduleList(int page, int count, int soltType) throws Exception {
		return service.allScheduleList(page, count, soltType);
	}
	
	@RequestMapping("/checkScheduleLike")
	@ResponseBody
	public boolean checkScheduleLike(ScheduleLikeVO sl) throws Exception {
		return service.checkScheduleLike(sl);
	}
	
	@RequestMapping("/addScheduleLike")
	@ResponseBody
	public int addScheduleLike(ScheduleLikeVO sl) throws Exception {
		return service.addScheduleLike(sl);
	}
	
	@RequestMapping("/cancelScheduleLike")
	@ResponseBody
	public int cancelScheduleLike(ScheduleLikeVO sl) throws Exception {
		return service.cancelScheduleLike(sl);
	}
	
	@RequestMapping("/addCustomizing")
	@ResponseBody
	public int addCustomizing(TourScheduleVO tv) throws Exception {
		return service.addCustomizing(tv);
	}
	
	@RequestMapping("/checkCustomizing")
	@ResponseBody
	public boolean checkCustomizing(ScheduleLikeVO sl) throws Exception {
		return service.checkCustomizing(sl);
	}
	
	@RequestMapping("/cancelCustomizing")
	@ResponseBody
	public int cancelCustomizing(ScheduleLikeVO sl) throws Exception {
		return service.cancelCustomizing(sl);
	}
	
	@RequestMapping("/addScheduleBookmark")
	@ResponseBody
	public int addScheduleBookmark(BoardBookMarkVO bbv) throws Exception {
		return service.addScheduleBookmark(bbv);
	}
	
	@RequestMapping("/cancelScheduleBookMark")
	@ResponseBody
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) throws Exception {
		return service.cancelScheduleBookMark(bbv);
	}
	
	@RequestMapping("/checkScheduleSet")
	@ResponseBody
	public Map<String, Boolean> checkScheduleSet(ScheduleLikeVO sl, int targetType) throws Exception {
		return service.checkScheduleSet(sl, targetType);
	}
	
	@RequestMapping("/scheduleListDetail")
	@ResponseBody
	public TourSchedulePlanVO scheduleListDetail(int no) throws Exception {
		return service.scheduleListDetail(no);
	}
	
	@RequestMapping("/insertScheduleListComment")
	@ResponseBody
	public List<ScheduleListCommentVO> insertScheduleListComment(ScheduleListCommentVO slc) throws Exception {
		return service.insertScheduleListComment(slc);
	}
	
	@RequestMapping("/getScheduleListComment")
	@ResponseBody
	public List<ScheduleListCommentVO> getScheduleListComment(int recordNo) throws Exception {
		return service.getScheduleListComment(recordNo);
	}
	
	@RequestMapping("/delScheduleListComment")
	@ResponseBody
	public List<ScheduleListCommentVO> delScheduleListComment(int commentNo, int recordNo) throws Exception {
		return service.delScheduleListComment(commentNo, recordNo);
	}
	
	@RequestMapping("/addScheduleMemo")
	@ResponseBody
	public Map<String,Object> addScheduleMemo(ScheduleMemoVO sm) throws Exception {
		return service.addScheduleMemo(sm);
	}
	
	@RequestMapping("/getScheduleMemo")
	@ResponseBody
	public List<ScheduleMemoVO> getScheduleMemo(ScheduleMemoVO sm) throws Exception {
		return service.getScheduleMemo(sm);
	}
	
	@RequestMapping("/getMyPost")
	@ResponseBody
	public List<ScheduleMemoVO> getMyPost(String userUid) throws Exception {
		return service.getMyPost(userUid);
	}
	
	@RequestMapping("/getDetailPost")
	@ResponseBody
	public ScheduleMemoVO getDetailPost(ScheduleMemoVO sm) throws Exception {
		return service.getDetailPost(sm);
	}
	
	@RequestMapping("/insertMemoComment")
	@ResponseBody
	public List<ScheduleMemoCommentVO> insertMemoComment(ScheduleMemoCommentVO smv) throws Exception {
		return service.insertMemoComment(smv);
	}
	
	@RequestMapping("/getMemoComment")
	@ResponseBody
	public List<ScheduleMemoCommentVO> getMemoComment(int postNo) throws Exception {
		return service.getMemoComment(postNo);
	}
	
	@RequestMapping("/addScheduleMemoLike")
	@ResponseBody
	public int addScheduleMemoLike(ScheduleMemoLikeVO sml) throws Exception {
		return service.addScheduleMemoLike(sml);
	}
	
	@RequestMapping("/cancelScheduleMemoLike")
	@ResponseBody
	public int cancelScheduleMemoLike(ScheduleMemoLikeVO sml) throws Exception {
		return service.cancelScheduleMemoLike(sml);
	}
	
	@RequestMapping("/delMemoComment")
	@ResponseBody
	public List<ScheduleMemoCommentVO> delMemoComment(ScheduleMemoCommentVO smc) throws Exception {
		return service.delMemoComment(smc);
	}
	
	@RequestMapping("/delScheduleMemo")
	@ResponseBody
	public void delScheduleMemo(int scheduleMemoNo) throws Exception {
		service.delScheduleMemo(scheduleMemoNo);
	}
	
	@RequestMapping("/getWishBoardList")
	@ResponseBody
	public List<LocationLikedVO> getWishBoardList(String userUid) throws Exception {
		return service.getWishBoardList(userUid);
	}
	
	@RequestMapping("/getLocationMemo")
	@ResponseBody
	public List<ScheduleMemoVO> getLocationMemo(int contentId) throws Exception {
		return service.getLocationMemo(contentId);
	}
	
	@RequestMapping("/checkLocationLikeCnt")
	@ResponseBody
	public Map<String,Integer> checkLocationLikeCnt(int contentId) throws Exception {
		return service.checkLocationLikeCnt(contentId);
	}
	
	@RequestMapping("/addBackLocationLike")
	@ResponseBody
	public int addBackLocationLike(LocationLikedVO ll) throws Exception {
		return service.addBackLocationLike(ll);
	}
	
	@RequestMapping("/delBackLocationLike")
	@ResponseBody
	public int delBackLocationLike(LocationLikedVO ll) throws Exception {
		return service.delBackLocationLike(ll);
	}
	
	@RequestMapping("/getLocationComment")
	@ResponseBody
	public List<LocationCommentVO> getLocationComment(int contentId) throws Exception {
		return service.getLocationComment(contentId);
	}
	
	@RequestMapping("/addLocationComment")
	@ResponseBody
	public List<LocationCommentVO> addLocationComment(LocationCommentVO lc) throws Exception {
		return service.addLocationComment(lc);
	}
	
	@RequestMapping("/checkScheduleDetailCnt")
	@ResponseBody
	public Map<String, Integer> checkScheduleDetailCnt(ScheduleLikeVO sv, int targetType) throws Exception {
		return service.checkScheduleDetailCnt(sv, targetType);
	}
	
	@RequestMapping("/addTravelPrice")
	@ResponseBody
	public List<Map<String, Object>> addTravelPrice(String list) throws Exception {
		return service.addTravelPrice(list);
	}
	
	@RequestMapping("/getScheduleTravelPrice")
	@ResponseBody
	public List<TravelPriceVO> getScheduleTravelPrice(int recordNo) throws Exception {
		return service.getScheduleTravelPrice(recordNo);
	}
	
	@RequestMapping("/addWishBoardReview")
	@ResponseBody
	public Map<String,Object> addWishBoardReview (ScheduleMemoVO sm) throws Exception {
		return service.addWishBoardReview(sm);
	}
	
	@RequestMapping("/updateSchedule")
	@ResponseBody
	public TourScheduleVO updateSchedule(TourScheduleVO ts, int type) throws Exception {
		return service.updateSchedule(ts, type);
	}
	
	@RequestMapping("/getLocationCnt")
	@ResponseBody
	public List<LocationLikedVO> getLocationCnt(String contentIdJson) throws Exception {
		return service.getLocationCnt(contentIdJson);
	}
}