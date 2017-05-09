package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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

@Repository
public class TourPlanDAOImpl implements TourPlanDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.TourPlanMapper";

	@Override
	public List<TourPlanVO> selectTourPlanList(TourPlanParamVO tourPlanParam) {
		return sqlSessionTemplate.selectList(namespace + ".selectTourPlanList", tourPlanParam);
	}

	@Override
	public int selectTourPlanTotalPages(TourPlanParamVO tourPlanParam) {
		return sqlSessionTemplate.selectOne(namespace + ".selectTourPlanTotalPages", tourPlanParam);
	}
	
	@Override
	public int insertTourPlan(TourPlanVO tourPlan) {
		sqlSessionTemplate.insert(namespace + ".insertTourPlan", tourPlan);
		return tourPlan.getRecordNo();
	}

	@Override
	public int selectSpotTotalPages(TourPlanSpotParamVO tourPlanSpotParam) {
		return sqlSessionTemplate.selectOne(namespace + ".selectTourPlanSpotTotalPages", tourPlanSpotParam);
	}

	@Override
	public List<TourPlanSpotVO> selectTourSpotList(TourPlanSpotParamVO tourPlanSpotParam) {
		return sqlSessionTemplate.selectList(namespace + ".selectTourPlanSpotList", tourPlanSpotParam);
	}
	
	@Override
	public int selectBookmarkSpotTotalPages(TourPlanSpotParamVO tourPlanSpotParam) {
		return sqlSessionTemplate.selectOne(namespace + ".selectBookmarkSpotTotalPages", tourPlanSpotParam);
	}

	@Override
	public List<TourPlanSpotVO> selectBookmarkSpotList(TourPlanSpotParamVO tourPlanSpotParam) {
		return sqlSessionTemplate.selectList(namespace + ".selectBookmarkSpotList", tourPlanSpotParam);
	}

	@Override
	public TourPlanVO selectTourPlan(int recordNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectTourPlan", recordNo);
	}
	
	@Override
	public TourPlanCoverVO selectTourPlanCoverByNo(int recordNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectTourPlanCoverByNo", recordNo);
	}

	@Override
	public void deleteTourPlanCoverByNo(int coverNo) {
		sqlSessionTemplate.delete(namespace + ".deleteTourPlanCoverByNo", coverNo);
	}

	@Override
	public int insertTourPlanCover(TourPlanCoverVO tourPlanCover) {
		return sqlSessionTemplate.insert(namespace + ".insertTourPlanCover", tourPlanCover);
	}

	@Override
	public void updateTourPlanImgByNo(TourPlanVO tourPlan) {
		sqlSessionTemplate.update(namespace + ".updateTourPlanImgByNo", tourPlan);
	}

	@Override
	public void updateTourPlanTitle(TourPlanVO tourPlan) {
		sqlSessionTemplate.update(namespace + ".updateTourPlanTitle", tourPlan);
	}

	@Override
	public void updateTourPlan(TourPlanVO tourPlan) {
		sqlSessionTemplate.update(namespace + ".updateTourPlan", tourPlan);
	}

	@Override
	public void insertTourPlanSchedule(TourPlanScheduleVO tourPlanSchedule) {
		sqlSessionTemplate.insert(namespace+ ".insertTourPlanSchedule", tourPlanSchedule);
	}

	@Override
	public void deleteTourPlanScheduleByRecordNo(int recordNo) {
		sqlSessionTemplate.delete(namespace + ".deleteTourPlanScheduleByRecordNo", recordNo);
	}

	@Override
	public List<TourPlanScheduleVO> selectTourPlanScheduleListByRecordNo(int recordNo) {
		return sqlSessionTemplate.selectList(namespace + ".selectTourPlanScheduleListByRecordNo", recordNo);
	}

	@Override
	public TourPlanSpotVO selectSpotDetail(int contentid) {
		return sqlSessionTemplate.selectOne(namespace + ".selectSpotDetail", contentid);
	}

	@Override
	public void updateTourPlanOpen(TourPlanVO tourPlan) {
		sqlSessionTemplate.update(namespace + ".updateTourPlanOpen", tourPlan);
	}

	@Override
	public void insertTourPlanComment(TourPlanCommentVO tourPlanComment) {
		sqlSessionTemplate.insert(namespace + ".insertTourPlanComment", tourPlanComment);
	}
	
	@Override
	public void insertTourPlanCommentNotification(TourPlanCommentVO tourPlanComment) {
		 sqlSessionTemplate.insert(namespace + ".insertTourPlanCommentNotification", tourPlanComment);
	}
	

	@Override
	public List<TourPlanCommentVO> selectTourPlanCommentListByRecordNo(int recordNo) {
		return sqlSessionTemplate.selectList(namespace + ".selectTourPlanCommentListByRecordNo", recordNo);
	}

	@Override
	public void deleteTourPlanCommentByCommentNo(int commentNo) {
		sqlSessionTemplate.delete(namespace+ ".deleteTourPlanCommentByCommentNo", commentNo);
	}

	@Override
	public void deleteTourPlanByRecordNo(int recordNo) {
		sqlSessionTemplate.delete(namespace + ".deleteTourPlanByRecordNo", recordNo);
	}

	@Override
	public List<TourPlanVO> selectTourPlanListByLikeCnt() {
		return sqlSessionTemplate.selectList(namespace + ".selectTourPlanListByLikeCnt");
	}

	@Override
	public List<TourPlanVO> selectMyTourPlanList(String userUid) {
		return sqlSessionTemplate.selectList(namespace + ".selectMyTourPlanList", userUid);
	}

	@Override
	public List<TourPlanVO> selectBookmarkTourPlanList(String userUid) {
		return sqlSessionTemplate.selectList(namespace + ".selectBookmarkTourPlanList", userUid);
	}

	@Override
	public List<TourPlanSpotMemoVO> selectTourSpotMemoList(int recordNo) {
		return sqlSessionTemplate.selectList(namespace + ".selectTourSpotMemoList", recordNo);
	}

	@Override
	public void insertTourSpotMemo(TourPlanSpotMemoVO tourPlanSpotMemo) {
		sqlSessionTemplate.insert(namespace + ".insertTourSpotMemo", tourPlanSpotMemo);
	}

	@Override
	public void deleteTourSpotMemoBylocationMemoNo(int scheduleMemoNo) {
		sqlSessionTemplate.delete(namespace + ".deleteTourSpotMemoBylocationMemoNo", scheduleMemoNo);
	}

	@Override
	public void insertTourPlanBudget(TravelPriceVO travelPrice) {
//		System.out.println(travelPrice.toString());
		sqlSessionTemplate.insert(namespace + ".insertTourPlanBudget", travelPrice);
	}

	@Override
	public void deleteTourPlanBudgetByTravelPriceNo(int travelPriceNo) {
		sqlSessionTemplate.delete(namespace + ".deleteTourPlanBudgetByTravelPriceNo", travelPriceNo);
	}

	@Override
	public void deleteTourPlanBudgetByScheduleMemoNo(int scheduleMemoNo) {
		sqlSessionTemplate.delete(namespace + ".deleteTourPlanBudgetByScheduleMemoNo", scheduleMemoNo);
	}

	@Override
	public List<TourPlanBudgetForChartVO> selectBudgetListForChartByRecordNo(int recordNo) {
		return sqlSessionTemplate.selectList(namespace + ".selectBudgetListForChartByRecordNo", recordNo);
	}


}
