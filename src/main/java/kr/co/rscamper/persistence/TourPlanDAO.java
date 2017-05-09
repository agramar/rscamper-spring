package kr.co.rscamper.persistence;

import java.util.List;

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

public interface TourPlanDAO {

	/** 여행일정 메인 조회 */
	public List<TourPlanVO> selectTourPlanList(TourPlanParamVO tourPlanParam);

	/** 여행일정 총 개수 조회 */
	public int selectTourPlanTotalPages(TourPlanParamVO tourPlanParam);

	/** 여행일정 신규 등록 */
	public int insertTourPlan(TourPlanVO tourPlan);

	/** 여행장소 총 개수 조회 */
	public int selectSpotTotalPages(TourPlanSpotParamVO tourPlanSpotParam);

	/** 여행장소 리스트 조회 */
	public List<TourPlanSpotVO> selectTourSpotList(TourPlanSpotParamVO tourPlanSpotParam);

	/** 여행일정 한개 조회*/
	public TourPlanVO selectTourPlan(int recordNo);

	/** 커버 이미지 파일 조회 */
	public TourPlanCoverVO selectTourPlanCoverByNo(int recordNo);

	/** 커버 이미지 파일 정보 삭제 */
	public void deleteTourPlanCoverByNo(int coverNo);

	/** 커버 이미지 정보 입력 */
	public int insertTourPlanCover(TourPlanCoverVO tourPlanCover);

	/** 여행 일정 업데이트 */
	public void updateTourPlanImgByNo(TourPlanVO tourPlan);

	/** 여행일정 제목 업데이트 */
	public void updateTourPlanTitle(TourPlanVO tourPlan);

	/** 여행일정 업데이트 */
	public void updateTourPlan(TourPlanVO tourPlan);

	/** 여행일정 - 스케쥴 입력 */
	public void insertTourPlanSchedule(TourPlanScheduleVO tourPlanSchedule);

	/** 여행일정 - 스케쥴 삭제 */
	public void deleteTourPlanScheduleByRecordNo(int recordNo);

	/** 여행일정 - 스케쥴 조회 */
	public List<TourPlanScheduleVO> selectTourPlanScheduleListByRecordNo(int recordNo);

	/** 여행지 - 디테일 조회 */
	public TourPlanSpotVO selectSpotDetail(int contentid);

	/** 일정 공개 비공개 */
	public void updateTourPlanOpen(TourPlanVO tourPlan);

	/** 댓글 - 등록 */
	public void insertTourPlanComment(TourPlanCommentVO tourPlanComment);
	
	/** 댓글 - 등록 - 알림*/
	public void insertTourPlanCommentNotification(TourPlanCommentVO tourPlanComment);

	/** 댓글 - 조회 */
	public List<TourPlanCommentVO> selectTourPlanCommentListByRecordNo(int recordNo);

	/** 댓글 - 삭제 */
	public void deleteTourPlanCommentByCommentNo(int commentNo);

	/** 여행일정 - 삭제 */
	public void deleteTourPlanByRecordNo(int recordNo);

	/** 여행일정 추천수순 15개 조회 */
	public List<TourPlanVO> selectTourPlanListByLikeCnt();

	/** 내 여행일정 리스트 조회 */
	public List<TourPlanVO> selectMyTourPlanList(String userUid);

	/** 북마크한 여행일정 리스트 조회 */
	public List<TourPlanVO> selectBookmarkTourPlanList(String userUid);

	/** 북마크한 여행지 총 페이지 조회 */
	public int selectBookmarkSpotTotalPages(TourPlanSpotParamVO tourPlanSpotParam);

	/** 북마크한 여행지 리스트 조회 */
	public List<TourPlanSpotVO> selectBookmarkSpotList(TourPlanSpotParamVO tourPlanSpotParam);

	/** 여행장소 메모 리스트 조회 */
	public List<TourPlanSpotMemoVO> selectTourSpotMemoList(int recordNo);

	/** 여행장소 메모 등록 */
	public void insertTourSpotMemo(TourPlanSpotMemoVO tourPlanSpotMemo);

	/** 여행장소 메모 삭제 */
	public void deleteTourSpotMemoBylocationMemoNo(int scheduleMemoNo);

	/** 여행기 메모 예산 등록 */
	public void insertTourPlanBudget(TravelPriceVO travelPrice);

	/** 예산 하나 삭제 */
	public void deleteTourPlanBudgetByTravelPriceNo(int travelPriceNo);

	/** 메모 삭제시 예산 삭제 */
	public void deleteTourPlanBudgetByScheduleMemoNo(int scheduleMemoNo);

	/** 예산 가져오기(차트) */
	public List<TourPlanBudgetForChartVO> selectBudgetListForChartByRecordNo(int recordNo);

	

}
