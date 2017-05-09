package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.TrainVO;

public interface TrainService {

	public List<TrainVO> list() throws Exception;


	public String selectDepPlaceId(String depPlaceId) throws Exception;

	public String selectArrPlaceId(String arrPlaceId) throws Exception;

	public List<TrainVO> trainSearch(String stationTitle)throws Exception;


//	public Map<String, Object> detailTrain(TrainVO train)throws Exception;

}
