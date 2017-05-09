package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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

@Repository
public class TourScheduleDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.TourSchedule";
	
	public List<TourScheduleVO> getSchedule(String uid) {
		return sqlSessionTemplate.selectList(namespace + ".getSchedule", uid);
	}
	
	public void insertSchedule(TourScheduleVO tv) {
		sqlSessionTemplate.insert(namespace + ".insertSchedule", tv);
	}
	
	public void delSchedule(int no) {
		sqlSessionTemplate.delete(namespace + ".delSchedule", no);
	}
	
	public void delCover(int no) {
		sqlSessionTemplate.delete(namespace + ".delCover", no);
	}
	
	public void delScheduleLocation(int no) {
		sqlSessionTemplate.delete(namespace + ".delScheduleLocation", no);
	}
	
	public void changeCover(RecordCoverVO rc) {
		sqlSessionTemplate.update(namespace + ".changeCover", rc);
	}
	
	public void insertCover(RecordCoverVO rc) {
		sqlSessionTemplate.insert(namespace + ".insertCover",rc);
		int no = rc.getRecordNo();
		System.out.println(no);
		sqlSessionTemplate.update(namespace + ".updateCover", no);
	}
	
	public RecordCoverVO getCover(int no) {
		return sqlSessionTemplate.selectOne(namespace + ".getCover", no);
	}
	
	public TourScheduleVO getDetailTourSchedule(int no) {
		return sqlSessionTemplate.selectOne(namespace + ".getDetailTourSchedule", no);
	}
	
	public void updateStrapline(TourScheduleVO tv) {
		sqlSessionTemplate.update(namespace + ".updateStrapline", tv);
	}
	
	public void addScheduleLocation(RecordLocationVO rl) {
		sqlSessionTemplate.insert(namespace + ".addScheduleLocation", rl);
	}
	
	public List<RecordLocationVO> getScheduleLocation(int no) {
		return sqlSessionTemplate.selectList(namespace + ".getScheduleLocation", no);
	}
	
	public int locationLikeCount(int code) {
		return sqlSessionTemplate.selectOne(namespace + ".locationLikeCount", code);
	}
	
	public void insertLikePlus(LocationLikedVO ll) {
		sqlSessionTemplate.insert(namespace + ".insertLikePlus", ll);
	}
	
	public LocationLikedVO checkedIsLike(LocationLikedVO ll) {
		return sqlSessionTemplate.selectOne(namespace + ".checkedIsLike", ll);
	}
	
	public void removeLiked(LocationLikedVO ll) {
		sqlSessionTemplate.delete(namespace + ".removeLiked", ll);
	}
	
	public void delLocation(int locationNo) {
		sqlSessionTemplate.delete(namespace + ".delLocation",locationNo);
	}
	
	public List<TourSchedulePlanVO> allScheduleList(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".allScheduleList",pageMap);
	}
	
	public List<TourSchedulePlanVO> allScheduleListDate(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".allScheduleListDate",pageMap);
	}
	
	public List<TourSchedulePlanVO> allScheduleListDay(Map<String, Integer> pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".allScheduleListDay",pageMap);
	}
	
	public int selectScheduleCount() {
		return sqlSessionTemplate.selectOne(namespace + ".selectScheduleCount");
	}
	
	public void addScheduleLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.insert(namespace + ".addScheduleLike", sl);
	}
	
	public int getScheduleLikeCount(int recordNo) {
		return sqlSessionTemplate.selectOne(namespace + ".getScheduleLikeCount", recordNo);
	}
	
	public ScheduleLikeVO checkScheduleLike(ScheduleLikeVO sl) {
		return sqlSessionTemplate.selectOne(namespace + ".checkScheduleLike", sl);
	}
	
	public void cancelScheduleLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.delete(namespace + ".cancelScheduleLike", sl);
	}
	
	public int addCustomizing(TourScheduleVO tv) {
		sqlSessionTemplate.insert(namespace + ".addCustomizing", tv);
		return tv.getRecordNo(); 
	}
	
	public int getCustomizingCnt(int recordNo) {
		return sqlSessionTemplate.selectOne(namespace + ".getCustomizingLikeCount", recordNo);
	}
	
	public int addCustomizingLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.insert(namespace + ".addCustomizingLike", sl);
		return sqlSessionTemplate.selectOne(namespace + ".getCustomizingLikeCount", sl);
	}
	
	public ScheduleLikeVO checkCustomizing(ScheduleLikeVO sl) {
		return sqlSessionTemplate.selectOne(namespace + ".checkCustomizingLike", sl);
	}
	
	public int cancelCustomizingLike(ScheduleLikeVO sl) {
		sqlSessionTemplate.delete(namespace + ".cancelCustomizingLike", sl);
		return sqlSessionTemplate.selectOne(namespace + ".getCustomizingLikeCount", sl);
	}
	
	public int addScheduleBookmark(BoardBookMarkVO bbv) {
		sqlSessionTemplate.insert(namespace + ".addScheduleBookmark", bbv);
		return sqlSessionTemplate.selectOne(namespace + ".getScheduleBookMarkCount", bbv);
	}
	
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) {
		sqlSessionTemplate.delete(namespace + ".cancelScheduleBookMark", bbv);
		return sqlSessionTemplate.selectOne(namespace + ".getScheduleBookMarkCount", bbv);
	}
	
	public int getScheduleBookMark (BoardBookMarkVO bbv) {
		return sqlSessionTemplate.selectOne(namespace + ".getScheduleBookMarkCount", bbv);
	}
	
	public BoardBookMarkVO checkScheduleBookMark(BoardBookMarkVO bbv) {
		return sqlSessionTemplate.selectOne(namespace + ".checkScheduleBookMark", bbv);
	}
	
	public TourSchedulePlanVO scheduleListDetail(int no) {
		return sqlSessionTemplate.selectOne(namespace + ".scheduleListDetail", no);
	}
	
	public void insertScheduleListComment(ScheduleListCommentVO slc) {
		sqlSessionTemplate.insert(namespace + ".insertScheduleListComment", slc);
	}
	
	public List<ScheduleListCommentVO> getScheduleListComment(int recordNo) {
		return sqlSessionTemplate.selectList(namespace + ".getScheduleListComment", recordNo);
	}
	
	public void delScheduleListComment(int commentNo) {
		sqlSessionTemplate.delete(namespace + ".delScheduleListComment", commentNo);
	}
	
	public int addScheduleMemo(ScheduleMemoVO sm) {
		sqlSessionTemplate.insert(namespace + ".addScheduleMemo", sm);
		return sm.getScheduleMemoNo();
	}
	
	public List<ScheduleMemoVO> getScheduleMemo(ScheduleMemoVO sm) {
		return sqlSessionTemplate.selectList(namespace + ".getScheduleMemo", sm);
	}
	
	public List<ScheduleMemoVO> getMyPost(String userUid) {
		return sqlSessionTemplate.selectList(namespace + ".getMyPost", userUid);
	}
	
	public ScheduleMemoVO getDetailPost(ScheduleMemoVO sm) {
		return sqlSessionTemplate.selectOne(namespace + ".getDetailPost", sm);
	}
	
	public void insertMemoComment(ScheduleMemoCommentVO smv) {
		sqlSessionTemplate.insert(namespace + ".insertMemoComment", smv);
	}
	
	public List<ScheduleMemoCommentVO> getMemoComment(int postNo) {
		return sqlSessionTemplate.selectList(namespace + ".getMemoComment", postNo);
	}
	
	public void addScheduleMemoLike(ScheduleMemoLikeVO sml) {
		sqlSessionTemplate.insert(namespace + ".addScheduleMemoLike", sml);
	}
	
	public void cancelScheduleMemoLike(ScheduleMemoLikeVO sml) {
		sqlSessionTemplate.delete(namespace + ".cancelScheduleMemoLike", sml);
	}
	
	public int getScheduleMemoLikeCnt(int commentNo) {
		return sqlSessionTemplate.selectOne(namespace + ".getScheduleMemoLikeCnt", commentNo);
	}
	
	public void delMemoComment(int commentNo) {
		sqlSessionTemplate.delete(namespace + ".delMemoComment", commentNo);
	}
	
	public void delScheduleMemo(int scheduleMemoNo) {
		sqlSessionTemplate.delete(namespace + ".delScheduleMemo", scheduleMemoNo);
		sqlSessionTemplate.delete(namespace + ".delScheduleMemoComment", scheduleMemoNo);
		sqlSessionTemplate.delete(namespace + ".delScheduleMemolike", scheduleMemoNo);
	}
	
	public List<LocationLikedVO> getWishBoardList(String userUid) {
		return sqlSessionTemplate.selectList(namespace + ".getWishBoardList", userUid);
	}
	
	public int getBackLocationLikeCnt(int contentId) {
		return sqlSessionTemplate.selectOne(namespace + ".getBackLocationLikeCnt", contentId);
	}
	
	public List<ScheduleMemoVO> getLocationMemo(int contentId) {
		return sqlSessionTemplate.selectList(namespace + ".getLocationMemo", contentId);
	}
	
	public int getLocationMemoCnt(int contentId) {
		return sqlSessionTemplate.selectOne(namespace + ".getLocationMemoCnt", contentId);
	}
	
	public void addBackLocationLike(LocationLikedVO ll) {
		sqlSessionTemplate.insert(namespace + ".addBackLocationLike", ll);
	}
	
	public void delBackLocationLike(LocationLikedVO ll) {
		sqlSessionTemplate.delete(namespace + ".delBackLocationLike", ll);
	}
	
	public LocationLikedVO checkBackLocationLike(LocationLikedVO ll) {
		return sqlSessionTemplate.selectOne(namespace + ".checkBackLocationLike", ll);
	}
	
	public List<LocationCommentVO> getLocationComment(int contentId) {
		return sqlSessionTemplate.selectList(namespace + ".getLocationComment", contentId);
	}
	
	public void addLocationComment(LocationCommentVO lc) {
		sqlSessionTemplate.insert(namespace + ".addLocationComment", lc);
	}
	
	public void addTravelPrice(TravelPriceVO tp) {
		sqlSessionTemplate.insert(namespace + ".addTravelPrice", tp);
	}
	
	public List<TravelPriceVO> getLocationTravelPrice(int locationNo) {
		return sqlSessionTemplate.selectList(namespace + ".getLocationTravelPrice", locationNo);
	}
	
	public List<TravelPriceVO> getScheduleTravelPrice(int recordNo) {
		return sqlSessionTemplate.selectList(namespace + ".getScheduleTravelPrice", recordNo);
	}
	
	public List<TravelPriceVO> getMemoTravelPrice(int scheduleMemoNo) {
		return sqlSessionTemplate.selectList(namespace + ".getMemoTravelPrice", scheduleMemoNo);
	}
	
	public void delMemoPrice(int scheduleMemoNo) {
		sqlSessionTemplate.delete(namespace + ".delMemoPrice", scheduleMemoNo);
	}
	
	public void delLocationPrice(int locationNo) {
		sqlSessionTemplate.delete(namespace + ".delLocationPrice", locationNo);
	}
	
	public void delLocationMemo(int locationNo) {
		sqlSessionTemplate.delete(namespace + ".delLocationMemo", locationNo);
	}
	
	public void delScheduleAllMemo(int no) {
		sqlSessionTemplate.delete(namespace + ".delScheduleAllMemo", no);
	}
	
	public void delSchedulePrice(int no) {
		sqlSessionTemplate.delete(namespace + ".delSchedulePrice", no);
	}
	
	public List<ScheduleMemoVO> addWishBoardReview(int contentId) {
		return sqlSessionTemplate.selectList(namespace + ".addWishBoardReview", contentId);
	}
	
	public void updateScheduleSameDate(TourScheduleVO ts) {
		sqlSessionTemplate.update(namespace + ".updateScheduleSameDate", ts);
	}
	
	public void updateScheduleDifferentDate(TourScheduleVO ts) {
		sqlSessionTemplate.update(namespace + ".updateScheduleDifferentDate", ts);
	}
	
	public LocationLikedVO getLocationCnt(int contentId) {
		return sqlSessionTemplate.selectOne(namespace + ".getLocationCnt", contentId);
	}

}
