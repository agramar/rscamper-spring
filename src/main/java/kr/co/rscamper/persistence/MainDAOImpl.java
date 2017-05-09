package kr.co.rscamper.persistence;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.SubwayVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TrainVO;

@Repository
public class MainDAOImpl implements MainDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.MainMapper";
	
	private static final String Bnamespace = "kr.co.rscamper.BenefitMapper";
	
	private static final String Tnamespace = "kr.co.rscamper.TourPlanMapper";
	
	private static final String Trnamespace = "kr.co.rscamper.TrainMapper";
	
	private static final String TTnamespace = "kr.co.rscamper.SubwayMapper";
	
	@Override
	public void insertMainComment(MainVO vo) {
		sqlSessionTemplate.insert(namespace + ".insertMainComment", vo);
	}

	@Override
	public List<MainVO> selectMainComment() {
		System.out.println("in selectMainComment");
		List<MainVO> list = new ArrayList<>(); 
		list = sqlSessionTemplate.selectList(namespace + ".selectMainComment");
	
		return list;
	}

	@Override
	public List<BenefitVO> list() throws Exception {
		List<BenefitVO> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList(Bnamespace +".selectBenefit");
		return list;
	}

	@Override
	public List<TourPlanSpotVO> tourlist() throws Exception {
		List<TourPlanSpotVO> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList(Tnamespace + ".tourList");
		System.out.println("----------------------------------");
		System.out.println("관광지 :" + list);
		System.out.println("----------------------------------");
		return list;
	}

	@Override
	public List<TrainVO> maintrainList() throws Exception {
		return sqlSessionTemplate.selectList(Trnamespace + ".trainselectList");
	}

	@Override
	public List<SubwayVO> mainTrainTimeList(String deplaceId, String arrPlaceId, String depPlandTime,
			String trainGradeCode, String numOfRows, String pageSize, String pageNo, String startPage)
			throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("deplaceId", deplaceId);
		map.put("arrPlaceId", arrPlaceId);
		map.put("depPlandTime", depPlandTime);
		map.put("trainGradeCode", trainGradeCode);
		map.put("numOfRows", numOfRows);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("startPage", startPage);
		
		return sqlSessionTemplate.selectList(TTnamespace + ".mainTimeList", map);
	}

}
