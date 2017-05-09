package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.TrainMapVO;

public interface TrainMapService {

	public List<TrainMapVO> list()throws Exception;

	public List<TrainMapVO> trainLineMapList()throws Exception;
	
}
