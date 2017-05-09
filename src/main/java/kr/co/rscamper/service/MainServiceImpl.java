package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.SubwayVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.MainDAO;

@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	private MainDAO dao;
	
	@Override
	public void insertMainComment(MainVO vo) throws Exception {
		dao.insertMainComment(vo);
	}

	@Override
	public List<MainVO> selectMainComment() throws Exception {
		return dao.selectMainComment();
	}

	@Override
	public List<BenefitVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<TourPlanSpotVO> tourlist() throws Exception {
		return dao.tourlist();
	}

	@Override
	public List<TrainVO> maintrainList() throws Exception {
		return dao.maintrainList();
	}

	@Override
	public List<SubwayVO> mainTrainTimeList(String deplaceId, String arrPlaceId, String depPlandTime,
			String trainGradeCode, String numOfRows, String pageSize, String pageNo, String startPage)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.mainTrainTimeList(deplaceId, arrPlaceId, depPlandTime, trainGradeCode, numOfRows, pageSize, pageNo, startPage);
	}




}
