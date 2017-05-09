package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

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

public interface TourScheduleService {
	public List<TourScheduleVO> getSchedule(String uid) throws Exception;
	
	public void insertSchedule(TourScheduleVO tv) throws Exception;
	
	public void delSchedule(int no) throws Exception;
	
	public void changeCover(RecordCoverVO rc) throws Exception;
	
	public void insertCover(RecordCoverVO rc) throws Exception;
	
	public RecordCoverVO getCover(int no) throws Exception;
	
	public TourScheduleVO getDetailTourSchedule(int no) throws Exception;
	
	public void updateStrapline(TourScheduleVO tv) throws Exception;
	
	public void addScheduleLocation(RecordLocationVO rl) throws Exception;
	
	public List<RecordLocationVO> getScheduleLocation(int no) throws Exception;
	
	public int locationLikeCount(int code) throws Exception;
	
	public int isLike() throws Exception;
	
	public void insertLikePlus(LocationLikedVO ll) throws Exception;
	
	public Map<String, Object> checkedIsLike(LocationLikedVO ll) throws Exception;
	
	public void removeLiked(LocationLikedVO ll) throws Exception;
	
	public void delLocation(int locationNo) throws Exception;
	
	public Map<String, Object> allScheduleList(int page, int count, int soltType) throws Exception;
	
	public int addScheduleLike(ScheduleLikeVO sl) throws Exception;
	
	public boolean checkScheduleLike(ScheduleLikeVO sl) throws Exception;
	
	public int cancelScheduleLike(ScheduleLikeVO sl) throws Exception;
	
	public int addCustomizing(TourScheduleVO tv) throws Exception;
	
	public boolean checkCustomizing(ScheduleLikeVO sl) throws Exception;
	
	public int cancelCustomizing(ScheduleLikeVO sl) throws Exception;
	
	public int addScheduleBookmark(BoardBookMarkVO bbv) throws Exception;
	
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) throws Exception;
	
	public Map<String, Boolean> checkScheduleSet(ScheduleLikeVO sl, int targetType) throws Exception;
	
	public TourSchedulePlanVO scheduleListDetail(int no) throws Exception;
	
	public List<ScheduleListCommentVO> insertScheduleListComment(ScheduleListCommentVO slc) throws Exception;
	
	public List<ScheduleListCommentVO> getScheduleListComment(int recordNo) throws Exception;
	
	public List<ScheduleListCommentVO> delScheduleListComment(int commentNo, int recordNo) throws Exception;
	
	public Map<String,Object> addScheduleMemo(ScheduleMemoVO sm) throws Exception;
	
	public List<ScheduleMemoVO> getScheduleMemo(ScheduleMemoVO sm) throws Exception;
	
	public List<ScheduleMemoVO> getMyPost(String userUid) throws Exception;
	
	public ScheduleMemoVO getDetailPost(ScheduleMemoVO sm) throws Exception;
	
	public List<ScheduleMemoCommentVO> insertMemoComment(ScheduleMemoCommentVO smv) throws Exception;
	
	public List<ScheduleMemoCommentVO> getMemoComment(int postNo) throws Exception;
	
	public int addScheduleMemoLike(ScheduleMemoLikeVO sml) throws Exception;
	
	public int cancelScheduleMemoLike(ScheduleMemoLikeVO sml) throws Exception;
	
	public List<ScheduleMemoCommentVO> delMemoComment(ScheduleMemoCommentVO smc) throws Exception;
	
	public void delScheduleMemo(int scheduleMemoNo) throws Exception;
	
	public List<LocationLikedVO> getWishBoardList(String userUid) throws Exception;
	
	public List<ScheduleMemoVO> getLocationMemo(int contentId) throws Exception;
	
	public Map<String,Integer> checkLocationLikeCnt(int contentId) throws Exception;
	
	public int addBackLocationLike(LocationLikedVO ll) throws Exception;
	
	public int delBackLocationLike(LocationLikedVO ll) throws Exception;
	
	public List<LocationCommentVO> getLocationComment(int contentId) throws Exception;
	
	public List<LocationCommentVO> addLocationComment(LocationCommentVO lc) throws Exception;
	
	public Map<String, Integer> checkScheduleDetailCnt(ScheduleLikeVO sv, int targetType) throws Exception;
	
	public List<Map<String, Object>> addTravelPrice(String list) throws Exception;
	
	public List<TravelPriceVO> getScheduleTravelPrice(int recordNo) throws Exception;
	
	public Map<String,Object> addWishBoardReview (ScheduleMemoVO sm) throws Exception;
	
	public TourScheduleVO updateSchedule(TourScheduleVO ts, int type) throws Exception;
	
	public List<LocationLikedVO> getLocationCnt(String contentIdJson) throws Exception;
}
