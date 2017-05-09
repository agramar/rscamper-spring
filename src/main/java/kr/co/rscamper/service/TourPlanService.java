package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.TourPlanBudgetForChartVO;
import kr.co.rscamper.domain.TourPlanCommentVO;
import kr.co.rscamper.domain.TourPlanCoverVO;
import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanScheduleVO;
import kr.co.rscamper.domain.TourPlanSpotMemoVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.TravelPriceVO;

public interface TourPlanService {

	/** 여행일정 리스트 가져오기 */
	public Map<String, Object> selectTourPlanList(TourPlanParamVO tourPlanParam);

	/** 여행일정 신규 작성 */
	public int insertTourPlan(TourPlanVO tourPlan);

	/** 장소정보 리스트 가져오기 */
	public Map<String, Object> selectSpotList(TourPlanSpotParamVO tourPlanSpotParam);

	/** 여행일정 한개 가져오기 */
	public TourPlanVO selectTourPlan(int recordNo);

	/** 여행일정 - 커버 이미지 수정 */
	public void updateCoverImage(TourPlanCoverVO tourPlanCover);

	/** 여행일정 - 제목 수정 */
	public void updateTourPlanTitle(TourPlanVO tourPlan);

	/** 여행일정 수정 */
	public void updateTourPlan(TourPlanVO tourPlan);

	/** 여행일정 - 스케쥴 리스트 등록 */
	public void insertTourPlanSchedule(TourPlanScheduleVO tourPlanSchedule);

	/** 여행일정 - 스케쥴 리스트 삭제 */
	public void deleteTourPlanScheduleByRecordNo(int recordNo);

	/** 여행일정 - 스케쥴 리스트 가져오기 */
	public List<TourPlanScheduleVO> selectTourPlanScheduleListByRecordNo(int recordNo);

	/** 장소정보 디테일 가져오기*/
	public TourPlanSpotVO selectSpotDetail(int contentid);

	/** 공개 비공개 토글 */
	public int updateTourPlanOpen(TourPlanVO tourPlan);

	/** 댓글 등록 */
	public void insertTourPlanComment(TourPlanCommentVO tourPlanComment);

	/** 댓글 리스트 조회 */
	public List<TourPlanCommentVO> selectTourPlanCommentListByRecordNo(int recordNo);

	/** 댓글 삭제 */
	public void deleteTourPlanCommentByCommentNo(int commentNo);

	/** 일정 삭제 */
	public void deleteTourPlanByRecordNo(int recordNo);

	/** 일정 리스트 추천수순 15개 조회 */
	public List<TourPlanVO> selectTourPlanListByLikeCnt();

	/** 내 여행일정 리스트 가져오기 */
	public List<TourPlanVO> selectMyTourPlanList(String userUid);

	/** 북마크한 여행일정 리스트 가져오기 */
	public List<TourPlanVO> selectBookmarkTourPlanList(String userUid);

	/** 북마크한 여행장소 리스트 가져오기 */
	public Map<String, Object> selectBookmarkSpotList(TourPlanSpotParamVO tourPlanSpotParam);

	/** 여행장소 메모 리스트 가져오기 */
	public List<TourPlanSpotMemoVO> selectTourSpotMemoList(int recordNo);

	/** 여행장소 메모 등록 */
	public void insertTourSpotMemo(TourPlanSpotMemoVO tourPlanSpotMemo);

	/** 여행장소 메모 삭제 */
	public void deleteTourSpotMemoBylocationMemoNo(int scheduleMemoNo);

	/** 여행장소 예산 등록 */
	public void insertTourPlanBudget(TravelPriceVO travelPrice);

	/** 예산 하나 삭제 */
	public void deleteTourPlanBudgetByTravelPriceNo(int travelPriceNo);

	/** 예산 리스트 가져오기 (차트) */
	public List<TourPlanBudgetForChartVO> selectBudgetListForChartByRecordNo(int recordNo);

}
