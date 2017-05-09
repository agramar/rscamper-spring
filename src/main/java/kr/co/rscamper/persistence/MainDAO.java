package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.SubwayVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.domain.UserVO;

public interface MainDAO {
	
	public void insertMainComment(MainVO vo);
	public List<MainVO> selectMainComment();
	public List<BenefitVO> list()throws Exception;
	public List<TourPlanSpotVO> tourlist()throws Exception;
	public List<TrainVO> maintrainList()throws Exception;
	public List<SubwayVO> mainTrainTimeList(String deplaceId, String arrPlaceId, String depPlandTime,
			String trainGradeCode, String numOfRows, String pageSize, String pageNo, String startPage)throws Exception;
}
