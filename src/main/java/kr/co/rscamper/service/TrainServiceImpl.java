package kr.co.rscamper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.persistence.TrainDAO;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Inject
	private TrainDAO dao;
	
	
	@Override
	public List<TrainVO> list() throws Exception {
		return dao.list();
	}


	@Override
	public String selectDepPlaceId(String depPlaceId) throws Exception {
		return dao.selectDepPlaceId(depPlaceId);
	}


	@Override
	public String selectArrPlaceId(String arrPlaceId) throws Exception {
		return dao.selectArrPlaceId(arrPlaceId);
	}


	@Override
	public List<TrainVO> trainSearch(String stationTitle) throws Exception {
		return dao.trainSearch(stationTitle);
	}





//	@Override
//	public Map<String, Object> detailTrain(TrainVO train) throws Exception {
//		Map<String, Object> result = new HashMap<>();
//		result.put("saemaeul", dao.selectSaemaeul(train));
//		result.put("mugunghwa", dao.selectMugunghwa(train));
//		result.put("tonggeun", dao.selectTonggeun(train));
//		result.put("nuriro", dao.selectNuriro(train));
//		result.put("itxchungchun", dao.selectItxchungchun(train));
//		result.put("itxsaemaeul", dao.selectItxsaemaeul(train));
//		return result;
//	}
//
//	

}
