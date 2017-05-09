package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.TrainVO;

public interface TrainDAO {
	
	public List<TrainVO> list()throws Exception;

	public String selectDepPlaceId(String depPlaceId)throws Exception;

	public String selectArrPlaceId(String arrPlaceId)throws Exception;

	public List<TrainVO> trainSearch(String stationTitle)throws Exception;


//	public String selectSaemaeul(TrainVO train)throws Exception;
//
//	public String selectMugunghwa(TrainVO train)throws Exception;
//
//	public String selectTonggeun(TrainVO train)throws Exception;
//
//	public String selectNuriro(TrainVO train)throws Exception;
//
//	public String selectItxchungchun(TrainVO train)throws Exception;
//
//	public String selectItxsaemaeul(TrainVO train)throws Exception;


}
